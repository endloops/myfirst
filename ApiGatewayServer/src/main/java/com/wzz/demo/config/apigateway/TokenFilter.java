package com.wzz.demo.config.apigateway;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import reactor.core.publisher.Mono;

//@Component
public class TokenFilter implements GlobalFilter,Ordered{

	
	private AntPathMatcher pathMatcher = new AntPathMatcher();
	
	public int getOrder() {
		// TODO Auto-generated method stub
		return -100;
	}
	
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = extractToken(exchange.getRequest());
        if(pathMatcher.match("/login",exchange.getRequest().getPath().value())){
        	return chain.filter(exchange);
        }else{
        	if (token == null) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }else{
                try {
                	Jws<Claims> claimsJws = Jwts.parser().setSigningKey("secret").parseClaimsJws(token);
                } catch (Exception e) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }
                return chain.filter(exchange);
            }
        }
        
    }
    
    protected String extractToken(ServerHttpRequest request) {
        List<String> strings = request.getHeaders().get("Authorization");
        String authToken = null;
        if (strings != null) {
            authToken = strings.get(0).substring("Bearer".length()).trim();
        }

        if (StringUtils.isBlank(authToken)) {
            strings = request.getQueryParams().get("access_token");
            if (strings != null) {
                authToken = strings.get(0);
            }
        }

        return authToken;
    }
}
