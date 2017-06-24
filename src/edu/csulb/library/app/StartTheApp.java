/**
 * 
 */
package edu.csulb.library.app;

import java.util.List;

import edu.csulb.library.entity.Book;
import edu.csulb.library.service.BookService;

/**
 * @author Manav
 *
 */
public class StartTheApp {
	public static void main(String[] args) {
		BookService bookService = new BookService();

		Book book1 = new Book("1", "The Brothers Karamazov", "Fyodor Dostoevsky");
		Book book2 = new Book("2", "War and Peace", "Leo Tolstoy");
		Book book3 = new Book("3", "Pride and Prejudice", "Jane Austen");

		System.out.println("*** Persist - start ***");
		bookService.save(book1);
		bookService.save(book2);
		bookService.save(book3);

		List<Book> books1 = bookService.getAllBooks();
		System.out.println("Books Persisted are :");
		for (Book b : books1) {
			System.out.println("-" + b.toString());
		}
		System.out.println("*** Persist - end ***");

		System.out.println("*** Update - start ***");
		book1.setTitle("The Idiot");
		bookService.update(book1);
		System.out.println("Book Updated is =>" + bookService.getBookById(book1.getId()).toString());
		System.out.println("*** Update - end ***");

		System.out.println("*** Find - start ***");
		String id1 = book1.getId();
		Book another = bookService.getBookById(id1);
		System.out.println("Book found with id " + id1 + " is =>" + another.toString());
		System.out.println("*** Find - end ***");

		System.out.println("*** Delete - start ***");
		String id3 = book3.getId();
		bookService.deleteBook(id3);
		System.out.println("Deleted book with id " + id3 + ".");
		System.out.println("Now all books are " + bookService.getAllBooks().size() + ".");
		System.out.println("*** Delete - end ***");

		System.out.println("*** FindAll - start ***");
		List<Book> books2 = bookService.getAllBooks();
		System.out.println("Books found are :");
		for (Book b : books2) {
			System.out.println("-" + b.toString());
		}
		System.out.println("*** FindAll - end ***");

		System.out.println("*** DeleteAll - start ***");
		bookService.deleteAllBooks();
		System.out.println("Books found are now " + bookService.getAllBooks().size());
		System.out.println("*** DeleteAll - end ***");
		System.exit(0);
	}
}
