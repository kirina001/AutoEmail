package com.testing.ShopPage;

import java.sql.Driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.UI.KeywordOfWeb;
import com.testing.webTest.TestPO;

public class LoginPage  {
	public KeywordOfWeb kw;
	public String Url = "http://112.74.191.10:8000/Home/user/login.html";

	@FindBy(xpath = "//input[@id='username']")
	public WebElement user;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;

	@FindBy(xpath = "//input[@placeholder='验证码']")
	public WebElement verifyCode;

	@FindBy(xpath = "//a[@name='sbtbutton']")
	public WebElement submitBtn;

	public LoginPage(KeywordOfWeb keyword) {
		kw=keyword;
		PageFactory.initElements(kw.driver, this);
	}

	public void load() {
		kw.visitWeb(Url);
	}

	public void login() {
		user.sendKeys("2798145476@qq.com");
		password.sendKeys("qinghong");
		verifyCode.sendKeys("1");
		submitBtn.click();
		kw.halt("2");
	}

}
