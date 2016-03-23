package com.zp.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zp.test.dao.DatabaseSingleServer;
import com.zp.test.model.Order;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Override
	public void addOrder(Order order) throws Exception {
		//���õ���������add����
		DatabaseSingleServer.addOrder(order);
	}

	@Override
	public List<Order> queryOrder(Integer orderStatus) throws Exception {
		//���õ��������еĲ�ѯ��������
		return DatabaseSingleServer.getList(orderStatus);
	}


}
