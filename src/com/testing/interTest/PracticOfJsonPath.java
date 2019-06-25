package com.testing.interTest;

import java.util.Iterator;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class PracticOfJsonPath {
	public static final String json="{" + 
			"\"testing\": {" + 
			"\"teacher\": [" + 
			"{" + 
			"\"name\": \"roy\"," + 
			"\"age\": \"28\"," + 
			"\"course\": \"java\"," + 
			"\"id\": 1" + 
			"}," + 
			"{" + 
			"\"name\": \"will\"," + 
			"\"age\": \"28\"," + 
			"\"course\": \"python\"," + 
			"\"id\": 2" + 
			"}," + 
			"{" + 
			"\"name\": \"土匪\"," + 
			"\"age\": \"36\"," + 
			"\"course\": \"性能\"," + 
			"\"description\": \"大牛\"," + 
			"\"id\": 3" + 
			"}," + 
			"{" + 
			" \"name\": \"卡卡\"," + 
			"\"age\": \"24\"," + 
			"\"course\": \"All\"," + 
			"\"description\": \"小鲜肉\"," + 
			"\"id\": 4" + 
			"}" + 
			"]," + 
			"\"bicycle\": {" + 
			"\"color\": \"red\"," + 
			"\"id\": 5" + 
			"}" + 
			"}," + 
			"\"ClassID\": 4" + 
			"}";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int id1=JsonPath.read(json, "$.testing.bicycle.id");
		System.out.println(id1);
		List<Object> teachers=JsonPath.read(json, "$.testing.teacher[?(@.id < 3)]");
		System.out.println(teachers);
		for(Iterator<Object> it=teachers.iterator();it.hasNext();) {
			System.out.println(it.next());
		}
	}

}
