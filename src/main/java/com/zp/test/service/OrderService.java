package com.zp.test.service;

import java.util.List;

import com.zp.test.model.Order;

public interface OrderService {
	/**
	 * Description: 添加订单
	 * @param order
	 * @throws Exception  void 返回值当注释出失败、错误、异常时的返回情况
	 * @throws 异常当注释出什么情况、什么时候、什么条件下会引发什么样的异常
	 * @Author 岳继春
	 * Create Date: 2016年3月21日 下午10:31:42
	 */
	public void addOrder(Order order) throws Exception;
	
	/**
	 * Description: 通过订单状态查询
	 * @param order
	 * @throws Exception  void 返回值当注释出失败、错误、异常时的返回情况
	 * @throws 异常当注释出什么情况、什么时候、什么条件下会引发什么样的异常
	 * @Author 岳继春
	 * Create Date: 2016年3月21日 下午10:31:53
	 */
	public List<Order> queryOrder(Integer orderStatus) throws Exception;
}
