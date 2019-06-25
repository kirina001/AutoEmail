package com.testing.appTest;

import java.io.IOException;

import org.openqa.selenium.By;

import com.testing.appkw.KeywordOfApp;

import io.appium.java_client.MobileBy;

public class QQtestWithKw {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		KeywordOfApp appkw= new KeywordOfApp();
		appkw.StartAppium("4723", "10000");
		appkw.runAPP("6.0.1", "127.0.0.1:7555",
				"com.tencent.mobileqq", ".activity.SplashActivity", "http://127.0.0.1:4723/wd/hub", "15000");
		appkw.driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.tencent.mobileqq:id/btn_login']")).click();
		appkw.driver.findElement(MobileBy.AccessibilityId("请输入QQ号码或手机或邮箱")).clear();
		appkw.driver.findElement(MobileBy.AccessibilityId("请输入QQ号码或手机或邮箱")).sendKeys("2798145476");
		appkw.driver.findElement(By.xpath("//android.widget.EditText[@content-desc='密码 安全']")).clear();
		appkw.driver.findElement(By.xpath("//android.widget.EditText[@content-desc='密码 安全']")).sendKeys("roy12345");
		appkw.driver.findElement(By.xpath("//android.widget.Button[@content-desc='登录']")).click();
		appkw.appiumSwipe("300", "650", "300", "850");
		//点击搜索按钮
		appkw.click("//android.widget.EditText[@resource-id='com.tencent.mobileqq:id/et_search_keyword']");
		//在搜索框中输入内容
		appkw.input("//android.widget.EditText[@resource-id='com.tencent.mobileqq:id/et_search_keyword']", "578225840");
		//点击头像
		appkw.click("//android.widget.RelativeLayout[@resource-id='com.tencent.mobileqq:id/name']/android.widget.ImageView[1]");
		//点击设置
		appkw.click("//android.widget.ImageView[@resource-id='com.tencent.mobileqq:id/ivTitleBtnRightImage']");
		//点击信息栏
		appkw.click("//android.widget.LinearLayout[@resource-id='com.tencent.mobileqq:id/name']/android.widget.RelativeLayout[1]");
		//特权
		appkw.click("//android.widget.TextView[@text='TA还未开通任何特权服务']");
		appkw.wait("5000");
		//向上滑动屏幕
		appkw.appiumSwipe("300", "650", "300", "200");
		appkw.click("//android.view.View[@resource-id='service_vip']/android.view.View[3]/android.widget.Button[1]");
		appkw.quitApp();
		appkw.killAppium();
	}
		
}
