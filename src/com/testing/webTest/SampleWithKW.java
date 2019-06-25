package com.testing.webTest;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.testing.UI.AutoLogger;
import com.testing.UI.KeywordOfWeb;

public class SampleWithKW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeywordOfWeb kw =new KeywordOfWeb();
		kw.openBrowser("chrome");
//		kw.implicitlyWait();
		AutoLogger.log.info("正在执行访问百度");
		kw.visitWeb("http://www.baidu.com");
		AutoLogger.log.info("在输入框中输入特斯汀学院");
		kw.input("//input[@id='kw']", "特斯汀学院");
		AutoLogger.log.info("等待5秒");
		kw.halt("5");
		kw.assertTitleContains("特斯汀学院");
		AutoLogger.log.info("关闭浏览器");
		kw.closeBrowser();
	}

}
