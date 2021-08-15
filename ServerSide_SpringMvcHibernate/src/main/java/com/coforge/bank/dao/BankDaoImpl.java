package com.coforge.bank.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coforge.bank.model.Bank;

@Repository
public class BankDaoImpl implements IBankDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addBank(Bank bank) {
		sessionFactory.getCurrentSession().save(bank);
		return bank.getBankCode();
	}

	@Override
	public void updateBank(int bankCode, Bank bank) {
		Session session = sessionFactory.getCurrentSession();
		Bank oldBank = session.byId(Bank.class).load(bankCode);
		oldBank.setBankName(bank.getBankName());
		oldBank.setBankAddress(bank.getBankAddress());
		session.flush();
	}

	@Override
	public List<Bank> getBank() {
		return sessionFactory.getCurrentSession().createQuery("from Bank", Bank.class).list();
	}

	@Override
	public Bank getBankByCode(int bankCode) {
		return sessionFactory.getCurrentSession().get(Bank.class, bankCode);
	}

}
