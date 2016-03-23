package com.zp.test.vo;

import java.util.ArrayList;
import java.util.List;

import com.zp.test.model.Order;


public class ListResponseVo extends ResponseVo {

	/**
	 * ¶©µ¥ÁÐ±í
	 */
	private List<Order> orders = new ArrayList<Order>();

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
