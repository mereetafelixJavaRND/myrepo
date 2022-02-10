package com.training.project.model;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int publishId;
	private String name;

	@OneToMany(cascade = CascadeType.ALL,
			mappedBy = "publisher")
	List<Book> books;
	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Publisher(String name) {
		super();
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public int getPublishId() {
		return publishId;
	}
	public void setPublishId(int publishId) {
		this.publishId = publishId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
