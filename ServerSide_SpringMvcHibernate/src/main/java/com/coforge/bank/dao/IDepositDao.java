package com.coforge.bank.dao;

import java.util.List;

import com.coforge.bank.model.Deposit;

public interface IDepositDao {
	public int addDeposit(Deposit deposit);

	public List<Deposit> getDeposit();

	public Deposit getDepositById(int depositId);
}
