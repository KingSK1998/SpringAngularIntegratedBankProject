package com.coforge.bank.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deposit")
public class Deposit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "depositId")
	private int depositId;

	@Column(name = "customerName")
	private String customerName;

	@Column(name = "dateOfDeposit")
	private String dateOfDeposit;

	@Column(name = "depositAmount")
	private double depositAmount;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountNo")
	private Account account;

	public Deposit() {
	}

	public int getDepositId() {
		return depositId;
	}

	public void setDepositId(int depositId) {
		this.depositId = depositId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDateOfDeposit() {
		return dateOfDeposit;
	}

	public void setDateOfDeposit(String dateOfDeposit) {
		this.dateOfDeposit = dateOfDeposit;
	}

	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Deposit [depositId=" + depositId + ", customerName=" + customerName + ", dateOfDeposit=" + dateOfDeposit
				+ ", depositAmount=" + depositAmount + ", account=" + account + "]";
	}
}
