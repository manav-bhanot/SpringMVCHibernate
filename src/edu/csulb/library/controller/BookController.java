/**
 * 
 */
package edu.csulb.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.csulb.library.model.Book;

/**
 * @author Manav
 *
 */

@Controller
public class BookController {

	@RequestMapping(path = "/viewBooks", method = RequestMethod.GET)
	public ModelAndView displayBooks() {

		// Create a new arraylist to store the list of books fetched from the
		// database.
		List<Book> listOfBooks = new ArrayList<>();

		// Call the book service to get a list of all the books
		// Gets back a list of Book model objects from the service

		// Send back the response to view all the books on a page
		ModelAndView modelAndView = new ModelAndView("viewBooks", "listOfBooks", listOfBooks);
		return modelAndView;

	}

	@RequestMapping(path = "/addBook", method = RequestMethod.POST)
	public ModelAndView addNewBook() {
		ModelAndView modelAndView = new ModelAndView("addBook", "book", new Book());
		return modelAndView;
	}

}
