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
	 * Description: ���Ӷ�����Ϣ
	 * @return  ResponseVo ����ֵ��ע�ͳ�ʧ�ܡ������쳣ʱ�ķ������
	 * @throws �쳣��ע�ͳ�ʲô�����ʲôʱ��ʲô�����»�����ʲô�����쳣
	 * @Author ���̴�
	 * Create Date: 2016��3��21�� ����8:27:02
	 */
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody ResponseVo add(@RequestBody Map<String,Object> map){
		//1.�������ض���vo
		ResponseVo responseVo = new ResponseVo();
		//2.����db�����add��������
		try {
			//���붩��
			Order order =buildOrder(map); 
			orderService.addOrder(order);
			//0000����ɹ� ��Ӧ���ڳ�������
			responseVo.setRtnCode("0000");
			responseVo.setMessage(order.getCustomer().getCustName()+" ��Ӷ������Ϊ "+order.getAmount()+" �Ķ�����Ϣ�ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			//3000�������ʧ�� ��Ӧ���ڳ�������
			responseVo.setRtnCode("3000");
			responseVo.setMessage("��Ӷ�����Ϣʧ��");
		}
		return responseVo;
	}
	
	/**
	 * Description: ����order
	 * @param map  void ����ֵ��ע�ͳ�ʧ�ܡ������쳣ʱ�ķ������
	 * @throws �쳣��ע�ͳ�ʲô�����ʲôʱ��ʲô�����»�����ʲô�����쳣
	 * @Author ���̴�
	 * Create Date: 2016��3��22�� ����4:40:27
	 */
	private Order buildOrder(Map<String, Object> map) {
		//����order
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
	 * Description: �����鿴
	 * @return  ListResponseVo ����ֵ��ע�ͳ�ʧ�ܡ������쳣ʱ�ķ������
	 * @throws �쳣��ע�ͳ�ʲô�����ʲôʱ��ʲô�����»�����ʲô�����쳣
	 * @Author ���̴�
	 * Create Date: 2016��3��21�� ����10:25:45
	 */
	@RequestMapping(value="/{orderstatus}/orders", method=RequestMethod.GET)
	public @ResponseBody ListResponseVo get(@PathVariable @Validated Integer orderstatus){
		ListResponseVo listResponseVo = new ListResponseVo();
		try {
			//��ѯ����
			List<Order> orders = orderService.queryOrder(orderstatus);
			listResponseVo.setOrders(orders);
			//0000����ɹ� ��Ӧ���ڳ�������
			listResponseVo.setRtnCode("0000");
			listResponseVo.setMessage("��ѯ������Ϣ�ɹ���"+orders.size()+"��");
		} catch (Exception e) {
			//3000�������ʧ�� ��Ӧ���ڳ�������
			listResponseVo.setRtnCode("3000");
			listResponseVo.setMessage("��ѯ������Ϣʧ��");
			e.printStackTrace();
		}
		return listResponseVo;
	}

	/**
	 * Description: ��֤�ǿ�
	 * @param order  void ����ֵ��ע�ͳ�ʧ�ܡ������쳣ʱ�ķ������
	 * @throws �쳣��ע�ͳ�ʲô�����ʲôʱ��ʲô�����»�����ʲô�����쳣
	 * @Author ���̴�
	 * Create Date: 2016��3��21�� ����10:09:56
	 */
	@SuppressWarnings("unused")
	private void valid(Order order) {
		// ��׼1��2��3 �˴����ٱ�д ����Ϊ�˽���Ӧ���������������
		
	}
}
