package com.coforge.bank.dao;

import java.util.List;

import com.coforge.bank.model.Customer;

public interface ICustomerDao {
	public String addCustomer(Customer customer);

	public void updateCustomer(String customerId, Customer customer);

	public List<Customer> getCustomer();

	public Customer getCustomerById(String customerId);
}
