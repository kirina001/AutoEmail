package com.testing.interTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.axis2.context.NamedValue;
import org.json.JSONObject;

import com.jayway.jsonpath.JsonPath;
import com.testing.inter.SoapInterKeyWord;

public class TestSoapInterWithAxis2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SoapInterKeyWord soap=new SoapInterKeyWord();
		try {
			soap.createCon("http://www.testingedu.com.cn/inter/SOAP?wsdl");
			String result=soap.doSoap("http://soap.testingedu.com/", "auth", "");
			//保存参数
			String tokenValue=JsonPath.read(result,"$.token");
			String token= "{\"token\":\""+tokenValue+"\",\"Pragma\":\"no-cache\"}";
			//添加header
			List<NamedValue> headers=new ArrayList<NamedValue>();
			JSONObject json = new JSONObject(token);
			Iterator<String> jsonit = json.keys();
			while (jsonit.hasNext()) {
				String jsonkey = jsonit.next();
				NamedValue h = new NamedValue(jsonkey, json.get(jsonkey).toString());
				headers.add(h);
			}
			soap.addHeader(headers);
			//调用注册
			soap.doSoap("http://soap.testingedu.com/", "register", "{\"arg0\":\"user3\",\"arg1\":\"pwd\",\"arg2\":\"nick2\"}");
			//调用授权
			soap.doSoap("http://soap.testingedu.com/", "auth", "");
			//登录
			result = soap.doSoap("http://soap.testingedu.com/", "login", "{\"arg0\":\"user3\",\"arg1\":\"pwd\"}");
			String id=JsonPath.read(result,"$.userid");
			//获取用户信息
			soap.doSoap("http://soap.testingedu.com/", "getUserInfo", "{\"arg0\":\""+id+"\"}");
			//注销登录
			soap.doSoap("http://soap.testingedu.com/", "logout","");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
