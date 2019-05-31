package com.wzz.demo.integration.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	/**
	 * 注入用户查询service
	 */
	@Autowired
	UserInformationService userInformationService;
	
	/**
	 * 利用用户的Id 实现 精确查询用户在数据库中的其他信息
	 * @param id
	 * 		id : 用户信息ID
	 * @return
	 * 		UserInformationRibbonModel: 用户详细信息展示
	 */
	@GetMapping("/information/{id}")
	public UserInformationRibbonModel searchUserByID(@PathVariable("id") Long id) {
		UserInformationRibbonModel res = userInformationService.searchUserByID(id);
		return res;
	}
	
	
}
