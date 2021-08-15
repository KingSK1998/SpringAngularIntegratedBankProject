package com.coforge.bank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.bank.dao.IBankEmployeeDao;
import com.coforge.bank.model.BankEmployee;

@Service
public class BankEmployeeServiceImpl implements IBankEmployeeService {

	@Autowired
	private IBankEmployeeDao bankEmployeeDao;

	@Override
	@Transactional
	public String addBankEmployee(BankEmployee bankEmployee) {
		return bankEmployeeDao.addBankEmployee(bankEmployee);
	}

	@Override
	@Transactional
	public void updateBankEmployee(String employeeId, BankEmployee bankEmployee) {
		bankEmployeeDao.updateBankEmployee(employeeId, bankEmployee);
	}

	@Override
	@Transactional
	public List<BankEmployee> getBankEmployee() {
		return bankEmployeeDao.getBankEmployee();
	}

	@Override
	@Transactional
	public BankEmployee getBankEmployeeById(String employeeId) {
		return bankEmployeeDao.getBankEmployeeById(employeeId);
	}

	@Override
	@Transactional
	public BankEmployee getBankEmployeeByEmail(String employeeEmail) {
		return bankEmployeeDao.getBankEmployeeByEmail(employeeEmail);
	}
}
