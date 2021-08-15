package com.coforge.bank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.bank.dao.ILoanDao;
import com.coforge.bank.model.Loan;

@Service
public class LoanServiceImpl implements ILoanService {

	@Autowired
	private ILoanDao loanDao;

	@Override
	@Transactional
	public int addLoan(Loan loan) {
		return loanDao.addLoan(loan);
	}

	@Override
	@Transactional
	public List<Loan> getLoan() {
		return loanDao.getLoan();
	}

	@Override
	@Transactional
	public Loan getLoanById(int loanId) {
		return loanDao.getLoanById(loanId);
	}

}
