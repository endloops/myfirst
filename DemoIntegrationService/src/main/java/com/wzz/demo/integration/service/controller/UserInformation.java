package com.wzz.demo.integration.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wzz.demo.integration.service.repository.bean.UserRedisDao;
import com.wzz.demo.integration.service.service.feign.UserServiceFeign;
import com.wzz.demo.integration.service.service.interfaces.UserInformationService;
import com.wzz.demo.integration.service.service.request.UserInformationRibbonModel;
/**
 * 查询用户信息服务
 * @author wang
 *
 */
@RestController
@RequestMapping("/user")
public class UserInformation {

	Logger logger = LoggerFactory.getLogger(getClass());	
	/**
	 * 注入用户查询service
	 */
	@Autowired
	UserInformationService userInformationService;
	
	
	@Autowired
	UserServiceFeign serviceFeign;
	
	/**
	 * 利用用户的Id 实现 精确查询用户在数据库中的其他信息
	 * @param id
	 * 		id : 用户信息ID
	 * @return
	 * 		UserInformationRibbonModel: 用户详细信息展示
	 * @throws JsonProcessingException 
	 */
	@GetMapping("/information/{id}")
	public UserInformationRibbonModel searchUserByID(@PathVariable("id") Long id) throws JsonProcessingException {
		UserInformationRibbonModel model = new UserInformationRibbonModel("1111", "1111", "1111", "1111");
		model = userInformationService.searchUserByID(id);
//		UserInformationRibbonModel feignRes = serviceFeign.getOneUser(id);
		UserRedisDao userRes = userInformationService.getOneInformation("wang", UserRedisDao.class);
		ObjectMapper mapper = new ObjectMapper();
		logger.info(mapper.writeValueAsString(model));
		return model;
	}
	
	
}
