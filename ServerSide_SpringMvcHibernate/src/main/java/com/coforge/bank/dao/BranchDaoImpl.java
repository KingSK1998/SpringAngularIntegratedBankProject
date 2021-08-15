package com.coforge.bank.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coforge.bank.model.Branch;

@Repository
public class BranchDaoImpl implements IBranchDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addBranch(Branch branch) {
		sessionFactory.getCurrentSession().save(branch);
		return branch.getBranchId();
	}

	@Override
	public void updateBranch(int branchId, Branch branch) {
		Session session = sessionFactory.getCurrentSession();
		Branch oldBranch = session.byId(Branch.class).load(branchId);
		oldBranch.setBranchName(branch.getBranchName());
		oldBranch.setBranchAddress(branch.getBranchAddress());
		session.flush();
	}

	@Override
	public List<Branch> getBranch() {
		Session session = sessionFactory.getCurrentSession();
		Query<Branch> query = session.createQuery("from Branch", Branch.class);
		return query.list();
	}

	@Override
	public Branch getBranchById(int branchId) {
		return sessionFactory.getCurrentSession().get(Branch.class, branchId);
	}

}
