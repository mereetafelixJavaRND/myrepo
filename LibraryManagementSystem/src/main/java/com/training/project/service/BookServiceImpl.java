package com.training.project.service;





import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.dao.BookDao;
import com.training.project.model.Book;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;

	@Override
	@Transactional
	public void saveOrUpdate(Book book) {

		bookDao.saveOrUpdate(book);
	}

	@Override
	@Transactional
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookDao.getAllBooks();
	}

	@Override
	@Transactional
	public void deleteBook(int id) {
		bookDao.deleteBook(id);

	}

	@Override
	@Transactional
	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

	@Override
	@Transactional
	public Book getBookForIssueReturn(int id) {
		return bookDao.getBookForIssueReturn(id);
	}

	@Override
	@Transactional
	public void issueBook(Book book) {
		bookDao.issueBook(book);

	}

	@Override
	@Transactional
	public void returnBook(Book book) {
		bookDao.returnBook(book);
	}

	@Override
	@Transactional
	public Book getBookForIssue(int id) {
		return bookDao.getBookForIssue(id);
	}

}
