package com.coforge.bank.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coforge.bank.model.Deposit;

@Repository
public class DepositDaoImpl implements IDepositDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addDeposit(Deposit deposit) {
		sessionFactory.getCurrentSession().save(deposit);
		return deposit.getDepositId();
	}

	@Override
	public List<Deposit> getDeposit() {
		Session session = sessionFactory.getCurrentSession();
		Query<Deposit> query = session.createQuery("from Deposit", Deposit.class);
		return query.list();
	}

	@Override
	public Deposit getDepositById(int depositId) {
		return sessionFactory.getCurrentSession().get(Deposit.class, depositId);
	}

}
