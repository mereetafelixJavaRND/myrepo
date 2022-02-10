package com.training.project.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.project.model.Book;

@Repository
public interface BookDao extends CrudRepository<Book, Integer>{

}
