package com.wzz.demo.db.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wzz.demo.db.controller.response.UserInformationRibbonModel;

@RestController
@RequestMapping("/searchUser")
public class DBUserInformationController {
	
	@GetMapping("/{id}")
	public UserInformationRibbonModel searchUserInformationDB(@PathVariable("id") Long id) throws Exception{
		 return new UserInformationRibbonModel("2222", "2222", "2222", null);
	}
}
