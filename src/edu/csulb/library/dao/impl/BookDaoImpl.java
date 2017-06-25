/**
 * 
 */
package edu.csulb.library.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import edu.csulb.library.dao.BookDao;
import edu.csulb.library.entity.Book;
import edu.csulb.library.util.HibernateUtil;

/**
 * @author Manav
 *
 */

public class BookDaoImpl implements BookDao<Book> {

	private Session session;
	// private Transaction tx;

	private SessionFactory sessionFactory;

	public BookDaoImpl() {
	}

	public BookDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void openCurrentSession() {
		// this.session = HibernateUtil.getSesionFactory().openSession();
		this.session = this.sessionFactory.getCurrentSession();
	}

	public void closeCurrentSession() {
		this.session.close();
	}

	public void openCurrentSessionWithTransaction() {
		this.session = HibernateUtil.getSesionFactory().openSession();
		// this.tx = this.session.beginTransaction();
	}

	public void closeCurrentSessionWithTranscation() {
		// this.tx.commit();
		this.session.close();
	}

	@Override
	@Transactional
	public void persist(Book bookEntity) {
		this.session = this.sessionFactory.getCurrentSession();
		this.session.save(bookEntity);
	}

	@Override
	@Transactional
	public void update(Book bookEntity) {
		this.session = this.sessionFactory.getCurrentSession();
		session.update(bookEntity);
	}

	@Override
	public Book findById(long id) {
		Book book = null;
		try {
			this.session = this.sessionFactory.getCurrentSession();
			book = session.get(Book.class, id);
		} finally {
			// session.close();
		}
		
		return book;
	}

	@Override
	@Transactional
	public void deleteBook(Book bookEntity) {
		try {
			this.session = this.sessionFactory.getCurrentSession();
			session.delete(bookEntity);
		} finally {
			// session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Book> findAllBooks() {

		List<Book> allBooks;
		
		try {
			this.session = this.sessionFactory.getCurrentSession();
			allBooks = session.createQuery("from Book").list();
		} finally {
			// session.close();
		}

		return allBooks;
	}
	
	@Override
	@Transactional
	public void deleteAllBooks() {
		openCurrentSession();
		for (Book b : findAllBooks()) {
			deleteBook(b);
		}
		closeCurrentSession();
	}


}
