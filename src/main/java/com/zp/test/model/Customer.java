package com.zp.test.model;

public class Customer {
	/**
	 * �ͻ� ID
	 */
	private Integer id;
	/**
	 * �ͻ�����
	 */
	private String custName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Customer(Integer id, String custName) {
		this.id = id;
		this.custName = custName;
	}
	public Customer() {
	}
	
	
}
