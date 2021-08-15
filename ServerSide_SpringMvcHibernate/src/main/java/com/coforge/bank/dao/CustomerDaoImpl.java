package com.coforge.bank.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coforge.bank.model.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public String addCustomer(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
		return customer.getCustomerId();
	}

	@Override
	public void updateCustomer(String customerId, Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		Customer oldCustomer = session.byId(Customer.class).load(customerId);
		oldCustomer.setCustomerName(customer.getCustomerName());
		oldCustomer.setCustomerPhone(oldCustomer.getCustomerPhone());
		oldCustomer.setCustomerEmail(oldCustomer.getCustomerEmail());
		oldCustomer.setCustomerAddress(oldCustomer.getCustomerAddress());
		oldCustomer.setPancard(oldCustomer.getPancard());
		session.flush();
	}

	@Override
	public List<Customer> getCustomer() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		return query.list();
	}

	@Override
	public Customer getCustomerById(String customerId) {
		return sessionFactory.getCurrentSession().get(Customer.class, customerId);
	}

}
