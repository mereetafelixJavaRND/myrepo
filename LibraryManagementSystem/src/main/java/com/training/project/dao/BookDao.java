package com.training.project.dao;

import java.util.List;

import com.training.project.model.Book;

public interface BookDao {
	public void saveOrUpdate(Book book);

	public List<Book> getAllBooks();

	public void deleteBook(int id);

	public Book getBookById(int id);

	public Book getBookForIssueReturn(int id);

	public void issueBook(Book book);

	public void returnBook(Book book);

	public Book getBookForIssue(int id);

}
