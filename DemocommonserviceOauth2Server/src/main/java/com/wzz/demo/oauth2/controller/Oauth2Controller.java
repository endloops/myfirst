package com.wzz.demo.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oau")
public class Oauth2Controller {

	@GetMapping("/ssss")
	public void sss(){
		System.out.println("11111");
	}
}
