package com.training.project.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User {

	@Id
	@SequenceGenerator(name="seq", initialValue=12345, allocationSize=100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int userId;

	@NotNull(message = "is required")
	private String name;

	@NotNull(message = "is required")
	private String userName;

	@NotNull(message = "is required")
	private String password;

	private String email;

	private String date;

	@Temporal(TemporalType.DATE)
	private Date expiryDate;

	@OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
			mappedBy = "user")
	List<Book> books;

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int libId) {
		this.userId = libId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public User(String name, String userName, String password, String email, Date expiryDate) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.expiryDate = expiryDate;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


}
