package com.testing.webTest;

import org.apache.log4j.Logger;

import com.testing.ShopPage.HomePage;
import com.testing.ShopPage.LoginPage;
import com.testing.UI.AutoLogger;
import com.testing.UI.KeywordOfWeb;
import com.testing.adminPage.AddGoodsPage;
import com.testing.adminPage.AdminLoginPage;

import sun.util.logging.resources.logging;

public class TestPO {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeywordOfWeb keyword= new KeywordOfWeb();
		keyword.openBrowser("chrome");
		keyword.implicitlyWait();
		AdminLoginPage adminLogin=new AdminLoginPage(keyword);
		adminLogin.load();
		adminLogin.login();
		AddGoodsPage addGoods=new AddGoodsPage(keyword);
		addGoods.load();
		addGoods.addGoods();
		LoginPage loginpage=new LoginPage(keyword);
		loginpage.load();
		loginpage.login();
		HomePage homepage=new HomePage(keyword);
		homepage.load();
		homepage.joinCart();
	}

}
