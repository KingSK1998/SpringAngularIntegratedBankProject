package com.coforge.bank.service;

import java.util.List;

import com.coforge.bank.model.Account;

public interface IAccountService {
	public int addAccount(Account account);

	// public void updateAccount(int accountNo, Account account);

	public Account getAccountByNo(int accountNo);

	public List<Account> getAccount();
}
