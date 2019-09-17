package com.wzz.demo.integration.service.userServicefeignfallback;

import org.springframework.stereotype.Component;

import com.wzz.demo.integration.service.service.feign.UserInformationRibbonModel;
import com.wzz.demo.integration.service.service.feign.UserServiceFeign;

import feign.hystrix.FallbackFactory;

@Component
public class UserServiceFeignFallback implements FallbackFactory<UserServiceFeign>{

	@Override
	public UserServiceFeign create(Throwable arg0) {
		
		
		return new UserServiceFeign(){

			@Override
			public com.wzz.demo.integration.service.service.request.UserInformationRibbonModel getOneUser(Long id) {
				
				return new com.wzz.demo.integration.service.service.request.UserInformationRibbonModel("11111", arg0.getMessage(), arg0.getClass().getSimpleName());
			}
			
		};
	}

}
