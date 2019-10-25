package com.wzz.demo.config.apigateway.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SSS {
	  public static String[] findWords(String[] words) {
	        char[] s1 = {'Q','W','E','R','T','Y','U','I','O','P'}; 
	        char[] s2 = {'A','S','D','F','G','H','J','K','L'};
	        char[] s3 = {'Z','X','C','V','B','N','M'};
	        String[] ss = {new String(s1),new String(s2),new String(s3)};
	        List<String> res = new ArrayList<>();
	        Map<Character, Integer> map = new HashMap<>();
	        for(int i = 0; i<ss.length;i++){
	            for (char c : ss[i].toCharArray()) {
	            	map.put(c, i);
	            }
	        }
	        int index;
	        for(String word:words){
	            index = map.get(word.toUpperCase().toCharArray()[0]);
	            for(char c : word.toUpperCase().toCharArray()){
	                if(map.get(c)!=index){
	                    index = -1;
	                    break;
	                }
	            }
	            if(index!=-1){
	                res.add(word);
	            }
	        }
	        return res.toArray(new String[res.size()]);
	    }
	public static void main(String[] args) {
		String[] input = {"Hello", "Alaska", "Dad", "Peace"};
		String[] res = findWords(input);
		System.out.println(Arrays.toString(res));
	}
}
