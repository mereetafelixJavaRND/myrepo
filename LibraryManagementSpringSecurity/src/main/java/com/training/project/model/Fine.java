package com.training.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fine {

	@Override
	public String toString() {
		return "Fine [fineId=" + fineId + ", paymentDate=" + paymentDate + ", amount=" + amount + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fineId;
	private String paymentDate;
	private long amount;

	public int getFineId() {
		return fineId;
	}

	public void setFineId(int fineId) {
		this.fineId = fineId;
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

	}

}
