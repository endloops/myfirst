package com.wzz.demo.config.apigateway.controller.store;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
/**
 * 测试类
 * @author wang
 *
 */
public class Test {
	
	public static BigDecimal price;
	
	public static BigDecimal tax;
	
	public static List<List<String[]>> list;
	
	public static void main(String[] args) {
		generalDB();
		doOperation();
	}
	/**
	 * 做操作
	 */
	public static void doOperation(){
		PaymentCenter center = new PaymentCenter();
		Order order = new Order();
		order.addObserver(center);
		for (List<String[]> list : list) {
			order.instanceCommodity();
			for (String[] string : list) {
				Commodity res = CommodityFactory.create(string);
				order.addNewCommodity(res, Integer.parseInt(string[4]));
			}
			/**
			 * 发送订单
			 */
			order.sendOrder();
			/**
			 * 获取订单中心反馈
			 */
			price = center.getPrice();
			/**
			 * 获取订单中心反馈
			 */
			tax = center.getTax();
			System.out.println("---------------------total----------------------");
			System.out.println("tax:" + tax);
			System.out.println("price:" + price);
			System.out.println("----------------------order-----------------------");
		}
	}
	/**
	 * 生成数据组
	 */
	public static void generalDB() {
		List<String[]> source = new ArrayList<String[]>();
		String[] a = { "aaa", "books", "local", "12.45", "1" };
		String[] b = { "bbb", "cosmetic", "imported", "10.00", "1" };
		String[] c = { "ccc", "foods", "local", "4.25", "1" };
		source.add(a);
		source.add(b);
		source.add(c);
		List<String[]> source1 = new ArrayList<String[]>();
		String[] d = { "aaa", "foods", "imported", "45.35", "1" };
		String[] e = { "bbb", "music", "imported", "8.75", "1" };
		source1.add(d);
		source1.add(e);
		List<String[]> source2 = new ArrayList<String[]>();
		String[] f = { "aaa", "medicine", "imported", "25.55", "1" };
		String[] g = { "bbb", "music", "local", "17.15", "1" };
		String[] h = { "ccc", "cosmetic", "imported", "3.25", "1" };
		String[] i = { "ddd", "books", "local", "33.65", "1" };
		source2.add(f);
		source2.add(g);
		source2.add(h);
		source2.add(i);
		if(list==null){
			list = new ArrayList<>();
		}
		list.add(source);
		list.add(source1);
		list.add(source2);
	}
}
