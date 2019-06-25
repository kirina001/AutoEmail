package com.testing.interTest;

import java.util.HashMap;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;
import com.testing.inter.KeywordOfInter;

public class TestOfHttpWithSaveParam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeywordOfInter kw=new KeywordOfInter();
		String result=kw.testPost("http://www.testingedu.com.cn/inter/HTTP/auth", "");
		String tokenValue=JsonPath.read(result, "$.token");
		kw.assertSame(result, "200", "$.status");
		kw.saveParam("token", result, "$.token");
		kw.addHeader("{\"token\":\"{token}\",\"Pragma\":\"no-cache\"}");
		String result2=kw.testPost("http://www.testingedu.com.cn/inter/HTTP/login", "username=roy&password=123456");
		kw.saveParam("id", result2, "$.userid");
		kw.testPost("http://www.testingedu.com.cn/inter/HTTP/getUserInfo", "id={id}");
		kw.testPost("http://www.testingedu.com.cn/inter/HTTP/logout", "");
	}

}
