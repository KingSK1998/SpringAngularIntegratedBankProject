package com.coforge.bank.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coforge.bank.model.Account;

@Repository
public class AccountDaoImpl implements IAccountDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addAccount(Account account) {
		sessionFactory.getCurrentSession().save(account);
		return account.getAccountNo();
	}

	// @Override
	// public void updateAccount(int accountNo, Account account) {
	// Session session = sessionFactory.getCurrentSession();
	// Account oldAccount = session.byId(Account.class).load(accountNo);
	// oldAccount.set
	// session.flush();
	// }

	@Override
	public List<Account> getAccounts() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaQuery<Account> criteriaQuery = session.getCriteriaBuilder().createQuery(Account.class);
		Root<Account> root = criteriaQuery.from(Account.class);
		criteriaQuery.select(root);
		return session.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public Account getAccountByNo(int accountNo) {
		return sessionFactory.getCurrentSession().get(Account.class, accountNo);
	}

}
