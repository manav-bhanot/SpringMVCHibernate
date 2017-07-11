/**
 * 
 */
package edu.csulb.library.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

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
	@Scope(value = WebApplicationContext.SCOPE_REQUEST)
	public BookService bookService() {
		return new BookService();
	}

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST)
	public BookDao<Book> bookDao() {
		return new BookDaoImpl();
	}

}
