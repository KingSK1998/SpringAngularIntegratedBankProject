package com.coforge.bank.dao;

import java.util.List;

import com.coforge.bank.model.Branch;

public interface IBranchDao {
	public int addBranch(Branch branch);

	public void updateBranch(int branchId, Branch branch);

	public List<Branch> getBranch();

	public Branch getBranchById(int branchId);
}
