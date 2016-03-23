/*
 *
Copyright (C) 2011-2015
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
============================================================
 *
FileName: JsonUtil.java
 *
Created: [2015年12月14日 下午3:53:32] by 岳继春
 * 更新：更新时间
 * 作者：岳继春
 * 版本：1.0
 * ID：更新id
============================================================
 *
ProjectName: module-common
 *
Description: 用一句话说明该文件做什么
==========================================================*/
package com.zp.test.common;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Description: 说明该类、接口的目的、作用、功能、继承于何种父类，实现的接口、实现的算法、使用方法、示例程序等
 * @author 岳继春
 * @code
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2015年12月14日    yuejichun       1.0        1.0 Version 
 * </pre>
 *@endcode
 */
public class JsonUtil {

private static ObjectMapper mapper;
	
	/**
	 * 获取ObjectMapper实例
	 * @param createNew 方式：true，新实例；false,存在的mapper实例
	 * @return
	 */
	public static synchronized ObjectMapper getMapperInstance(boolean createNew) {   
        if (createNew) {   
            return new ObjectMapper();   
        } else if (mapper == null) {   
            mapper = new ObjectMapper();   
        }   
        return mapper;   
    } 
	
	/**
	 * 将java对象转换成json字符串
	 * @param obj 准备转换的对象
	 * @return json字符串
	 * @throws Exception 
	 */
	public static String beanToJson(Object obj) throws Exception {
		try {
			ObjectMapper objectMapper = getMapperInstance(false);
			String json =objectMapper.writeValueAsString(obj);
			return json;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}
	
	/**
	 * 将java对象转换成json字符串
	 * @param obj 准备转换的对象
	 * @param createNew ObjectMapper实例方式:true，新实例;false,存在的mapper实例
	 * @return json字符串
	 * @throws Exception
	 */
	public static String beanToJson(Object obj,Boolean createNew) throws Exception {
		try {
			ObjectMapper objectMapper = getMapperInstance(createNew);
			String json =objectMapper.writeValueAsString(obj);
			return json;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}
	
	/**
	 * 将json字符串转换成java对象
	 * @param json 准备转换的json字符串
	 * @param cls  准备转换的类
	 * @return 
	 * @throws Exception 
	 */
	public static Object jsonToBean(String json, Class<?> cls) throws Exception {
		try {
		ObjectMapper objectMapper = getMapperInstance(false);
		Object vo = objectMapper.readValue(json, cls);
		return vo;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	/**
	 * 将json字符串转换成java对象
	 * @param json 准备转换的json字符串
	 * @param cls  准备转换的类
	 * @param createNew ObjectMapper实例方式:true，新实例;false,存在的mapper实例
	 * @return
	 * @throws Exception
	 */
	public static Object jsonToBean(String json, Class<?> cls,Boolean createNew) throws Exception {
		try {
		ObjectMapper objectMapper = getMapperInstance(createNew);
		Object vo = objectMapper.readValue(json, cls);
		return vo;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	/**
	 * Description: json转map
	 * @param json
	 * @return  Map<String,Object> 返回值当注释出失败、错误、异常时的返回情况
	 * @throws 异常当注释出什么情况、什么时候、什么条件下会引发什么样的异常
	 * @Author 岳继春
	 * Create Date: 2016年3月14日 下午2:19:24
	 */
	public static Map<String,Object> jsonToMap(String json){  
		try {

			ObjectMapper mapper = new ObjectMapper();

			Map<String, Object> map = new HashMap<String, Object>();

			// convert JSON string to Map
			map = mapper.readValue(json, new TypeReference<Map<String, String>>(){});
			return map;
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}  
}
