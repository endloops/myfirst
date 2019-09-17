package com.wzz.demo.integration.service.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wzz.demo.integration.service.userServicefeignfallback.FeignErrorMessage;
import com.wzz.demo.integration.service.userServicefeignfallback.UserServiceFeignFallback;

@FeignClient(name="USERINFORMATSERVICE",fallbackFactory=UserServiceFeignFallback.class,configuration=FeignErrorMessage.class)
public interface UserServiceFeign {

	@GetMapping("/searchUser/{id}")
	public com.wzz.demo.integration.service.service.request.UserInformationRibbonModel getOneUser(@PathVariable("id") Long id);
	
}
