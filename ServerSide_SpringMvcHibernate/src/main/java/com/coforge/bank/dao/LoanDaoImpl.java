package com.coforge.bank.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coforge.bank.model.Loan;

@Repository
public class LoanDaoImpl implements ILoanDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addLoan(Loan loan) {
		sessionFactory.getCurrentSession().save(loan);
		return loan.getLoanId();
	}

	@Override
	public List<Loan> getLoan() {
		Session session = sessionFactory.getCurrentSession();
		Query<Loan> query = session.createQuery("from Loan", Loan.class);
		return query.list();
	}

	@Override
	public Loan getLoanById(int loanId) {
		return sessionFactory.getCurrentSession().get(Loan.class, loanId);
	}

}
