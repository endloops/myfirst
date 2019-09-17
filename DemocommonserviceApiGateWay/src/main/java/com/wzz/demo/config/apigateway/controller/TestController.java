package com.wzz.demo.config.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.MediaType;

@RestController
@RequestMapping("/apis")
public class TestController {

	@ResponseBody
	@GetMapping(path="/get",produces={org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE})
	public TestBean sera(){
		TestBean bean = new TestBean();
		bean.setName("'/");
		return  bean;
	}
}
