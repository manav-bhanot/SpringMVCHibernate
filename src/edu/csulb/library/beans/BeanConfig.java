/**
 * 
 */
package edu.csulb.library.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.csulb.library.dao.BookDao;
import edu.csulb.library.dao.impl.BookDaoImpl;
import edu.csulb.library.entity.Book;
import edu.csulb.library.service.BookService;

/**
 * @author Manav
 *
 */

@Configuration
public class BeanConfig {

	@Bean
	public BookService bookService() {
		return new BookService();
	}

	@Bean
	public BookDao<Book> bookDao() {
		return new BookDaoImpl();
	}

}
