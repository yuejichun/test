package com.zp.test.common;

public class ObjectUtil {

	/**
	 * Description: 对象转字符串
	 * @param obj
	 * @return  String 返回值当注释出失败、错误、异常时的返回情况
	 * @throws 异常当注释出什么情况、什么时候、什么条件下会引发什么样的异常
	 * @Author 岳继春
	 * Create Date: 2016年3月22日 下午4:38:57
	 */
	public static String toString(Object obj){
		return obj==null?"":obj.toString();
	}
	/**
	 * Description: 对象转数值
	 * @param obj
	 * @return  String 返回值当注释出失败、错误、异常时的返回情况
	 * @throws 异常当注释出什么情况、什么时候、什么条件下会引发什么样的异常
	 * @Author 岳继春
	 * Create Date: 2016年3月22日 下午4:38:57
	 */
	public static Integer toInteger(Object obj){
		return obj==null?0:Integer.valueOf(obj.toString());
	}
}
