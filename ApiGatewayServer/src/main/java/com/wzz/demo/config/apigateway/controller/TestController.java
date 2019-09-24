package com.wzz.demo.config.apigateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis")
public class TestController {

	@Autowired
	private String test;
	
	@ResponseBody
	@GetMapping(path="/get",produces={org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE})
	public TestBean sera(){
		TestBean bean = new TestBean();
		bean.setName("'/");
		System.out.println(test);
		return  bean;
	}
	@ResponseBody
	@GetMapping(path="update")
	public TestBean update(){
		TestBean bean = new TestBean();
		bean.setName("'/");
		test="bb";
		return  bean;
	}

}
