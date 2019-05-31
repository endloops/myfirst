package com.wzz.demo.config.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis")
public class TestController {

	@ResponseBody
	@GetMapping("/get")
	public TestBean sera(){
		TestBean bean = new TestBean();
		bean.setName("'/");
		return  bean;
	}
}
