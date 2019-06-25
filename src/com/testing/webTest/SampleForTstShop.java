package com.testing.webTest;

import com.testing.UI.AutoLogger;
import com.testing.UI.KeywordOfWeb;

public class SampleForTstShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeywordOfWeb kw = new KeywordOfWeb();
		kw.openBrowser("chrome");
		kw.setWindow();
		//登录
		login(kw);
		//加入购物车
		kw.click("//a[@class='home']");
		kw.hover("//a[text()='手机数码']");
		kw.halt("1");
		kw.click("//a[text()='老人手机']/preceding-sibling::a");
		kw.switchWindow("商品列表");
		//点击第一个手机连接
		kw.click("//img[@src='/public/upload/goods/thumb/13/goods_thumb_13_0_236_236.png']");
		//加入购物车
		kw.click("//*[@id='join_cart']");
		//切换到Iframe中
		kw.intoIframe("//*[@id='layui-layer-iframe1']");
		kw.click("//a[@class='ui-button ui-button-122 fl']");
		//切出iframe，保持良好习惯
		kw.outIframe();
		//切换窗口
		kw.switchWindow("我的购物车列表");
		//将下单数量改成1
		kw.input("//*[@id='changeQuantity_52']", "1");
		kw.halt("2");
		String JsResult=kw.getJs("return $(\"div.column.t-quantity.mtp.quantity-form>input\")[0].value=\"123\"");
		System.out.println("结果是"+JsResult);
		kw.halt("2");
		kw.click("//a[@class='paytotal']");
		kw.halt("2");
		//点击结算
		kw.click("//button[@type='submit']");
		kw.halt("15");
//		kw.closeBrowser();
	}

	public static void login(KeywordOfWeb kw) {
		kw.visitWeb("http://112.74.191.10:8000/");
		kw.click("//a[@class='red']");
		kw.input("//input[@id='username']", "2798145476@qq.com");
		kw.input("//input[@id='password']", "qinghong");
		kw.input("//input[@placeholder='验证码']", "1");
		kw.click("//a[@name='sbtbutton']");
	}
	
	public static void addCart(KeywordOfWeb kw) {
		kw.visitWeb("http://112.74.191.10:8000/Home/Index/index.html");
		kw.input("//input[@id='q']", "Roy老师");
		kw.click("//button[@type='submit']");
		kw.click("//div[@class='shop-list-splb p']/ul/li[1]/div/div[1]/a");
		kw.click("//*[@id='join_cart']");
	}

}
