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
	 * Description: ʹ���û���������һ��86Ԫ5������ҵĽ��׼�¼����֤����״̬Ϊ�ȴ�������ҽ��׵Ľ������ȷ�ġ�
	 * @throws �쳣��ע�ͳ�ʲô�����ʲôʱ��ʲô�����»�����ʲô�����쳣
	 * @Author ���̴�
	 * Create Date: 2016��3��21�� ����10:03:11
	 */
	public void testQuery(){
		
		//�û���������һ��86Ԫ5������ҵĽ��׼�¼
		Order order1 = new Order();
		order1.setId(888);
		order1.setAmount(new BigDecimal(86.5));
		order1.setAmountType(CoreConstant.ORDER_AMOUNT_TYPE_DO);
		order1.setCustomer(new Customer(999, "����"));
		order1.setTradeStatus(CoreConstant.ORDER_TRADESTATUS_WAIT);
		order1.setTradingTime("2016-03-22");
		order1.setTrateType(CoreConstant.ORDER_TRATETYPE_PAY);
		//������ӽӿ�
		try {
			DatabaseSingleServer.addOrder(order1);
			log.info("����ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			log.error("����ʧ��", e);
		}
		
		try {
			List<Order> list = DatabaseSingleServer.getList(CoreConstant.ORDER_TRADESTATUS_WAIT);
			System.out.println(list);
			if(list!=null&&list.size()>0){
				for (Order order : list) {
					//ʹ���û���������һ��86Ԫ5������ҵĽ��׼�¼����֤����״̬Ϊ�ȴ�������ҽ��׵Ľ������ȷ�ġ�
					//����
					assert(order.getTradeStatus())!=null;
					assert(order.getAmount()==new BigDecimal(86.5));
					System.out.println(order.getTradeStatus()==CoreConstant.ORDER_TRADESTATUS_WAIT);
					System.out.println(order.getAmount().compareTo(new BigDecimal(86.5)));
				}
			}
			log.info("��ѯ�ɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("��ѯʧ��", e);
		}
	}
}
