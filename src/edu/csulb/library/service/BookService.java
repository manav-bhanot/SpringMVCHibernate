/**
 * 
 */
package edu.csulb.library.service;

import java.util.ArrayList;
import java.util.List;

import edu.csulb.library.dao.BookDao;
import edu.csulb.library.entity.Book;
import edu.csulb.library.model.BookTO;

/**
 * @author Manav
 *
 */
public class BookService {
	
	private BookDao<Book> bookDao;
	
	public BookService() {
	}

	public BookService(BookDao<Book> bookDao) {
		this.bookDao = bookDao;
	}

	public long save(BookTO bookTO) {

		Book book = bookTO.copyTransferObjectToEntity();

		bookDao.persist(book);
		return book.getId();
	}

	public void update(BookTO bookTO) {

		Book book = bookTO.copyTransferObjectToEntity();
		bookDao.update(book);
	}

	public List<BookTO> getAllBooks() {

		List<BookTO> listOfBooks = new ArrayList<BookTO>();

		for (Book b : bookDao.findAllBooks()) {
			BookTO bookTO = new BookTO();
			bookTO.copyEntityToTransferObject(b);
			listOfBooks.add(bookTO);
		}

		return listOfBooks;
	}

	public BookTO getBookById(long id) {

		Book book = bookDao.findById(id);

		BookTO bookTO = new BookTO();
		bookTO.copyEntityToTransferObject(book);

		return bookTO;
	}

	public void deleteBook(long id) {
		Book book = bookDao.findById(id);
		bookDao.deleteBook(book);
	}

	public void deleteAllBooks() {
		bookDao.deleteAllBooks();
	}

}
