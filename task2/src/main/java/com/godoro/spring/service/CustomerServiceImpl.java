package com.godoro.spring.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.godoro.spring.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Override
	public Customer find(long customerId) {
		Customer customer = new Customer(customerId, "Homer Simpson", 1450);
		System.out.println("İsgörü çalıstı");
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customerList = new ArrayList<>();
		customerList.add(new Customer(301, "Homer Simpson", 1450));
		customerList.add(new Customer(302, "Bart Simpson", 6575));
		customerList.add(new Customer(303, "Marge Simpson", 3490));
		return null;
	}

	@Override
	public void createCustomer(Customer customer) {
		customer.setCustomerId(301);
		System.out.println("Müşteri eklendi " + customer.getCustomerId() + " " + customer.getCustomerName() + " " + customer.getTotalDebit());
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		System.out.println("Müşteri güncellendi " + customer.getCustomerId() + " " + customer.getCustomerName() + " " + customer.getTotalDebit());
		
	}

	@Override
	public void deleteCustomer(long customerId) {
		System.out.println("Müşteri silindi " + customerId);
		
	}

}
