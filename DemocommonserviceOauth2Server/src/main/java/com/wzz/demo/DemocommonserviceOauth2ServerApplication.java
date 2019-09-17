package com.wzz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
//@EnableDiscoveryClient
public class DemocommonserviceOauth2ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocommonserviceOauth2ServerApplication.class, args);
	}

	@Bean
	public ObjectMapper objectMapper(){
		return new ObjectMapper();
	}
	/**
	 * spring security 5.0  需要写一个 注入 密码解析器 不然 会 报错
	 * 1:
	 * There is no PasswordEncoder mapped for the id "null"
	 * 但是 注意的是 如果 你的配置 密码，没有跟上类型的 他还是会报错：
	 * 所以配置的密码最好由 password 变为  {noop}password 这时候页面输入password 就可以了，
	 * 千万不要输入{noop}password 因为这里的解析器，不会对我们页面的参数转化
	 * DaoAuthenticationProvider：
	 * 		
	 * 	//这里是我们页面输入的密码	
		String presentedPassword = authentication.getCredentials().toString();
		// 这里 userDetails.getPassword()是配置的代码，最后会被 解密。
		if (!passwordEncoder.matches(presentedPassword, userDetails.getPassword())) {
	 * 
	 * 2:
	 * 自定义 PasswordEncoder 的实现 如 PasswordEncoderImpl 然后注入进去 这样也行
	 * 但这样 配置就必须和 页面输入一模一样 比如 配置 {noop}password 页面 也必须是 {noop}password
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder(){
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
}
