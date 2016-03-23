package com.zp.test.controller;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.test.common.ModelUtil;
import com.zp.test.common.ObjectUtil;
import com.zp.test.model.Customer;
import com.zp.test.model.Order;
import com.zp.test.service.OrderService;
import com.zp.test.vo.ListResponseVo;
import com.zp.test.vo.ResponseVo;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Resource
	private OrderService orderService;
	
	/**
	 * Description: 增加订单信息
	 * @return  ResponseVo 返回值当注释出失败、错误、异常时的返回情况
	 * @throws 异常当注释出什么情况、什么时候、什么条件下会引发什么样的异常
	 * @Author 岳继春
	 * Create Date: 2016年3月21日 下午8:27:02
	 */
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody ResponseVo add(@RequestBody Map<String,Object> map){
		//1.创建返回对象vo
		ResponseVo responseVo = new ResponseVo();
		//2.调用db服务的add订单方法
		try {
			//插入订单
			Order order =buildOrder(map); 
			orderService.addOrder(order);
			//0000代表成功 本应放在常量类里
			responseVo.setRtnCode("0000");
			responseVo.setMessage(order.getCustomer().getCustName()+" 添加订单金额为 "+order.getAmount()+" 的订单信息成功");
		} catch (Exception e) {
			e.printStackTrace();
			//3000代表插入失败 本应放在常量类里
			responseVo.setRtnCode("3000");
			responseVo.setMessage("添加订单信息失败");
		}
		return responseVo;
	}
	
	/**
	 * Description: 构建order
	 * @param map  void 返回值当注释出失败、错误、异常时的返回情况
	 * @throws 异常当注释出什么情况、什么时候、什么条件下会引发什么样的异常
	 * @Author 岳继春
	 * Create Date: 2016年3月22日 下午4:40:27
	 */
	private Order buildOrder(Map<String, Object> map) {
		//创建order
		Order order = new Order();
		ModelUtil.copyProps(map, order, "customer","amount");
		//build customer
		Customer customer = new Customer();
		customer.setId(ObjectUtil.toInteger(map.get("custId")));
		customer.setCustName(ObjectUtil.toString(map.get("custName")));
		order.setAmount(new BigDecimal(ObjectUtil.toString(map.get("amount"))));
		order.setCustomer(customer);
		return order;
	}

	/**
	 * Description: 订单查看
	 * @return  ListResponseVo 返回值当注释出失败、错误、异常时的返回情况
	 * @throws 异常当注释出什么情况、什么时候、什么条件下会引发什么样的异常
	 * @Author 岳继春
	 * Create Date: 2016年3月21日 下午10:25:45
	 */
	@RequestMapping(value="/{orderstatus}/orders", method=RequestMethod.GET)
	public @ResponseBody ListResponseVo get(@PathVariable @Validated Integer orderstatus){
		ListResponseVo listResponseVo = new ListResponseVo();
		try {
			//查询订单
			List<Order> orders = orderService.queryOrder(orderstatus);
			listResponseVo.setOrders(orders);
			//0000代表成功 本应放在常量类里
			listResponseVo.setRtnCode("0000");
			listResponseVo.setMessage("查询订单信息成功共"+orders.size()+"条");
		} catch (Exception e) {
			//3000代表插入失败 本应放在常量类里
			listResponseVo.setRtnCode("3000");
			listResponseVo.setMessage("查询订单信息失败");
			e.printStackTrace();
		}
		return listResponseVo;
	}

	/**
	 * Description: 验证非空
	 * @param order  void 返回值当注释出失败、错误、异常时的返回情况
	 * @throws 异常当注释出什么情况、什么时候、什么条件下会引发什么样的异常
	 * @Author 岳继春
	 * Create Date: 2016年3月21日 下午10:09:56
	 */
	@SuppressWarnings("unused")
	private void valid(Order order) {
		// 标准1、2、3 此处不再编写 正常为了解耦应该提出到工具类中
		
	}
}
