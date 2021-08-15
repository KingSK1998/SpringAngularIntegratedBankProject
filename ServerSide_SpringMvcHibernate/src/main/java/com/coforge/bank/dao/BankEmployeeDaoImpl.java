package com.coforge.bank.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coforge.bank.model.BankEmployee;

@Repository
public class BankEmployeeDaoImpl implements IBankEmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public String addBankEmployee(BankEmployee bankEmployee) {
		sessionFactory.getCurrentSession().save(bankEmployee);
		return bankEmployee.getEmployeeId();
	}

	@Override
	public void updateBankEmployee(String employeeId, BankEmployee bankEmployee) {
		Session session = sessionFactory.getCurrentSession();
		BankEmployee oldEmployee = session.byId(BankEmployee.class).load(employeeId);
		oldEmployee.setEmployeeEmail(bankEmployee.getEmployeeEmail());
		oldEmployee.setEmployeeName(bankEmployee.getEmployeeName());
		oldEmployee.setEmployeePhone(bankEmployee.getEmployeePhone());
		oldEmployee.setEmployeeRole(bankEmployee.getEmployeeRole());
		session.flush();
	}

	@Override
	public List<BankEmployee> getBankEmployee() {
		Session session = sessionFactory.getCurrentSession();
		Query<BankEmployee> query = session.createQuery("from BankEmployee", BankEmployee.class);
		return query.list();
	}

	@Override
	public BankEmployee getBankEmployeeById(String employeeId) {
		return sessionFactory.getCurrentSession().get(BankEmployee.class, employeeId);
	}

	@Override
	public BankEmployee getBankEmployeeByEmail(String employeeEmail) {
		Session session = sessionFactory.getCurrentSession();
		Query<BankEmployee> employee = session.createQuery("from BankEmployee where employeeEmail=:email",
				BankEmployee.class);
		employee.setParameter("email", employeeEmail);
		return employee.getSingleResult();
	}
}
