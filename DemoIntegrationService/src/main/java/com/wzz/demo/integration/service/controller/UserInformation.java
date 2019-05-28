package com.wzz.demo.integration.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wzz.demo.integration.service.service.interfaces.UserInformationService;
import com.wzz.demo.integration.service.service.request.UserInformationRibbonModel;

@RestController
@RequestMapping("/user")
public class UserInformation {

	@Autowired
	UserInformationService userInformationService;
	
	@GetMapping("/information/{id}")
	public UserInformationRibbonModel searchUserByID(@PathVariable("id") Long id) {
		
		UserInformationRibbonModel res = userInformationService.searchUserByID(id);
		System.out.println(res.toString());
		return res;
	}
	
	
}
