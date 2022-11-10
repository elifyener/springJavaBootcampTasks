package com.godoro.spring.service;

import java.util.List;

import com.godoro.spring.Customer;

public interface CustomerService {

	Customer find(long customerId);
	List<Customer> findAll();
	public void createCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(long customerId);
}
