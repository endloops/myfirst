package com.wzz.demo.integration.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import com.wzz.demo.db.SecondTestPO;
import com.wzz.demo.db.repository.SecondTestPORepository;
import com.wzz.demo.integration.service.service.feign.UserServiceFeign;

@Service
public class SecondTestServiceImpl {

	@Autowired
	SecondTestPORepository repository;
	
	@Autowired
	UserServiceFeign userServiceFeign;
	
	
	public void saveNew(){
		SecondTestPO secondTestPO = new SecondTestPO();
		secondTestPO.setName("11111");
		repository.save(secondTestPO);
		
		userServiceFeign.getOneUser(1l);
		
	}
	@Cacheable(cacheNames="userList")
	public List<SecondTestPO> selectAll(){
		System.out.println("走数据库了，没有缓存");
		List<SecondTestPO> res = repository.findAll();
		return res;
	}
	@Cacheable(cacheNames="user",key="'name_'+#name")
	public SecondTestPO selectOne(String name){
		System.out.println("走数据库了，没有缓存");
		SecondTestPO res = repository.findByName(name);
		return res;
	}
}
