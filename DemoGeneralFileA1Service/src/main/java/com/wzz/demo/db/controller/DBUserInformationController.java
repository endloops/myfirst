package com.wzz.demo.db.controller;

import java.util.UUID;

import org.hibernate.id.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wzz.demo.db.business.FirstTestService;
import com.wzz.demo.db.controller.response.UserInformationRibbonModel;
import com.wzz.demo.db.persisit.FirstTestPO;
import com.wzz.demo.db.persisit.repository.FirstTestRepository;

@RestController
@RequestMapping("/searchUser")
public class DBUserInformationController {
	
	@Autowired
	FirstTestRepository firstTestRepository;
	
	@Autowired
	FirstTestService firstTestService;
	
	@GetMapping("/{id}")
	public UserInformationRibbonModel searchUserInformationDB(@PathVariable("id") Long id){
		FirstTestPO entity = new FirstTestPO();
		FirstTestPO respo = firstTestService.saveNewFirstTestPO(entity);
		return new UserInformationRibbonModel("111", "123123", "大小写", null);
	}
	@GetMapping("/instert")
	public FirstTestPO saveFitstTest(){
		FirstTestPO entity = new FirstTestPO();
		FirstTestPO respo = firstTestRepository.save(entity);
		return respo;
	}
	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
	}
}
