package com.wzz.demo.integration.service.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wzz.demo.integration.service.service.interfaces.UserInformationService;
import com.wzz.demo.integration.service.service.request.UserInformationRibbonModel;
/**
 * 用户信息操作类
 * @author wang
 *
 */
@Service
public class UserInformationServiceImpl implements UserInformationService{
	
	/**
	 * 注入 RestTemplate 请求 Eureka 上注册的service 服务
	 */
	@Autowired
	RestTemplate restTemplate;

	/**
	 * 查询用户信息详情的接口。
	 */
	@Override
	@HystrixCommand(fallbackMethod="searchUserByIDRollback")
	public UserInformationRibbonModel searchUserByID(Long id) {
		Map<String, Long> params = new HashMap<>();
		params.put("id", id);
		ResponseEntity<UserInformationRibbonModel> userInformation = restTemplate.getForEntity("http://USERINFORMATSERVICE/searchUser/{id}", UserInformationRibbonModel.class, params);
		
		return userInformation.getBody();
	}
	/**
	 * 查询用户信息详情的接口(异常响应)。
	 * @param id
	 * 		id: 用户Id
	 * @param throwable
	 * 		throwable: 异常描述
	 * @return
	 * 		UserInformationRibbonModel: 返回一个异常情况下服务返回的对象
	 */
	public UserInformationRibbonModel searchUserByIDRollback(Long  id,Throwable throwable){
		HttpServerErrorException exception = null;
		if (throwable instanceof HttpServerErrorException){
			exception = (HttpServerErrorException) throwable;
		}
		System.out.println(exception.getResponseBodyAsString());
		return new UserInformationRibbonModel("userInformatServiceError 411");
	}
	
	
}
