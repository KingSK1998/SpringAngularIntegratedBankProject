package com.coforge.bank.dao;

import java.util.List;

import com.coforge.bank.model.Loan;

public interface ILoanDao {
	public int addLoan(Loan loan);

	public List<Loan> getLoan();

	public Loan getLoanById(int loanId);
}
