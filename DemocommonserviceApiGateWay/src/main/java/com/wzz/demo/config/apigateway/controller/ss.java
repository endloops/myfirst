package com.wzz.demo.config.apigateway.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ss {
	
		public static int thirdMax(int[] nums) {
			
			 	if (nums == null || nums.length == 0)
		            return -1;
		        int len = nums.length;
		        if (len == 1)
		            return nums[0];
		        if (len == 2)
		            return Math.max(nums[0], nums[1]);
		        int cf = len;
		        int n1 = Integer.MIN_VALUE;
		        int n2 = Integer.MIN_VALUE;
		        int n3 = Integer.MIN_VALUE;
		        
		        boolean fi=false;
		        for (int num : nums) {
		        	 if(num==Integer.MIN_VALUE&&!fi){//用于解决第一次出现最小值的问题
		                 fi=true;
		                 continue;
		             }
		        	 if(num==n1||num==n2||n3==num) {
		                 cf--;
		                 continue;    //15841334
		             }
		             if(num>n1) {
		                 n3=n2;
		                 n2=n1;
		                 n1=num;
		                 continue;
		             } 
		             else if(num>n2) {
		                 n3=n2;
		                 n2=num;
		                 continue;
		             }
		             else if(num>n3) {
		                 n3=num;
		             }
		        	
				}
		        return cf>=3?n3:n1;
			
	    }
		public static int thirdMaxs(int[] nums) {
			
			Set<Integer> set = new HashSet<>();
			for (Integer integer : nums) {
				set.add(integer);
			}
			Integer [] s = new Integer[set.size()]; 
	 		set.toArray(s);
	 		Arrays.sort(s);
		 	if(s.length>=3){
		 		return s[s.length-3] ;   
		 	}else{
		 		return s[s.length-1];
		 	}
			
    }
	    public static void main(String[] args) {
	    	int[] ss = {1,2,2,2,2,1};
	    	System.out.println(thirdMax(ss));
	    	System.out.println(thirdMaxs(ss));
		}
}
