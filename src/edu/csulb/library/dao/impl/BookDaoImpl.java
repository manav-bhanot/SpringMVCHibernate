/**
 * 
 */
package edu.csulb.library.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import edu.csulb.library.dao.BookDao;
import edu.csulb.library.entity.Book;

/**
 * @author Manav
 *
 */

@Transactional
public class BookDaoImpl implements BookDao<Book> {

	private Session session;

	@Autowired
	private SessionFactory sessionFactory;

	public BookDaoImpl() {
	}

	@Override
	public void persist(Book bookEntity) {
		this.session = this.sessionFactory.getCurrentSession();
		this.session.save(bookEntity);
	}

	@Override
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
	public void deleteAllBooks() {
		for (Book b : findAllBooks()) {
			deleteBook(b);
		}
	}
}
