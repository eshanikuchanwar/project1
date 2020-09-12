package com.birlasoft.customerportal.model;
/*
 * Purchase ValueObject class
 * constructor default and parameterized
 * getter and setter
 */

public class purchaseVO {
	
	private String OrderId;
	private String CustomerId;
    private String PaintingId;
	private int billAmount;
	public purchaseVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public purchaseVO(String orderId, String customerId, String paintingId, int billAmount) {
		super();
		OrderId = orderId;
		CustomerId = customerId;
		PaintingId = paintingId;
		this.billAmount = billAmount;
	}
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}
	public String getPaintingId() {
		return PaintingId;
	}
	public void setPaintingId(String paintingId) {
		PaintingId = paintingId;
	}
	public int getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}
	@Override
	public String toString() {
		return "purchaseVO [OrderId=" + OrderId + ", CustomerId=" + CustomerId + ", PaintingId=" + PaintingId
				+ ", billAmount=" + billAmount + "]";
	}
	
}
