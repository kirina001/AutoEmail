package com.testing.interTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;

import com.jayway.jsonpath.JsonPath;
import com.testing.inter.HttpClientKw;

public class TestOfHttpWithoutSaveParam {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HttpClientKw client=new HttpClientKw();
		String result=client.doPost("http://www.testingedu.com.cn//inter/HTTP/auth", "");
		//解析result中的token字段，获取token的值
		JSONObject json = new JSONObject(result);
		String tokenValue=json.get("token").toString();
		//将token的值，存到保存header键值对的map中
		Map<String, String> map=new HashMap<String,String>();
		map.put("token", tokenValue);
		map.put("Pragma","no-cache");
		//传递map参数给httpclient，添加到请求当中
		client.addHeader(map);
		client.doPost("http://www.testingedu.com.cn/inter/HTTP/register", "username=roy34&pwd=roy34&nickname=roy34");
		String result2=client.doPost("http://www.testingedu.com.cn/inter/HTTP/login", "username=roy34&password=roy34");
		String idValue=JsonPath.read(result2,"$.userid");
		System.out.println(idValue);
		client.doPost("http://www.testingedu.com.cn/inter/HTTP/getUserInfo", "id="+idValue);
		client.doPost("http://www.testingedu.com.cn/inter/HTTP/logout", "");
	}

}
