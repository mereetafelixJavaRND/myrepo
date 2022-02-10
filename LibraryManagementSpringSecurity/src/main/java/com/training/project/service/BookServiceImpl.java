package com.training.project.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.dao.BookDao;
import com.training.project.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;

	@Override
	@Transactional
	public void save(Book book) {

		bookDao.save(book);

	}

	@Override
	@Transactional
	public void deleteBook(int id) {

		bookDao.deleteById(id);

	}

	@Override
	@Transactional
	public Optional<Book> getBookById(int id) {

		return bookDao.findById(id);

	}



	@Override
	public Iterable<Book> getAllBooks() {

		return bookDao.findAll();

	}

}
