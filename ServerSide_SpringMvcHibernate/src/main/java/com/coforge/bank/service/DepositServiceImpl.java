package com.coforge.bank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.bank.dao.IDepositDao;
import com.coforge.bank.model.Deposit;

@Service
public class DepositServiceImpl implements IDepositService {

	@Autowired
	private IDepositDao depositDao;

	@Override
	@Transactional
	public int addDeposit(Deposit deposit) {
		return depositDao.addDeposit(deposit);
	}

	@Override
	@Transactional
	public List<Deposit> getDeposit() {
		return depositDao.getDeposit();
	}

	@Override
	@Transactional
	public Deposit getDepositById(int depositId) {
		return depositDao.getDepositById(depositId);
	}

}
