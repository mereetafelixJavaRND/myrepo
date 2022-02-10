package com.training.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.training.project.model.Book;
import com.training.project.model.Fine;
import com.training.project.service.BookService;

@RestController
@RequestMapping("/api/v1/lms" )
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/book")
	public List<Book> getBookList() {

		Iterable<Book>itrEnquiry = bookService.getAllBooks();
		List<Book>enqList = new ArrayList<Book>();
		itrEnquiry.forEach(e -> {

			enqList.add(e);

		});

		return enqList;

	}

	@PostMapping("/add-book")
	public ResponseEntity<String> addBook(@Valid @RequestBody Book book) {

		book.setId(0);
		book.getPublisher().setPublishId(0);
		book.getAuthor().setAuthorId(0);
		bookService.save(book);
		return new ResponseEntity<>("Book Added Successfully!!"+new Gson().toJson(book), HttpStatus.OK);

	}

	@PutMapping("/update-book/{id}")
	public ResponseEntity<String> updateBook(@PathVariable int id, @Valid @RequestBody Book book) {

		Optional<Book> bookOpt = bookService.getBookById(id);
		Book book1 = bookOpt.get();
		if(book1 == null){

			return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);

		}

		bookService.save(book);
		return new ResponseEntity<>("Book Updated Successfully!!"+new Gson().toJson(book), HttpStatus.OK);

	}

	@DeleteMapping("/delete-book/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable int id){

		Optional<Book> bookOpt = bookService.getBookById(id);
		Book book = bookOpt.get();
		if(book == null){

			return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);

		}

		bookService.deleteBook(id);
		return new ResponseEntity<>("Book Deleted Successfully!!", HttpStatus.OK);

	}

	@PutMapping("/issue-book/{id}")
	public ResponseEntity<String> issueBook(@PathVariable int id,@Valid @RequestBody Book book) {

		Optional<Book> bookOpt = bookService.getBookById(id);
		Book book1 = bookOpt.get();
		if(book1 == null || book1.getAvailableNo() == 0) {

			return new ResponseEntity<>("Book issue not possible", HttpStatus.BAD_REQUEST);

		}
		int n;
		n = book1.getAvailableNo()-1;
		book.setAvailableNo(n);
		bookService.save(book);
		return new ResponseEntity<>("Book Issued Successfully!!"+new Gson().toJson(book), HttpStatus.OK);

	}

	@PutMapping("/return-book/{id}")
	public ResponseEntity<String> returnBook(@PathVariable int id,@Valid @RequestBody Book book) {

		Optional<Book> bookOpt = bookService.getBookById(id);
		Book book1 = bookOpt.get();
		if(book1 == null) {

			return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);

		}
		int n;
		if(book.getUser().getDate().compareTo(book1.getUser().getDate()) <= 0 ) {

			n = book.getAvailableNo()+1;
			book1.setId(book1.getId());
			book1.setAvailableNo(n);
			book1.setUser(null);
			bookService.save(book1);

		}else {

			SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd");
			try {

				Date date1 = obj.parse(book.getUser().getDate());
				Date date2 = obj.parse(book1.getUser().getDate());
				long timeDifference = date1.getTime() - date2.getTime();
				long daysDifference = TimeUnit.MILLISECONDS.toDays(timeDifference) % 365;
				long fine = daysDifference*10;
				String date = book.getUser().getDate();
				Fine fineobj = new Fine(date,fine);
				n = book1.getAvailableNo()+1;
				book1.setFine( fineobj);
				book1.setId(book1.getId());
				book1.setAvailableNo(n);
				book1.setUser(null);
				bookService.save(book1);

			} catch (ParseException e) {

				e.printStackTrace();

			}

		}
		return new ResponseEntity<>("Book Returned Successfully!!"+new Gson().toJson(book1), HttpStatus.OK);

	}

}
