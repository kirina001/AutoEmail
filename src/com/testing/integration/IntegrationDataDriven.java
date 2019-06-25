package com.testing.integration;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;

import com.testing.UI.AutoLogger;
import com.testing.UI.DataDrivenOfWeb;
import com.testing.appkw.DataDrivenOfApp;
import com.testing.common.ExcelReader;
import com.testing.common.ExcelWriter;
import com.testing.inter.DataDrivenOfInter;
import com.testing.inter.DataDrivenOfSoap;

public class IntegrationDataDriven {
	public static DataDrivenOfWeb web;
	public static DataDrivenOfInter inter;
	public static DataDrivenOfSoap soap;
	public static DataDrivenOfApp app;
	public static String filepath;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		 String type = args[0];
		 String type="app";
		// 获取项目的绝对路径
		filepath =System.getProperty("user.dir");
		// 根据不同的自动化类型，拼接用例文件和结果文件的路径
		String filename = "/cases/";
		String fileres = "/cases/result-";
		//
		try {
			System.out.println("log::info：文件路径：" + filepath);
			String date = createDate("yyyyMMdd+HH-mm-ss");
			String starttime=createDate("yyyy-MM-dd HH:mm:ss");
			switch (type) {
			case "web":
				filename += "WebCases.xlsx";
				fileres += "WebCases" + date + ".xlsx";
				break;
			case "http":
				filename += "HTTPLogin.xlsx";
				fileres += "HTTPLogin" + date + ".xlsx";
				break;
			case "app":
				filename += "APPCases.xlsx";
				fileres += "APPCases" + date + ".xlsx";
				break;
			case "soap":
				filename += "SOAPLogin.xlsx";
				fileres += "SOAPLogin" + date + ".xlsx";
				break;
			default:
				filename += "webCases.xls";
				fileres += "webCases.xls";
				System.out.println("log::error：类型错误！已经默认执行UI自动化。");
				break;
			}
			System.out.println("用例文件路径：" + filepath + filename);
			GetCase(filepath + filename, filepath + fileres, type);// 设置用例文件的路径
		} catch (Exception e) {
			System.out.println("log::error：获取文件位置失败，请检查。");
			e.printStackTrace();
		}

		System.out.print("输入回车，退出...");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void GetCase(String file, String fileres, String type) {
		// 打开Excel
		ExcelReader excelr = new ExcelReader(file);
		ExcelWriter excelw = new ExcelWriter(file, fileres);

		List<String> list = null;
		// 根据传入的用例和结果文件路径，实例化关键字类的成员变量
		inter = new DataDrivenOfInter(excelw);
		web = new DataDrivenOfWeb(excelw);
		soap = new DataDrivenOfSoap(excelw);
		app = new DataDrivenOfApp(excelw);

		for (int line = 0; line < excelr.rows; line++) {
			list = excelr.readLine(line);
			System.out.println(list);
			if ((list.get(0) != null || list.get(1) != null)
					&& (!list.get(0).equals("null") || !list.get(1).equals("null"))
					&& (list.get(0).length() > 0 || list.get(1).length() > 0)) {
				;
			} else {
				switch (type) {
				case "web":
					web.line = line;
					runWeb(list);
					break;
				case "http":
					inter.line = line;
					runHttp(list);
					break;
				case "soap":
					// 确定执行的行数
					soap.line = line;
					runSoap(list);
					break;
				case "app":
					app.line=line;
					invokeAppKey(list);
					break;
				default:
					break;
				}
			}
		}
		excelr.close();
		excelw.save();
	}

	private static void runWeb(List<String> list) {
		try {
			switch (list.get(3)) {
			case "打开浏览器":
				web.openBrowser(list.get(4));
				break;
			case "geturl":
				web.visitWeb(list.get(4));
				break;
			case "input":
				web.input(list.get(4), list.get(5));
				break;
			case "click":
				web.click(list.get(4));
				break;
			case "intoIframe":
				web.intoIframe(list.get(4));
				break;
			case "selectByValue":
				web.selectByValue(list.get(4), list.get(5));
				break;
			case "closeOldWin":
				web.closeOldWin();
				break;
			case "sleep":
				web.halt(list.get(4));
				break;
			case "assertcontains":
				web.assertTitleContains(list.get(4));
				break;
			case "closebrowser":
				web.closeBrowser();
				break;
			case "login":
				web.login(list.get(4),list.get(5));
				break;
			}
		} catch (Exception e) {
			AutoLogger.log.error("执行web关键字时出错");
		}

	}

