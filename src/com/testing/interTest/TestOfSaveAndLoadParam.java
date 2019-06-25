package com.testing.interTest;

import java.util.HashMap;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;
import com.testing.inter.HttpClientKw;

public class TestOfSaveAndLoadParam {

	public static Map<String, String> paramMap=new HashMap<String,String>();
	
	public static void main1(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HttpClientKw kw=new HttpClientKw();
//		kw.doPost("http://testingedu.com.cn/inter/HTTP/register", "username=roy&pwd=123456&nickname=roy&describe=帅");
		String s=kw.doPost("http://testingedu.com.cn/inter/HTTP/auth", "");
		System.out.println(s);
		String token=JsonPath.read(s, "$.token");
		System.out.println(token);
		Map<String, String> headerMap=new HashMap<>();
		headerMap.put("token", token);
		headerMap.put("Pragma", "no-cache");
		kw.addHeader(headerMap);
//		kw.doPost("http://testingedu.com.cn/inter/HTTP/register", "username=roy2&pwd=123456&nickname=roy&describe=帅");
		String s2=kw.doPost("http://testingedu.com.cn/inter/HTTP/login", "username=roy2&password=123456");
		System.out.println(s2);
		String id=JsonPath.read(s2, "$.userid");
		paramMap.put("id", id);
		kw.doPost("http://testingedu.com.cn/inter/HTTP/getUserInfo", toParam("id={id}", paramMap));
		String s3=kw.doPost("http://testingedu.com.cn/inter/HTTP/logout", "");
	}

	public static String toParam(String origin,Map<String,String> map) {
		String param=origin;
		for(String key:map.keySet()) {
		param=param.replaceAll("\\{"+key+"\\}", map.get(key));
		}
		return param;
	}
	
	public static void main(String[] args) {
		String a="{\"status\":200,\"msg\":\"恭喜您，登录成功\",\"userid\":\"5\"}";
		String id=JsonPath.read(a,"$.userid");
//		paramMap.put("id", id);
		paramMap.put("name", "roy");
//		paramMap.put("age", "28");
		String testParam="{\"name\":\"{name}\"}";
		System.out.println(toParam(testParam, paramMap));
	}
}
