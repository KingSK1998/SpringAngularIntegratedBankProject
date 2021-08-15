package com.coforge.bank.service;

import java.util.List;

import com.coforge.bank.model.Loan;

public interface ILoanService {
	public int addLoan(Loan loan);

	// public boolean updateLoan(int loanId);

	public List<Loan> getLoan();

	public Loan getLoanById(int loanId);
}
