package com.coforge.bank.dao;

import java.util.List;

import com.coforge.bank.model.Bank;

public interface IBankDao {
	public int addBank(Bank bank);

	public void updateBank(int bankCode, Bank bank);

	public List<Bank> getBank();

	public Bank getBankByCode(int bankCode);
}
