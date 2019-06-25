package com.testing.interTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.testing.common.ExcelReader;
import com.testing.common.ExcelWriter;
import com.testing.inter.DataDrivenOfSoap;

public class TestSoapInterWithExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//把当前的执行时间加入到结果文件名中
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HH+mm+ss");
        String createdate = sdf.format(date);
		//打开Excel表进行读取
		ExcelReader excelR = new ExcelReader("cases/SOAPLogin.xlsx");
		//复制用例中的内容到结果中，并执行之后的写入操作
		ExcelWriter excelW = new ExcelWriter("cases/SOAPLogin.xlsx", "cases/Res-SOAPLogin"+createdate+".xlsx");
		//创建关键字类
		DataDrivenOfSoap soap = new DataDrivenOfSoap(excelW);
		//通过list读取每行中的内容
		List<String> list =null;
		//遍历excel当中每一行，执行关键字并将结果写入对应单元格
		for (int caseline =0;caseline<excelR.rows;caseline++) {
			//读取excel当中的每行内容
			System.out.println(excelR.readLine(caseline));
			//调用时，赋值给关键字类中的成员变量line
			soap.line=caseline;
			//读取每行中的内容
			list=excelR.readLine(caseline);
			//判断第一第二列是否为空，第一、二列为空才是要执行的
			if ((list.get(0) != null || list.get(1) != null)
					&& (!list.get(0).equals("null") || !list.get(1).equals("null"))
					&& (list.get(0).length() > 0 || list.get(1).length() > 0)) {
				;
			}
			else {
				//trycatch块保证每条用例即使报错也能继续往下执行
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
		}
		//保存写入的结果文件
		excelW.save();
	}

}
