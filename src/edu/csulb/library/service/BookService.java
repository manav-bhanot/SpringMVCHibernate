/**
 * 
 */
package edu.csulb.library.service;

import java.util.List;

import edu.csulb.library.dao.impl.BookDaoImpl;
import edu.csulb.library.entity.Book;

/**
 * @author Manav
 *
 */
public class BookService {
	
	private static BookDaoImpl bookDao;
	
	public BookService() {
		bookDao = new BookDaoImpl();
	}

	public void save(Book book) {
		bookDao.openCurrentSessionWithTransaction();
		bookDao.persist(book);
		bookDao.closeCurrentSessionWithTranscation();
	}

	public void update(Book book) {
		bookDao.openCurrentSessionWithTransaction();
		bookDao.update(book);
		bookDao.closeCurrentSessionWithTranscation();
	}

	public List<Book> getAllBooks() {
		bookDao.openCurrentSession();
		List<Book> allBooks = bookDao.findAllBooks();
		bookDao.closeCurrentSession();

		return allBooks;
	}

	public Book getBookById(String id) {
		bookDao.openCurrentSession();
		Book book = bookDao.findById(id);
		bookDao.closeCurrentSession();

		return book;
	}

	public void deleteBook(String id) {
		bookDao.openCurrentSessionWithTransaction();
		Book book = bookDao.findById(id);
		bookDao.deleteBook(book);
		bookDao.closeCurrentSessionWithTranscation();
	}

	public void deleteAllBooks() {
		bookDao.openCurrentSessionWithTransaction();
		bookDao.deleteAllBooks();
		bookDao.closeCurrentSessionWithTranscation();
	}

	public BookDaoImpl getBookDao() {
		return bookDao;
	}

}
