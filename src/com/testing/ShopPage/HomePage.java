package com.testing.ShopPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.UI.KeywordOfWeb;

public class HomePage {
	public KeywordOfWeb kw;
	public String Url = "http://112.74.191.10:8000/Home/Index/index.html";

	@FindBy(xpath = "//input[@id='q']")
	public WebElement searchInput;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement searchBtn;

	@FindBy(xpath = "//div[@class='shop-list-splb p']/ul/li[1]/div/div[1]/a")
	public WebElement firstGood;
	
	@FindBy(xpath = "//*[@id='join_cart']")
	public WebElement addCartBtn;

	public HomePage(KeywordOfWeb keyword) {
		kw=keyword;
		PageFactory.initElements(kw.driver, this);
	}

	public void load() {
		kw.visitWeb(Url);
	}

	public void joinCart() {
		searchInput.sendKeys("Roy老师");
		searchBtn.click();
		kw.halt("3");
		firstGood.click();
		addCartBtn.click();
	}


}
