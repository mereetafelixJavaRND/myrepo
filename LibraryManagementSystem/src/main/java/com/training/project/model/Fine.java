package com.training.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fineId;
	private String paymentDate;
	private long amount;

	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private User user;

	public int getFineId() {
		return fineId;
	}
	public void setFineId(int fineId) {
		this.fineId = fineId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public Fine(String paymentDate, long amount) {
		super();
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	public Fine() {
		super();
		// TODO Auto-generated constructor stub
	}
}
