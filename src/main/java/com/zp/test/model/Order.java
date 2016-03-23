package com.zp.test.model;

import java.io.Serializable;
import java.math.BigDecimal;


public class Order implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -671439292091826393L;
	/**
	 * 交易 ID
	 */
	private Integer id;
	/**
	 * 创建时间
	 */
	private String tradingTime;
	/**
	 * 交易状态（例如是否交易成功
	 */
	private Integer tradeStatus;
	/**
	 * 交易类型（例如支付还是退款）
	 */
	private Integer trateType;
	/**
	 * 交易金额
	 */
	private BigDecimal amount;
	/**
	 * 交易币种（例如美元还是人民币）
	 */
	private Integer amountType;
	
	/**
	 * 客户信息id
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
//		//重写get方法，springMVC不持支复杂对象
//		Customer cust = new Customer();
//		JsonUtil.jsonToBean(customer, Customer.class);
//		return cust;
//	}
	
}
