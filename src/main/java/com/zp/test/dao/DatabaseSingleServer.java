package com.zp.test.dao;

import java.util.ArrayList;
import java.util.List;

import com.zp.test.model.Order;

public class DatabaseSingleServer {

	private static List<Order> list = new ArrayList<Order>();
	/**
	 * 创建单例
	 */
	private static DatabaseSingleServer instance = null;

	/**
	 * 空构造方法
	 */
	private DatabaseSingleServer() {
	}
	/**
	 * Description: 单例get
	 * @return  DatabaseSingleServer 返回值当注释出失败、错误、异常时的返回情况
	 * @throws 异常当注释出什么情况、什么时候、什么条件下会引发什么样的异常
	 * @Author 岳继春
	 * Create Date: 2016年3月21日 下午8:41:23
	 */
	public static synchronized DatabaseSingleServer getDataService(){
		if(instance==null){
			instance = new DatabaseSingleServer();
		}
		return instance;
	}
	/**
	 * Description: 通过状态值返回订单集合
	 * @param status
	 * @return  List<Order> 返回值当注释出失败、错误、异常时的返回情况
	 * @throws 异常当注释出什么情况、什么时候、什么条件下会引发什么样的异常
	 * @Author 岳继春
	 * Create Date: 2016年3月21日 下午10:45:56
	 */
	public static List<Order> getList(Integer...status) throws Exception{
		//创建临时集合
		List<Order> tmpList = new ArrayList<Order>();
		//判断是否传入状态值
		if(status!=null&&status.length>0){
			Integer sta = status[0];
			tmpList = new ArrayList<Order>();
			if(sta!=0){
				for (Order order : list) {
					if(order.getTradeStatus()!=null&&order.getTradeStatus()==sta){
						//将满足条件的订单放到tmpList容器中
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
	 * Description: 添加order
	 * @param order  void 返回值当注释出失败、错误、异常时的返回情况
	 * @throws 异常当注释出什么情况、什么时候、什么条件下会引发什么样的异常
	 * @Author 岳继春
	 * Create Date: 2016年3月21日 下午8:47:42
	 */
	public static void addOrder(Order order) throws Exception{
		try {
			getDataService();
			//添加成功日志
			synchronized (order) {
				list.add(order);
			}
		} catch (Exception e) {
			//此处添加异常日志
			throw new RuntimeException("添加失败");
		}
	}
	
}