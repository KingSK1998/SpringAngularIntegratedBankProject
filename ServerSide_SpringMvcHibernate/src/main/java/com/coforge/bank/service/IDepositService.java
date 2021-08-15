package com.coforge.bank.service;

import java.util.List;

import com.coforge.bank.model.Deposit;

public interface IDepositService {
	public int addDeposit(Deposit deposit);

	// public boolean updateDeposit(int depositId);

	public List<Deposit> getDeposit();

	public Deposit getDepositById(int depositId);
}
