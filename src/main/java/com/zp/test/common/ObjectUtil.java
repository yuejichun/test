package com.zp.test.common;

public class ObjectUtil {

	/**
	 * Description: ����ת�ַ���
	 * @param obj
	 * @return  String ����ֵ��ע�ͳ�ʧ�ܡ������쳣ʱ�ķ������
	 * @throws �쳣��ע�ͳ�ʲô�����ʲôʱ��ʲô�����»�����ʲô�����쳣
	 * @Author ���̴�
	 * Create Date: 2016��3��22�� ����4:38:57
	 */
	public static String toString(Object obj){
		return obj==null?"":obj.toString();
	}
	/**
	 * Description: ����ת��ֵ
	 * @param obj
	 * @return  String ����ֵ��ע�ͳ�ʧ�ܡ������쳣ʱ�ķ������
	 * @throws �쳣��ע�ͳ�ʲô�����ʲôʱ��ʲô�����»�����ʲô�����쳣
	 * @Author ���̴�
	 * Create Date: 2016��3��22�� ����4:38:57
	 */
	public static Integer toInteger(Object obj){
		return obj==null?0:Integer.valueOf(obj.toString());
	}
}
