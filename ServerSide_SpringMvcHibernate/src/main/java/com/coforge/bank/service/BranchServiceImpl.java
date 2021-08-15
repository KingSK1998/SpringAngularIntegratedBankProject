package com.coforge.bank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.bank.dao.IBranchDao;
import com.coforge.bank.model.Branch;

@Service
public class BranchServiceImpl implements IBranchService {

	@Autowired
	private IBranchDao branchDao;

	@Override
	@Transactional
	public int addBranch(Branch branch) {
		return branchDao.addBranch(branch);
	}

	@Override
	@Transactional
	public void updateBranch(int branchId, Branch branch) {
		branchDao.updateBranch(branchId, branch);
	}

	@Override
	@Transactional
	public List<Branch> getBranch() {
		return branchDao.getBranch();
	}

	@Override
	@Transactional
	public Branch getBranchById(int branchId) {
		return branchDao.getBranchById(branchId);
	}

}
