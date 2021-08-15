package com.coforge.bank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.bank.dao.IBankDao;
import com.coforge.bank.model.Bank;

@Service
public class BankServiceImpl implements IBankService {

	@Autowired
	private IBankDao bankDao;

	@Override
	@Transactional
	public int addBank(Bank bank) {
		return bankDao.addBank(bank);
	}

	@Override
	@Transactional
	public void updateBank(int bankCode, Bank bank) {
		bankDao.updateBank(bankCode, bank);
	}

	@Override
	@Transactional
	public List<Bank> getBank() {
		return bankDao.getBank();
	}

	@Override
	@Transactional
	public Bank getBankByCode(int bankId) {
		return bankDao.getBankByCode(bankId);
	}

}
