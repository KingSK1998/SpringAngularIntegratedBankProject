package com.coforge.bank.dao;

import java.util.List;

import com.coforge.bank.model.Account;

public interface IAccountDao {
	public int addAccount(Account account);

	// public void updateAccount(int accountNo, Account account);

	public Account getAccountByNo(int accountNo);

	public List<Account> getAccounts();
}
