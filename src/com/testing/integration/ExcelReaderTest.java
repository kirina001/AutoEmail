package com.testing.integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.testing.common.ExcelReader;
import com.testing.common.ExcelWriter;
import com.testing.inter.KeywordOfInter;

public class ExcelReaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 获取当前的执行时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd+HH-mm-ss");
		// 当前时间的字符串
		String createdate = sdf.format(date);
		KeywordOfInter key=new KeywordOfInter();
		ExcelReader excel=new ExcelReader("cases/InterfaceCases.xlsx");
		ExcelWriter outExcel=new ExcelWriter("cases/InterfaceCases.xlsx", "cases/result"+createdate+".xlsx");
		for(int i=0;i<excel.rows;i++) {
		List<String> list=excel.readLine(i);
		System.out.println(list);
		}
		String result=null;
//		根据list中第4个元素（第4列）的值来判断应该执行什么关键字方法
//		switch(list.get(3)) {
//		case "post":
//			//传递第5列和第6列的值作为调用关键字方法时的参数。
//			result=key.testPost(list.get(4), list.get(5));
//			break;
//		case "get":
//			result=key.testGet(list.get(4), list.get(5));
//			break;
//		case "saveCookie":
//			key.saveCookie();
//			break;
//		}
//		//根据第7列的值，调用断言的方法
//		boolean flag=true;
//		switch(list.get(6)) {
//		case "equal":
//			flag=key.assertSame(result, list.get(9), list.get(8));
//			break;
//		default:
//				flag=true;
//				break;
//		}
//		//根据断言的结果，确定是写pass还是fail
//		if(flag) {
//		outExcel.writeCell(3, 10, "PASS");
//		}
//		else {
//		outExcel.writeFailCell(3, 10, "FAIL");
//		}
//		outExcel.save();
		
		
	}

}
