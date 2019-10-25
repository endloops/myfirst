package com.wzz.demo.config.apigateway.controller.store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TestC {
	public static void main(String[] args) {
		List<Integer> employees = new ArrayList<>();
		employees.add(9999);
		employees.add(8000);
		employees.add(12000);
		employees.add(20000);
		employees.add(22000);
		// 按照年龄过滤
		System.out.println("-------------按照年龄过滤--------------");
		Collections.sort(employees, (s1,s2)->s2.compareTo(s1));
		// 按照工资过滤
		System.out.println(employees.toString());
	}
	public  void ts(String[] args) {
	
	}
}
