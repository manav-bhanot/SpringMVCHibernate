/**
 * 
 */
package edu.csulb.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.csulb.library.model.BookTO;
import edu.csulb.library.service.BookService;

/**
 * @author Manav
 *
 */

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(path = "/viewBooks", method = RequestMethod.GET)
	public ModelAndView displayBooks() {

		// Call the book service to get a list of all the books
		// Gets back a list of Book model objects from the service
		List<BookTO> listOfBooks = bookService.getAllBooks();

		// Send back the response to view all the books on a page
		ModelAndView modelAndView = new ModelAndView("viewBooks", "listOfBooks", listOfBooks);
		return modelAndView;

	}

	@RequestMapping("/addBook")
	public ModelAndView addNewBook() {
		ModelAndView modelAndView = new ModelAndView("addBook", "book", new BookTO());
		return modelAndView;
	}

	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public ModelAndView saveBook(@ModelAttribute("book") BookTO bookTO, BindingResult res, ModelMap mMap) {

		if (res.hasErrors()) {
			// return "error";
		}

		bookService.save(bookTO);

		String successMessage = "Book with title : " + bookTO.getTitle() + " is successfully saved in the database";

		ModelAndView modelAndView = new ModelAndView("success", "successMessage", successMessage);
		return modelAndView;
	}

}
