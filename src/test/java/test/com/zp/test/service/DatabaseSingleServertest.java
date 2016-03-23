package test.com.zp.test.service;

import java.math.BigDecimal;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zp.test.common.CoreConstant;
import com.zp.test.dao.DatabaseSingleServer;
import com.zp.test.model.Customer;
import com.zp.test.model.Order;

public class DatabaseSingleServertest extends TestCase{
	private static Logger log = LoggerFactory.getLogger(DatabaseSingleServertest.class);
	
	@Test
	/**
	 * Description: 使用用户张三创建一条86元5角人民币的交易记录，验证交易状态为等待付款，并且交易的金额是正确的。
	 * @throws 异常当注释出什么情况、什么时候、什么条件下会引发什么样的异常
	 * @Author 岳继春
	 * Create Date: 2016年3月21日 下午10:03:11
	 */
	public void testQuery(){
		
		//用户张三创建一条86元5角人民币的交易记录
		Order order1 = new Order();
		order1.setId(888);
		order1.setAmount(new BigDecimal(86.5));
		order1.setAmountType(CoreConstant.ORDER_AMOUNT_TYPE_DO);
		order1.setCustomer(new Customer(999, "张三"));
		order1.setTradeStatus(CoreConstant.ORDER_TRADESTATUS_WAIT);
		order1.setTradingTime("2016-03-22");
		order1.setTrateType(CoreConstant.ORDER_TRATETYPE_PAY);
		//调用添加接口
		try {
			DatabaseSingleServer.addOrder(order1);
			log.info("插入成功");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			log.error("插入失败", e);
		}
		
		try {
			List<Order> list = DatabaseSingleServer.getList(CoreConstant.ORDER_TRADESTATUS_WAIT);
			System.out.println(list);
			if(list!=null&&list.size()>0){
				for (Order order : list) {
					//使用用户张三创建一条86元5角人民币的交易记录，验证交易状态为等待付款，并且交易的金额是正确的。
					//断言
					assert(order.getTradeStatus())!=null;
					assert(order.getAmount()==new BigDecimal(86.5));
					System.out.println(order.getTradeStatus()==CoreConstant.ORDER_TRADESTATUS_WAIT);
					System.out.println(order.getAmount().compareTo(new BigDecimal(86.5)));
				}
			}
			log.info("查询成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("查询失败", e);
		}
	}
}
