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
		 throw new Exception("德玛西亚，动词大慈");
	}
}
