package com.coforge.bank.service;

import java.util.List;

import com.coforge.bank.model.Branch;

public interface IBranchService {
	public int addBranch(Branch branch);

	public void updateBranch(int branchId, Branch branch);

	public List<Branch> getBranch();

	public Branch getBranchById(int branchId);
}
