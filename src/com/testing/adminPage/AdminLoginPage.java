package com.testing.adminPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.UI.KeywordOfWeb;

public class AdminLoginPage {
	public KeywordOfWeb kw;
	public String Url="http://112.74.191.10:8000/Admin/Admin/login";
	@FindBy(xpath = "//input[@name='username']")
	public WebElement user;

	@FindBy(xpath = "//input[@name='password']")
	public WebElement password;

	@FindBy(xpath = "//*[@id='vertify']")
	public WebElement verifyCode;

	@FindBy(xpath = "//input[@name='submit']")
	public WebElement submitBtn;
	
	
	public AdminLoginPage(KeywordOfWeb keyword) {
		kw=keyword;
		PageFactory.initElements(kw.driver, this);
	}

	public void load() {
		kw.visitWeb(Url);

	}

	public void login() {
		user.sendKeys("admin");
		password.sendKeys("123456");
		verifyCode.sendKeys("1");
		submitBtn.click();
		kw.halt("2");
	}
}
