package com.wzz.demo.integration.service.common;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wzz.demo.integration.service.common.header.ClientInformationResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addArgumentResolvers(resolvers);
		resolvers.add(new ClientInformationResolver());
	}
}
