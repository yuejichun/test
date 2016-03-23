package com.zp.test.model;

import java.io.Serializable;
import java.math.BigDecimal;


public class Order implements Serializable{

	/**
	 * ���л�
	 */
	private static final long serialVersionUID = -671439292091826393L;
	/**
	 * ���� ID
	 */
	private Integer id;
	/**
	 * ����ʱ��
	 */
	private String tradingTime;
	/**
	 * ����״̬�������Ƿ��׳ɹ�
	 */
	private Integer tradeStatus;
	/**
	 * �������ͣ�����֧�������˿
	 */
	private Integer trateType;
	/**
	 * ���׽��
	 */
	private BigDecimal amount;
	/**
	 * ���ױ��֣�������Ԫ��������ң�
	 */
	private Integer amountType;
	
	/**
	 * �ͻ���Ϣid
	 */
	private Customer customer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTradingTime() {
		return tradingTime;
	}

	public void setTradingTime(String tradingTime) {
		this.tradingTime = tradingTime;
	}

	public Integer getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(Integer tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public Integer getTrateType() {
		return trateType;
	}

	public void setTrateType(Integer trateType) {
		this.trateType = trateType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getAmountType() {
		return amountType;
	}

	public void setAmountType(Integer amountType) {
		this.amountType = amountType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


//	public Customer getCustomer() throws Exception {
//		//��дget������springMVC����֧���Ӷ���
//		Customer cust = new Customer();
//		JsonUtil.jsonToBean(customer, Customer.class);
//		return cust;
//	}
	
}
