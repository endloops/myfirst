package com.wzz.demo.db.persisit;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SnowflakeIdHelper {

	private static final int HUNDRED = 100;
	
	public static Object getId() {
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		
		StringBuffer buffer = new StringBuffer(dateFormat.format(date));
		buffer.append(getRandomNum());
		return buffer.toString();
	}
	private static String getRandomNum() {
		NumberFormat nf2 = NumberFormat.getInstance();
		nf2.setGroupingUsed(false);
		nf2.setMaximumIntegerDigits(2);
		nf2.setMinimumIntegerDigits(2);
		double d = Math.random() * HUNDRED;
		int i = (int) d;
		String random = nf2.format(i);
		return random;
	}
	
}
