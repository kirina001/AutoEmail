package com.testing.interTest;

import com.testing.inter.HttpClientKw;

public class TestOfNewLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpClientKw http=new HttpClientKw();
		try {
//			String response=http.doGet("https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php", "query=.1.3.1.*&co=&resource_id=6006&ie=utf8&oe=gbk");
//			System.out.println(response);
			http.saveCookie();
			String response=http.doPost("http://localhost:8080/NewLogin/LoginTry","Roy1' or 1=1 #&pwd=adassadfd");
			System.out.println(response);
			String response3=http.doPost("http://localhost:8080/NewLogin/LoginTry","user=Will&pwd=23456");
			System.out.println(response3);
			http.clearCookie();
			String response2=http.doPost("http://localhost:8080/NewLogin/Logout", "");
			
			
			if(response.contains("200")) {
				System.out.println("测试通过");
			}
			else
				System.out.println("测试失败");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
