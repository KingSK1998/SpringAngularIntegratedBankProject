package com.coforge.bank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.bank.dao.ICustomerDao;
import com.coforge.bank.model.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao customerDao;

	@Override
	@Transactional
	public String addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	@Override
	@Transactional
	public void updateCustomer(String customerId, Customer customer) {
		customerDao.updateCustomer(customerId, customer);
	}

	@Override
	@Transactional
	public List<Customer> getCustomer() {
		return customerDao.getCustomer();
	}

	@Override
	@Transactional
	public Customer getCustomerById(String customerId) {
		return customerDao.getCustomerById(customerId);
	}

}
