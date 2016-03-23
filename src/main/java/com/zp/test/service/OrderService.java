package com.zp.test.service;

import java.util.List;

import com.zp.test.model.Order;

public interface OrderService {
	/**
	 * Description: ��Ӷ���
	 * @param order
	 * @throws Exception  void ����ֵ��ע�ͳ�ʧ�ܡ������쳣ʱ�ķ������
	 * @throws �쳣��ע�ͳ�ʲô�����ʲôʱ��ʲô�����»�����ʲô�����쳣
	 * @Author ���̴�
	 * Create Date: 2016��3��21�� ����10:31:42
	 */
	public void addOrder(Order order) throws Exception;
	
	/**
	 * Description: ͨ������״̬��ѯ
	 * @param order
	 * @throws Exception  void ����ֵ��ע�ͳ�ʧ�ܡ������쳣ʱ�ķ������
	 * @throws �쳣��ע�ͳ�ʲô�����ʲôʱ��ʲô�����»�����ʲô�����쳣
	 * @Author ���̴�
	 * Create Date: 2016��3��21�� ����10:31:53
	 */
	public List<Order> queryOrder(Integer orderStatus) throws Exception;
}
