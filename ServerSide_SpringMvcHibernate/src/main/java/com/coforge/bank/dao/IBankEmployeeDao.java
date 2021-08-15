package com.coforge.bank.dao;

import java.util.List;

import com.coforge.bank.model.BankEmployee;

public interface IBankEmployeeDao {
	public String addBankEmployee(BankEmployee bankEmployee);

	public void updateBankEmployee(String employeeCode, BankEmployee bankEmployee);

	public List<BankEmployee> getBankEmployee();

	public BankEmployee getBankEmployeeById(String employeeId);

	public BankEmployee getBankEmployeeByEmail(String employeeEmail);
}
