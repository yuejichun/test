//api 就不写了 //返回 rtnCode 和rtnMessege两个参数 状态值定义在CoreConstant
用火狐的restClint进行测试

接口名称
1.订单新增接口 
		输入：见示例的格式
	 http://localhost:8080/test/order
		返回值{"rtnCode":"0000","message":"张三5 添加订单金额为 555 的订单信息成功"}	 
	 
2.订单查询接口（0代表全部，1代表成功，2代表失败,3代表等待付款）
	http://localhost:8080/test/order/2/orders
		返回值{"rtnCode": "0000", "message": "查询订单信息成功共2条",
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
	                "custName": "张三4"
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
	                "custName": "张三5"
	            }
	        }
	    ]
	}

示例 （订单新增接口） 初始化3条成功的 2条失败的 （一条一条的差）
{
    "id": 1,
    "tradingTime": "2015-06-03",
    "tradeStatus": 1,
    "trateType": 1,
    "amount": 111,
    "amountType": 1,
    "custId": 11,
    "custName":"张三1"
}

{
    "id": 2,
    "tradingTime": "2015-06-04",
    "tradeStatus": 1,
    "trateType": 2,
    "amount": 222,
    "amountType": 2,
    "custId": 12,
    "custName":"张三2"
}

{
    "id": 3,
    "tradingTime": "2015-06-05",
    "tradeStatus": 1,
    "trateType": 3,
    "amount": 333,
    "amountType": 1,
    "custId": 13,
    "custName":"张三3"
}

{
    "id": 4,
    "tradingTime": "2015-06-06",
    "tradeStatus": 2,
    "trateType": 1,
    "amount": 444,
    "amountType": 1,
    "custId": 14,
    "custName":"张三4"
}

{
    "id": 5,
    "tradingTime": "2015-06-07",
    "tradeStatus": 2,
    "trateType": 1,
    "amount": 555,
    "amountType": 1,
    "custId": 15,
    "custName":"张三5"
}