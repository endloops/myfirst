package com.wzz.demo.oauth2.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class Oauth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	MyClientDetailService redirectResolver;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenStore jwtTokenStore;

	@Autowired
	private JwtAccessTokenConverter accessTokenConverter;

//	@Autowired
//	private ClientDetailsService clientDetailsService;

	/**
	 * 存储的地方
	 * @return
	 */
	@Bean
	public JwtTokenStore jwtTokenStore() {
		JwtTokenStore store = new JwtTokenStore(accessTokenConverter());
		return store;
	}
	/**
	 * 将默认生成的token 转化为JWT
	 * @return
	 */
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey("secret");
		return accessTokenConverter;
	}
	/**
	 * token 处理 包含 使用的 
	 *    1： token 存储的商店    存储  
	 *    2： token 增强器            转化
	 *    3： token 时效性            过期
	 * @return
	 */
	@Bean
	@Primary
	public DefaultTokenServices idotokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(jwtTokenStore());
		defaultTokenServices.setTokenEnhancer(tokenEnhancerChain());
		defaultTokenServices.setSupportRefreshToken(true);
		defaultTokenServices.setAccessTokenValiditySeconds(60 * 60 * 9);
		return defaultTokenServices;

	}
	@Bean
	public TokenEnhancerChain tokenEnhancerChain() {
		List<TokenEnhancer> list = new ArrayList<>();
		list.add(accessTokenConverter());
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(list);
		return tokenEnhancerChain;

	}

//	@Bean
//	public ClientDetailsService clientDetailsService() throws Exception {
//		InMemoryClientDetailsServiceBuilder builder = new InMemoryClientDetailsServiceBuilder();
//		builder.withClient("api-gateway").resourceIds("OAUTH2_RESOURCE_ID", "API_GATEWAY_RESOURCE").autoApprove(true)
//				.authorities("ROLE_CLIENT").authorizedGrantTypes("authorization_code", "refresh_token", "password")
//				.scopes("read", "write", "user").secret("{noop}password");
//		return builder.build();
//	}

	/**
	 * 用来配置令牌端点
	 * 1: 什麽情况下 请求能进来
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.allowFormAuthenticationForClients().checkTokenAccess("isAuthenticated()");
	}

	/**
	 * 配置客户端详情
	 * 验证客户端是否正常
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("api-gateway").resourceIds("OAUTH2_RESOURCE_ID", "API_GATEWAY_RESOURCE").autoApprove(true)
		.authorities("ROLE_CLIENT").authorizedGrantTypes("authorization_code", "refresh_token", "password")
		.scopes("read", "write", "user").secret("{noop}password")
//		.redirectUris("http://localhost:1026/apis/login","http://localhost:1026/apis/apis/users");
	
		;
	}

	/**
	 * 用来配置授权以及令牌（Token）的访问端点和令牌服务
	 * 1 ： tokenServices   设置 生成token 的属性
	 * 2 ：authenticationManager(来自于Oauth2Securityd.class
	 * 	@Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
		
			return super.authenticationManagerBean();
		}
	 * 
	 * 3: 注意××××××××××××××××××××××××××××××××××××
	 * ××××××××××××××××××××××××××××××××××××××××××××××××××××××××××
	 * ××××××××××××××××××××××××××××××
	 * 	boot2.0    
	 * 	重写     redirectResolver  否则 就 
	 * 	报错At least one redirect_uri must be registered with the client	
	 * )   验证用户是否正确
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
				 .tokenServices(idotokenServices()).redirectResolver(redirectResolver);
	}
	
//	@Configuration
//	@EnableResourceServer
//	protected class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//
//		@Override
//		public void configure(ResourceServerSecurityConfigurer resources) {
//
//			resources.resourceId("OAUTH2_RESOURCE_ID").tokenServices(idotokenServices()).tokenStore(jwtTokenStore).stateless(true);
//
//		}
//		@Override
//		public void configure(HttpSecurity http) throws Exception {
//			http.requestMatchers()
//			.antMatchers("/userInfo").and().authorizeRequests()
//			.antMatchers("/userInfo").access("hasRole('USER')").and().csrf().disable()
//					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
//		}
//	}

}
