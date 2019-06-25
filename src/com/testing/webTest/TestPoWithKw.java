package com.testing.webTest;

import com.testing.UI.KeywordOfWeb;

public class TestPoWithKw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeywordOfWeb kw=new KeywordOfWeb();
		kw.openBrowser("chrome");
//		AdminLoginTest.adminLogin(kw);
		SampleForTstShop.login(kw);
//		SampleForTstShop.addCart(kw);
		kw.visitWeb("http://112.74.191.10:8000/index.php/Home/Order/order_list.html");
		kw.click("//a[@class='ps_lj']");
		kw.closeOldWin();
		String s=kw.getJs("$(\"input[value='pay_code=cod']\").trigger(\"click\")");
		System.out.println(s);
		
	}
}
