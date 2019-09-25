package com.wzz.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(path = "/adminclient")
public class TestController {

	@Value("${foo}")
	String foo;

	@RequestMapping(value = "/hi")
	public String hi() {
		return foo;
	}
}
