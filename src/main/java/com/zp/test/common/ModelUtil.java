/*
 *
Copyright (C) 2011-2015
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
============================================================
 *
FileName: ModelUtil.java
 *
Created: [2015年10月15日 上午9:46:15] by 岳继春
 * 更新：更新时间
 * 作者：岳继春
 * 版本：1.0
 * ID：更新id
============================================================
 *
ProjectName: jewel-admin
 *
Description: 用一句话说明该文件做什么
==========================================================*/
package com.zp.test.common;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * Description: 模型工具类，包含属性拷贝等功能
 * @author 岳继春
 * @code
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2015年10月15日    yuejichun       1.0        1.0 Version 
 * </pre>
 *@endcode
 */
public class ModelUtil {
	private static Logger log = LoggerFactory.getLogger(ModelUtil.class);
	private ModelUtil(){}
	
	/**
	 * 拷贝非空属性(排险)
	 * @param source
	 * @param dest
	 */
	@SuppressWarnings("rawtypes")
	public static void copyProps(Object source, Object target, String...ignorProps) {
		if(source instanceof Map){
			try {
				Map sourceMap = (Map)source;
				Set<String> ignorPropsSet = new HashSet<String>();
				if(null!=ignorProps){
					for(String prop : ignorProps){
						ignorPropsSet.add(prop);
					}
				}
				
				for(Object key : sourceMap.keySet()){
					if(null==key || ignorPropsSet.contains(key)){
						continue;
					}else{
						Object value = sourceMap.get(key);
						if(PropertyUtils.isWriteable(target, key.toString())){
							PropertyUtils.setProperty(target, key.toString(), value);
						}
					}
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}else{
			org.springframework.beans.BeanUtils.copyProperties(source, target, ignorProps);
		}
	}
	
	/**
	 * 拷贝非空属性(包含)
	 * @param source
	 * @param dest
	 */
	public static void copyPropsInc(Object source, Object target, String...incProps) {
		try {
			Set<String> incPropsSet = new HashSet<String>();
			if(null!=incProps){
				for(String prop : incProps){
					incPropsSet.add(prop);
				}
			}
			
			for(PropertyDescriptor pd : PropertyUtils.getPropertyDescriptors(source)){
				String key = pd.getName();
				if(null==key || !incPropsSet.contains(key)){
					continue;
				}else{
					Object value = PropertyUtils.getProperty(source, key);
					if(PropertyUtils.isWriteable(target, key.toString())){
						PropertyUtils.setProperty(target, key.toString(), value);
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 使用bean中的属性创建Map
	 * @param bean
	 * @param propNames 需要放到map中的属性名称
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> convBeanToMap(Object bean, String...propNames) {
		Assert.notNull(propNames, "请指定属性名称");
		Map<String,Object> rtn = new HashMap<String,Object>();
		if(propNames.length==0 || "*".equals(propNames[0])){
			PropertyDescriptor[] propDescs = PropertyUtils.getPropertyDescriptors(bean);
			for(PropertyDescriptor propDesc : propDescs){
				String propName = propDesc.getName();
				Object propValue = null;
				try {
					propValue = PropertyUtils.getProperty(bean, propName);
				} catch (Exception e) {
					log.debug("获取其它属性时出错："+e.getMessage());
				}
				rtn.put(propName, propValue);
			}
		}else{
			for(String propName: propNames){
				Object propValue = null;
				try{
					if(PropertyUtils.isReadable(bean, propName)){
						propValue = PropertyUtils.getProperty(bean, propName);
					}
				} catch (Exception e){
					log.debug("获取其它属性时出错："+e.getMessage());
				}
				rtn.put(propName, propValue);
			}
		}
		
		return rtn;
	}
	/**
	 * 取对象的属性值
	 * @param obj
	 * @param propName
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static Object getPropertyValue(Object obj, String propName) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		return PropertyUtils.getProperty(obj, propName);
	}
	
	/**
	 * 
	 * Description: 移除空关系（即关联对象ID无效时移除该关系）
	 *
	 * @param 
	 * @return Object
	 * @throws 
	 * @Author liufei
	 * Create Date: 2012-4-27 上午11:58:37
	 */
	public static Object removeNullRelation(Object obj, String relationIdName) throws Exception{
		int idx = relationIdName.lastIndexOf(".");
		Assert.isTrue(idx>0, "关系id属性名无效："+relationIdName);
		
		String relationName = relationIdName.substring(0,idx);
		Object relationId = PropertyUtils.getProperty(obj, relationIdName);
		if(relationId instanceof String){
			String id = (String)relationId;
			if(null==id || id.trim().length()==0){
				PropertyUtils.setProperty(obj, relationName, null);
			}
		}else{
			if(null==relationId){
				PropertyUtils.setProperty(obj, relationName, null);
			}
		}
		return obj;
	}
	
	/**
	 * 
	 * Description: 将树结构转换为列表结构，叶子节点在前
	 *
	 * @param 
	 * @return List
	 * @throws 
	 * @Author fei
	 * Create Date: 2013-8-30 上午11:41:16
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List treeToList(Object model, String subPropName, List list) throws Exception{
		Collection subs = (Collection)PropertyUtils.getProperty(model, subPropName);
		if(null!=subs && subs.size()>0){
			for(Object sub : subs){
				treeToList(sub, subPropName, list);
			}
		}
		list.add(model);
		
		return list;
	}
	
	/**
	 * 
	 * Description: 为String类型的属性做trim
	 *
	 * @param 
	 * @return void
	 * @throws 
	 * @Author liufei
	 * Create Date: 2013-11-16 下午3:17:28
	 */
	public static void trimFields(Object model, String... propNames) throws Exception{
		Assert.notEmpty(propNames, "请指定要去前后空格的属性名");
		for(String propName : propNames){
			Object val = PropertyUtils.getProperty(model, propName);
			if(val instanceof String){
				if(null!=val){
					String valStr = (String)val;
					valStr = valStr.trim();
					PropertyUtils.setProperty(model, propName, valStr);
				}
			}
		}
	}

	/**
	 * Description: 依据标准JavaDoc规范对方法进行注释，以明确该方法功能、作用、各参数含义以及返回值等
	 * @param resource
	 * @return  List<Object> 返回值当注释出失败、错误、异常时的返回情况
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws 异常当注释出什么情况、什么时候、什么条件下会引发什么样的异常
	 * @Author 岳继春
	 * Create Date: 2015年12月2日 上午10:26:53
	 */
	public static List<Object> modelToList(Object obj) throws Exception {
		List<Object> list = new ArrayList<Object>();
	        Class<?> cls = obj.getClass();  
	        Field[] fields = cls.getDeclaredFields();  
	        for (Field field : fields) {  
	            String name = field.getName();  
	            String strGet = "get" + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());  
	            Object object = null;
	            try {
	            	Method methodGet = cls.getDeclaredMethod(strGet);  
	            	object = methodGet.invoke(obj);  
				} catch (Exception e) {
					continue;
				}
	            list.add(object);
	        }  
		return list;
	}
}