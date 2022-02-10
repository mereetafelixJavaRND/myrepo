package com.training.project.service;

import java.util.Optional;

import com.training.project.model.Book;

public interface BookService {

	public void save(Book book);

	public void deleteBook(int id);

	public Optional<Book> getBookById(int id);

	public Iterable<Book> getAllBooks();

}
