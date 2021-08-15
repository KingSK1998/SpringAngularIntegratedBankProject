package com.coforge.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Column(columnDefinition = "varchar(50)", unique = true)
	private String customerId;

	@Column(name = "customerName")
	private String customerName;

	@Column(name = "customerPhone")
	private String customerPhone;

	@Column(name = "customerEmail")
	private String customerEmail;

	@Column(name = "customerAddress")
	private String customerAddress;

	@Column(name = "addressProofIdType")
	private String addressProofIdType;

	@Column(name = "addressProofIdNo", columnDefinition = "varchar(50)", unique = true)
	private String addressProofIdNo;

	@Column(name = "pancard", columnDefinition = "varchar(50)", unique = true)
	private String pancard;

	public Customer() {
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
		// this.customerId = getAddressProofIdNo();
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
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

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPhone="
				+ customerPhone + ", customerEmail=" + customerEmail + ", customerAddress=" + customerAddress
				+ ", addressProofIdType=" + addressProofIdType + ", addressProofIdNo=" + addressProofIdNo + ", pancard="
				+ pancard + "]";
	}

}
