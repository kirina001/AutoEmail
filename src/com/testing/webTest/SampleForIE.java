package com.testing.webTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testing.UI.IEDriver;

public class SampleForIE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
    	//设置火狐的webdriver路径。
//    	System.setProperty("webdriver.ie.driver", "tools/IEDriver.exe");	
//    	//通过创建driver，启动火狐浏览器
//        WebDriver driver = new InternetExplorerDriver();

		IEDriver IE=new IEDriver("tools/IEDriver.exe");
		WebDriver driver=IE.getdriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // And now use this to visit Google
       //访问百度
        driver.get("http://www.baidu.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        //定位到百度的输入框元素
        WebElement element = driver.findElement(By.name("wd"));

        // Enter something to search for
        //在输入框中输入内容
        element.sendKeys("Cheese!");
        
        // Check the title of the page
        //获取页面的标题即<head>标签中的title元素内容
        System.out.println("Page title is: " + driver.getTitle());

        // Now submit the form. WebDriver will find the form for us from the element
        //完成form表单的提交
        element.submit();

        
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        //显式等待，等待10秒，如果10秒内，页面的标题变为了cheese!开头，则结束等待，执行之后的内容，否则等到10s然后报错。
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
            	//判断当前页面的标题是否以cheese!开头
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        //获取页面的标题即<head>标签中的title元素内容
        System.out.println("Page title is: " + driver.getTitle());
        
        //Close the browser
        //关闭浏览器并且关闭driver进程
        driver.quit();
	}

}
