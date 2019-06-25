package com.testing.interTest;

import java.net.URLEncoder;

import com.jayway.jsonpath.JsonPath;
import com.testing.inter.KeywordOfInter;

public class TestOfRestInter {

	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		KeywordOfInter key=new KeywordOfInter();
		String result=key.testPost("http://www.testingedu.com.cn/inter/REST/auth", "");
		key.saveParam("token", result, "$.token");
		key.addHeader("{\"token\":\"{token}\",\"Pragma\":\"no-cache\"}");
		String en=URLEncoder.encode("{\"username\":\"roy\",\"pwd\":\"123456\",\"nickname\":\"roySensei\",\"describe\":\"我是一个老师\"}");
		System.out.println(en);
		key.testPost("http://www.testingedu.com.cn/inter/REST/user/register", en);	
		String result2=key.testPost("http://www.testingedu.com.cn/inter/REST/login/roy/123456", "");
		String id=JsonPath.read(result2, "$.userid");
		key.testPost("http://www.testingedu.com.cn/inter/REST/login/"+id, "");
		key.testPost("http://www.testingedu.com.cn/inter/REST/login", "");
		
	}
	
	public static void main(String[] args) {
		String em = "+";
		String en=URLEncoder.encode(em);
		System.out.println(en);
	}

}
