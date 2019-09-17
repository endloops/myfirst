package com.wzz.demo.oauth2.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Oauth2Controller {

	 @RequestMapping("/userInfo")
	 public Principal userinfo(Principal principal) {
	        return principal;
	 }
}
