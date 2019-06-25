package com.testing.webTest;

import com.testing.UI.KeywordOfWeb;

public class SampleOfUserInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeywordOfWeb kword=new KeywordOfWeb();
		kword.openBrowser("chrome");
		kword.login("","");
		kword.halt("3");
		kword.click("/html/body/div[3]/div/div[2]/div[1]/div/ul[4]/li[2]/a");
		kword.click("//*[@id='preview']");
		kword.intoIframe("//iframe[@id='layui-layer-iframe1']");
		kword.input("//div[@id='filePicker']/div[2]/input", "F:\\timg.jpg");
	}

}
