package com.training.project.model;

public class Product {
	
	private int productId;
	private String userName;
	private String productName;
	private int price;
	private String vendor;
	private int quantity;
	private int warranty;

	public int getProductId() {
	
		return productId;
	
	}

	public void setProductId(int productId) {
	
		this.productId = productId;
	
	}

	public String getProductName() {
	
		return productName;
	
	}

	public void setProductName(String productName) {
	
		this.productName = productName;
	
	}

	public int getPrice() {
	
		return price;
	
	}

	public void setPrice(int price) {
	
		this.price = price;
	
	}

	public String getVendor() {
	
		return vendor;
	
	}

	public void setVendor(String vendor) {
	
		this.vendor = vendor;
	
	}

	public int getQuantity() {
	
		return quantity;
	
	}

	public void setQuantity(int quantity) {
		
		this.quantity = quantity;
	
	}
	
	public int getWarranty() {
	
		return warranty;
	
	}

	public void setWarranty(int warranty) {
	
		this.warranty = warranty;
	
	}

	public String getUserName() {
	
		return userName;
	
	}

	public void setUserName(String userName) {
	
		this.userName = userName;
	
	}
}
