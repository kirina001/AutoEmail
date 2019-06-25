package com.testing.webTest;

import java.io.IOException;

import com.testing.UI.KeywordOfWeb;

public class AdminLoginTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		KeywordOfWeb kw=new KeywordOfWeb();
		kw.openBrowser("chrome");
		kw.setWindow();
		//登录商城后台
		adminLoginMethod(kw);
		//点击添加商品按钮
		kw.click("//a[text()='商城']");
		kw.intoIframe("//iframe[@id='workspace']");
		kw.click("//div[@title='添加商品']");
		//商品名称
		kw.input("//input[@name='goods_name']", "老will1");
		//选择商品类型
		kw.selectByValue("//*[@id=\"cat_id\"]", "52");
		kw.halt("1");
		kw.selectByValue("//*[@id=\"cat_id_2\"]", "54");
		kw.halt("1");
		kw.selectByValue("//*[@id=\"cat_id_3\"]", "374");
		//选择市场价格和商店价格
		kw.input("//input[@name='shop_price']", "50");
		kw.input("//input[@name='market_price']", "5500");
		//选择是否包邮
		kw.click("//*[@id=\"is_free_shipping_label_1\"]");
		kw.scrollWindowStraight("600");
		kw.halt("1");
//		//选择文件上传
		kw.click("//*[@id='button1']/following-sibling::input");
		kw.halt("2");
		kw.intoIframe("//iframe[contains(@id,'layui-layer-iframe')]");
		kw.halt("1");
		kw.input("//div[@class='queueList']//input[@type='file']", "F:\\logo_200.png");
		kw.halt("1");
		kw.click("//div[@class='saveBtn']");
		kw.outIframe();
		//切换到富文本框
		kw.intoIframe("//iframe[@id='workspace']");
		kw.intoIframe("//iframe[@id='ueditor_0']");
		kw.runJs("document.getElementsByTagName(\"body\")[0].innerText=\"123456\"");
		kw.outIframe();
		kw.intoIframe("//iframe[@id='workspace']");
		kw.click("//a[@id='submit']");
		kw.halt("1");
		kw.closeBrowser();
	}

	public static void adminLoginMethod(KeywordOfWeb kw) {
		kw.visitWeb("http://112.74.191.10:8000/Admin/Admin/login");
		kw.input("//input[@name='username']", "admin");
		kw.input("//input[@name='password']", "123456");
		kw.input("//*[@id=\"vertify\"]", "1");
		kw.click("//input[@name='submit']");
	}

	public static void adminLogin(KeywordOfWeb kw) {
		adminLoginMethod(kw);
	}

}
