package com.wzz.demo.config.apigateway.controller;

import java.util.Arrays;

public class SSSS {

	String[] s = { "Hundred", "Thousand", "Million", "Billion" };
	String[] ss = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
	String[] sss = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };

	// 最大位置
	public static int maxDistToClosest(int[] seats) {
		int start = -1;// 连续0起始位置
		int end = -1;// 连续0结束位置
		int max = 0; // 连续0数量
		int dis = 0;
		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 0 && max == 0) {
				max += 1;
				start = i;
			} else if (seats[i] == 0 && max != 0) {
				max += 1;
				end = i;
			} else {
				if (start == 0 && max > 0) {
					dis = max;
				} else if (end == seats.length - 1 && max > 0) {
					dis = dis > max ? dis : max;
				} else if (max > 0) {
					dis = dis > (max + 1) / 2 ? dis : (max + 1) / 2;
				}
				max = 0;
				start = -1;
				end = -1;
			}
		}
		if (end == seats.length - 1 && max > 0) {
			return dis = dis > max ? dis : max;
		}
		return dis;

	}

	public static int[] moveZeroes(int[] nums) {
		int y = 0;
		for(int x = 0;x<nums.length;x++) {
			if (nums[x] != 0) {
				nums[y] = nums[x];
				y++;
			}
			
		}
		for(int i = y; i < nums.length; i++) {
            nums[i] = 0;
        }
		return nums;

	}

	public static void main(String[] args) {
		int[] ss = { 1, 0, 1, 2, 1 };
		// System.out.println(maxDistToClosest(ss));
		System.out.println(Arrays.toString(moveZeroes(ss)));
	}
}
