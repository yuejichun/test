package com.zp.test.dao;

import java.util.ArrayList;
import java.util.List;

import com.zp.test.model.Order;

public class DatabaseSingleServer {

	private static List<Order> list = new ArrayList<Order>();
	/**
	 * ��������
	 */
	private static DatabaseSingleServer instance = null;

	/**
	 * �չ��췽��
	 */
	private DatabaseSingleServer() {
	}
	/**
	 * Description: ����get
	 * @return  DatabaseSingleServer ����ֵ��ע�ͳ�ʧ�ܡ������쳣ʱ�ķ������
	 * @throws �쳣��ע�ͳ�ʲô�����ʲôʱ��ʲô�����»�����ʲô�����쳣
	 * @Author ���̴�
	 * Create Date: 2016��3��21�� ����8:41:23
	 */
	public static synchronized DatabaseSingleServer getDataService(){
		if(instance==null){
			instance = new DatabaseSingleServer();
		}
		return instance;
	}
	/**
	 * Description: ͨ��״ֵ̬���ض�������
	 * @param status
	 * @return  List<Order> ����ֵ��ע�ͳ�ʧ�ܡ������쳣ʱ�ķ������
	 * @throws �쳣��ע�ͳ�ʲô�����ʲôʱ��ʲô�����»�����ʲô�����쳣
	 * @Author ���̴�
	 * Create Date: 2016��3��21�� ����10:45:56
	 */
	public static List<Order> getList(Integer...status) throws Exception{
		//������ʱ����
		List<Order> tmpList = new ArrayList<Order>();
		//�ж��Ƿ���״ֵ̬
		if(status!=null&&status.length>0){
			Integer sta = status[0];
			tmpList = new ArrayList<Order>();
			if(sta!=0){
				for (Order order : list) {
					if(order.getTradeStatus()!=null&&order.getTradeStatus()==sta){
						//�����������Ķ����ŵ�tmpList������
						tmpList.add(order);
					}
				}
			}else{
				tmpList = list;
			}
		}else{
			tmpList = list;
		}
		return tmpList;
	}
	/**
	 * Description: ���order
	 * @param order  void ����ֵ��ע�ͳ�ʧ�ܡ������쳣ʱ�ķ������
	 * @throws �쳣��ע�ͳ�ʲô�����ʲôʱ��ʲô�����»�����ʲô�����쳣
	 * @Author ���̴�
	 * Create Date: 2016��3��21�� ����8:47:42
	 */
	public static void addOrder(Order order) throws Exception{
		try {
			getDataService();
			//��ӳɹ���־
			synchronized (order) {
				list.add(order);
			}
		} catch (Exception e) {
			//�˴�����쳣��־
			throw new RuntimeException("���ʧ��");
		}
	}
	
}