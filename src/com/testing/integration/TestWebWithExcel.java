package com.testing.integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.testing.UI.DataDrivenOfWeb;
import com.testing.common.ExcelReader;
import com.testing.common.ExcelWriter;

public class TestWebWithExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 把当前的执行时间加入到结果文件名中
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd+HH-mm-ss");
		String createdate = sdf.format(date);
		String resultPath = "cases/resultWebcases" + createdate + ".xlsx";
		// 实例化excelReader类，完成对用例的读取，实例化excelWriter实现在操作关键字时，写入结果文件。
		ExcelReader webCases = new ExcelReader("cases/WebCases.xlsx");
		ExcelWriter webRes = new ExcelWriter("cases/WebCases.xlsx", resultPath);
		// 实例化关键字类，以在之后实现对关键字的操作
		DataDrivenOfWeb web = new DataDrivenOfWeb(webRes);
		// 遍历用例文件中每一行的内容，读取关键字所在的列数，判断执行哪种关键字，并调用其参数
		// 用list读取用例行，保存每一行中的内容
		List<String> list = null;
		// 遍历用例文件中的每一行，读取其内容存入list中，再从list读取关键字对应的字符串。
		// 从第1行开始，直到用例文件最大行数（最后一行）遍历用例文件
		for (int line = 0; line < webCases.rows; line++) {
			// 通过成员变量line，确认当前执行的用例行数，以进行每个关键字操作时的写入结果动作
			web.line = line;
			// 从用例文件读取当前行的内容
			list = webCases.readLine(line);
			System.out.println(list);
			// 判断第一个和第二个单元格的值是否为空，如果不为空，则不做任何操作
			if ((list.get(0) != null || list.get(1) != null)
					&& (!list.get(0).equals("null") || !list.get(1).equals("null"))
					&& (list.get(0).length() > 0 || list.get(1).length() > 0)) {
				;
			}
			// 第一个和第二个单元格均为空时，则是需要执行的用例或者用例步骤
			else {
				// 通过Excel表中填写的关键字判断调用哪个方法执行
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
			}
		}
		// 保存结果文件。
		webRes.save();
	}
}
