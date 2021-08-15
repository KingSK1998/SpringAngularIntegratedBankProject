package com.coforge.bank.service;

import java.util.List;

import com.coforge.bank.model.Customer;

public interface ICustomerService {
	public String addCustomer(Customer customer);

	public void updateCustomer(String customerId, Customer customer);

	public List<Customer> getCustomer();

	public Customer getCustomerById(String string);
}
