package com.coforge.bank.service;

import java.util.List;

import com.coforge.bank.model.Bank;

public interface IBankService {
	public int addBank(Bank bank);

	public void updateBank(int bankCode, Bank bank);

	public List<Bank> getBank();

	public Bank getBankByCode(int bankCode);
}
