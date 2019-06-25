package com.testing.appTest;

import com.testing.UI.AutoLogger;
import com.testing.appkw.KeywordOfApp;

public class MeituanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeywordOfApp app=new KeywordOfApp();
		app.runMM("6.0.1", "127.0.0.1:7555", 
				"com.tencent.mm", ".ui.LauncherUI", 
				"http://127.0.0.1:4723/wd/hub", "10000");
		app.appiumSwipe("300", "300", "300", "600");
		app.click("//android.widget.FrameLayout[@content-desc=\"当前所在页面,与青鸿的聊天\"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/com.tencent.mm.ui.mogic.WxViewPager/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.ImageView[2]");
		app.wait("10000");
		app.printContexts();
		app.wait("5000");
		app.click("//android.view.View[@content-desc=\"甜点饮品\"]");
		app.wait("5000");
		app.switchContext("WEBVIEW_com.tencent.mm:appbrand0");
		AutoLogger.log.info("切换context完成");
		app.click("//wx-view[contains(text(),'鲜芋仙')]");
	}

}
