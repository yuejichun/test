//api �Ͳ�д�� //���� rtnCode ��rtnMessege�������� ״ֵ̬������CoreConstant
�û����restClint���в���

�ӿ�����
1.���������ӿ� 
		���룺��ʾ���ĸ�ʽ
	 http://localhost:8080/test/order
		����ֵ{"rtnCode":"0000","message":"����5 ��Ӷ������Ϊ 555 �Ķ�����Ϣ�ɹ�"}	 
	 
2.������ѯ�ӿڣ�0����ȫ����1����ɹ���2����ʧ��,3����ȴ����
	http://localhost:8080/test/order/2/orders
		����ֵ{"rtnCode": "0000", "message": "��ѯ������Ϣ�ɹ���2��",
	    "orders": [
	        {
	            "id": 4,
	            "tradingTime": "2015-06-06",
	            "tradeStatus": 2,
	            "trateType": 1,
	            "amount": 444,
	            "amountType": 1,
	            "customer": {
	                "id": 14,
	                "custName": "����4"
	            }
	        },
	        {
	            "id": 5,
	            "tradingTime": "2015-06-07",
	            "tradeStatus": 2,
	            "trateType": 1,
	            "amount": 555,
	            "amountType": 1,
	            "customer": {
	                "id": 15,
	                "custName": "����5"
	            }
	        }
	    ]
	}

ʾ�� �����������ӿڣ� ��ʼ��3���ɹ��� 2��ʧ�ܵ� ��һ��һ���Ĳ
{
    "id": 1,
    "tradingTime": "2015-06-03",
    "tradeStatus": 1,
    "trateType": 1,
    "amount": 111,
    "amountType": 1,
    "custId": 11,
    "custName":"����1"
}

{
    "id": 2,
    "tradingTime": "2015-06-04",
    "tradeStatus": 1,
    "trateType": 2,
    "amount": 222,
    "amountType": 2,
    "custId": 12,
    "custName":"����2"
}

{
    "id": 3,
    "tradingTime": "2015-06-05",
    "tradeStatus": 1,
    "trateType": 3,
    "amount": 333,
    "amountType": 1,
    "custId": 13,
    "custName":"����3"
}

{
    "id": 4,
    "tradingTime": "2015-06-06",
    "tradeStatus": 2,
    "trateType": 1,
    "amount": 444,
    "amountType": 1,
    "custId": 14,
    "custName":"����4"
}

{
    "id": 5,
    "tradingTime": "2015-06-07",
    "tradeStatus": 2,
    "trateType": 1,
    "amount": 555,
    "amountType": 1,
    "custId": 15,
    "custName":"����5"
}