package com.coforge.bank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.bank.dao.IAccountDao;
import com.coforge.bank.model.Account;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountDao accountDao;

	@Override
	@Transactional
	public int addAccount(Account account) {
		return accountDao.addAccount(account);
	}

	// @Override
	// @Transactional
	// public void updateAccount(int accountNo, Account account) {
	// accountDao.updateAccount(accountNo, account);
	// }

	@Override
	@Transactional
	public List<Account> getAccount() {
		return accountDao.getAccounts();
	}

	@Override
	@Transactional
	public Account getAccountByNo(int accountNo) {
		return accountDao.getAccountByNo(accountNo);
	}

}
