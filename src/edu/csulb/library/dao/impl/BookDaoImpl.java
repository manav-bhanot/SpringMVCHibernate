/**
 * 
 */
package edu.csulb.library.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.csulb.library.dao.BookDao;
import edu.csulb.library.entity.Book;
import edu.csulb.library.util.HibernateUtil;

/**
 * @author Manav
 *
 */
public class BookDaoImpl implements BookDao<Book, String> {

	private Session session;
	private Transaction tx;

	public BookDaoImpl() {
	}

	public void openCurrentSession() {
		this.session = HibernateUtil.getSesionFactory().openSession();
	}

	public void closeCurrentSession() {
		this.session.close();
	}

	public void openCurrentSessionWithTransaction() {
		this.session = HibernateUtil.getSesionFactory().openSession();
		this.tx = this.session.beginTransaction();
	}

	public void closeCurrentSessionWithTranscation() {
		this.tx.commit();
		this.session.close();
	}

	@Override
	public void persist(Book bookEntity) {
		this.session.save(bookEntity);
	}

	@Override
	public void update(Book bookEntity) {
		session.update(bookEntity);
	}

	@Override
	public Book findById(String id) {
		Book book = null;
		try {
			book = session.get(Book.class, id);
		} finally {
			// session.close();
		}
		
		return book;
	}

	@Override
	public void deleteBook(Book bookEntity) {
		try {
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