	// 执行接口用例
	private static void runHttp(List<String> list) {
		// TODO Auto-generated method stub
		// 执行关键字相应操作
		try {
			//通过Excel表中填写的关键字判断调用哪个方法执行
			switch(list.get(3)) {
			case "post":
				inter.testPost(list.get(4), list.get(5));
				break;
			case "get":
				inter.testGet(list.get(4), list.get(5));
				break;
			case "testPostRest":
				inter.testPostRest(list.get(4), list.get(5));
				break;
			case "savecookie":
				inter.saveCookie();
				break;
			case "clearcookie":
				inter.clearCookie();
				break;
			case "addHeader":
				inter.addHeader(list.get(4));
				break;
			case "saveParam":
				inter.saveParam(list.get(4), list.get(5));
				break;
			}
			//通过excel表中填写的校验方法确定
			switch(list.get(7)) {
			case "equal":
				inter.assertSame(list.get(9), list.get(10));
				break;
			case "contain":
				inter.assertContains(list.get(9), list.get(10));
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}			

	private static void runSoap(List<String> list) {
		try {
			//通过Excel表中填写的关键字判断调用哪个方法执行
			switch(list.get(3)) {
			case "createCon":
				soap.createCon(list.get(4));
				break;
			case "testSoap":
				soap.testSoap(list.get(4), list.get(5), list.get(6));
				break;
			case "addHeader":
				soap.addHeader(list.get(4));
				break;
			case "saveParam":
				soap.saveParam(list.get(4), list.get(5));
				break;
			}
			//通过excel表中填写的校验方法确定
			switch(list.get(7)) {
			case "equal":
				soap.assertSame(list.get(9), list.get(10));
				break;
			case "contain":
				soap.assertContains(list.get(9), list.get(10));
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public static void invokeAppKey(List<String> line) {
		try {
			Method appMethod = app.getClass().getDeclaredMethod(line.get(3).toString());
			// invoke语法，需要输入类名以及相应的方法用到的参数
			appMethod.invoke(app);
			return;
		} catch (Exception e) {
		}
		try {
			Method uis = app.getClass().getDeclaredMethod(line.get(3).toString(), String.class);
			// invoke语法，需要输入类名以及相应的方法用到的参数
			uis.invoke(app, line.get(4));
			return;
		} catch (Exception e) {
		}
		try {
			Method uis = app.getClass().getDeclaredMethod(line.get(3).toString(), String.class, String.class);
			// invoke语法，需要输入类名以及相应的方法用到的参数
			uis.invoke(app, line.get(4), line.get(5));
			return;
		} catch (Exception e) {
		}
		try {
			Method uis = app.getClass().getDeclaredMethod(line.get(3).toString(), String.class, String.class,
					String.class);
			// invoke语法，需要输入类名以及相应的方法用到的参数
			uis.invoke(app, line.get(4), line.get(5), line.get(6));
			return;
		} catch (Exception e) {
		}
		try {
			Method uis = app.getClass().getDeclaredMethod(line.get(3).toString(), String.class, String.class,
					String.class,String.class);
			// invoke语法，需要输入类名以及相应的方法用到的参数
			uis.invoke(app, line.get(4), line.get(5), line.get(6),line.get(7));
			return;
		} catch (Exception e) {
		}
		try {
			Method uis = app.getClass().getDeclaredMethod(line.get(3).toString(), String.class, String.class,
					String.class,String.class,String.class);
			// invoke语法，需要输入类名以及相应的方法用到的参数
			uis.invoke(app, line.get(4), line.get(5), line.get(6),line.get(7),line.get(8));
			return;
		} catch (Exception e) {
		}
		try {
			Method uis = app.getClass().getDeclaredMethod(line.get(3).toString(), String.class, String.class,
					String.class,String.class,String.class,String.class);
			// invoke语法，需要输入类名以及相应的方法用到的参数
			uis.invoke(app, line.get(4), line.get(5), line.get(6),line.get(7),line.get(8),line.get(9));
			return;
		} catch (Exception e) {
		}
	}

	private static String createDate(String dateFormat) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String createdate = sdf.format(date);
		return createdate;
	}
}
