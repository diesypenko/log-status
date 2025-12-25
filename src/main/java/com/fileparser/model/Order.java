package com.fileparser.model;

import java.util.List;

public class Order {

	private String id;
	private Customer customer;
	private List<String> tags;
	private String status;
	private double amount;
	
	public Order() {}

	public Order(String id, Customer customer, List<String> tags, String status, double amount) {
		super();
		this.id = id;
		this.customer = customer;
		this.tags = tags;
		this.status = status;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<String> getTags() {
		return tags;
	}

	public String getStatus() {
		return status;
	}

	public double getAmount() {
		return amount;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	

}
