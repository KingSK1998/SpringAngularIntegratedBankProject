package com.coforge.bank.service;

import java.util.List;

import com.coforge.bank.model.BankEmployee;

public interface IBankEmployeeService {
	public String addBankEmployee(BankEmployee bankEmployee);

	public void updateBankEmployee(String employeeId, BankEmployee bankEmployee);

	public List<BankEmployee> getBankEmployee();

	public BankEmployee getBankEmployeeById(String employeeId);

	public BankEmployee getBankEmployeeByEmail(String employeeEmail);
}
