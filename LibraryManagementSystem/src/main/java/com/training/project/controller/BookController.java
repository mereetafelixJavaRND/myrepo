package com.training.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.project.model.Book;
import com.training.project.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("getBook")
	public String getBook(Model model) {

		model.addAttribute("book", new Book());
		return "add-book";

	}

	@GetMapping("list")
	public String showBookList(Model model) {

		List<Book> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		return "book-list";

	}

	@GetMapping("getBookList")
	public String getBookList(Model model) {

		List<Book> books = bookService.getAllBooks();
		System.out.println(books);
		model.addAttribute("books", books);
		return "delete-update";

	}

	@GetMapping("deleteBook")
	public String deleteBook(@RequestParam("id") int id) {

		bookService.deleteBook(id);
		return "redirect:/getBookList";

	}

	@GetMapping("showFormForUpdateBook")
	public String showFormForUpdate(Model model, @RequestParam("id") int id) {

		Book book = bookService.getBookById(id);
		model.addAttribute("book", book);
		return "display-add-book";

	}

	@PostMapping("addBook")
	public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {

		bookService.saveOrUpdate(book);
		if(result.hasErrors()) {

			return "add-book";

		} else {

			return "redirect:/getBookList";

		}
	}

	@GetMapping("issueBookForm")
	public String issueBookForm(@RequestParam("id") int id, Model model) {

		Book book = bookService.getBookForIssue(id);
		model.addAttribute("book", book);
		return "issue-book";

	}

	@PostMapping("issueBook")
	public String issueBook( @ModelAttribute("book") Book book) {

		bookService.issueBook(book);
		return "redirect:/list";

	}

	@GetMapping("showFormForReturn")
	public String showFormForReturn(Model model, @RequestParam("id") int id) {

		Book book = bookService.getBookForIssueReturn(id);
		model.addAttribute("book", book);
		return "return-book";

	}

	@PostMapping("return")
	public String returnBook( @ModelAttribute("book") Book book) {

		bookService.returnBook(book);
		return "redirect:/list";

	}
}
