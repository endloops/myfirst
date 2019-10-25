package com.wzz.demo;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
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
		List<String> ss = new ArrayList<>();
				return foo;
	}
	public static void main(String[] args) throws NoSuchAlgorithmException {
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		byte[] bytes = new byte[5];
		random.nextBytes(bytes);
		System.out.println(random.nextInt(100000000));
	}
}
