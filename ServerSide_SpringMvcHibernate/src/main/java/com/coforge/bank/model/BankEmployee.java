package com.coforge.bank.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bankEmployee")
public class BankEmployee {
	@Id
	@Column(columnDefinition = "varchar(50)", unique = true)
	private String employeeId;

	@Column(name = "employeeName")
	private String employeeName;

	@Column(name = "employeePhone")
	private String employeePhone;

	@Column(name = "employeeEmail")
	private String employeeEmail;

	@Column(name = "addressProofIdType")
	private String addressProofIdType;

	@Column(name = "addressProofIdNo", columnDefinition = "varchar(50)", unique = true)
	private String addressProofIdNo;

	@Column(name = "employeeRole")
	private String employeeRole;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "branchId")
	private Branch branch;

	public BankEmployee() {
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
		// this.employeeId = getAddressProofIdNo();
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getAddressProofIdType() {
		return addressProofIdType;
	}

	public void setAddressProofIdType(String addressProofIdType) {
		this.addressProofIdType = addressProofIdType;
	}

	public String getAddressProofIdNo() {
		return addressProofIdNo;
	}

	public void setAddressProofIdNo(String addressProofIdNo) {
		this.addressProofIdNo = addressProofIdNo;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "BankEmployee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeePhone="
				+ employeePhone + ", employeeEmail=" + employeeEmail + ", addressProofIdType=" + addressProofIdType
				+ ", addressProofIdNo=" + addressProofIdNo + ", employeeRole=" + employeeRole + ", branch=" + branch
				+ "]";
	}

}
