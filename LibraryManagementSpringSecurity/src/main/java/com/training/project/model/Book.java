package com.training.project.model;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Book {

	@Id
	@SequenceGenerator(name="seq", initialValue=101, allocationSize=100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int id;

	@NotNull(message = "is required")
	private String title;

	@NotNull(message = "is required")
	private Integer year;

	@NotNull(message = "is required")
	private String isbn;

	private Integer availableNo;

	@ManyToOne
	private User user;

	@OneToOne(cascade = CascadeType.ALL)
	private Fine fine;

	@ManyToOne(cascade = CascadeType.ALL)
	private Publisher publisher;

	@ManyToOne(cascade = CascadeType.ALL)
	private Author author;

	public Fine getFine() {
		return fine;
	}

	public void setFine(Fine fine) {
		this.fine = fine;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getAvailableNo() {
		return availableNo;
	}

	public void setAvailableNo(Integer availableNo) {
		this.availableNo = availableNo;
	}

	public Book(String title, int year, String isbn, int availableNo) {
		super();
		this.title = title;
		this.year = year;
		this.isbn = isbn;
		this.availableNo = availableNo;
	}

	public Book() {
		super();

	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", year=" + year + ", isbn=" + isbn + ", availableNo="
				+ availableNo + ", user=" + user + ", fine=" + fine + ", publisher=" + publisher + ", author=" + author
				+ "]";
	}

}
