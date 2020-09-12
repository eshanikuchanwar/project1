package com.birlasoft.customerportal.model;

/*
 * Customer ValuObject Class 
 * Value Object class represents a simple entity whose equality is not based on identity.
 * constructor default and parameterized
 * getters and setters.
 */

public class CustomerVO {

	private String customerId;
	private String Customer_F_Name;
	private String Customer_L_Name;
	private String CustomerAddress;
	private String CustomerPhoneNumber;
	
	
	public CustomerVO() {
		super();
		
	}
	
	public CustomerVO(String customerId, String customer_F_Name, String customer_L_Name, String customerAddress,
			String customerPhoneNumber) {
		super();
		this.customerId = customerId;
		Customer_F_Name = customer_F_Name;
		Customer_L_Name = customer_L_Name;
		CustomerAddress = customerAddress;
		CustomerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomer_F_Name() {
		return Customer_F_Name;
	}

	public void setCustomer_F_Name(String customer_F_Name) {
		Customer_F_Name = customer_F_Name;
	}

	public String getCustomer_L_Name() {
		return Customer_L_Name;
	}

	public void setCustomer_L_Name(String customer_L_Name) {
		Customer_L_Name = customer_L_Name;
	}

	public String getCustomerAddress() {
		return CustomerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}

	public String getCustomerPhoneNumber() {
		return CustomerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		CustomerPhoneNumber = customerPhoneNumber;
	}

	@Override
	public String toString() {
		return "CustomerVO [customerId=" + customerId + ",   Customer_F_Name=" + Customer_F_Name + ",   Customer_L_Name="
				+ Customer_L_Name + ",   CustomerAddress=" + CustomerAddress + ",   CustomerPhoneNumber="
				+ CustomerPhoneNumber + "]";
	}


	
}
