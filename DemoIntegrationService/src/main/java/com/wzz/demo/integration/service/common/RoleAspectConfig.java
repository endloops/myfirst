package com.wzz.demo.integration.service.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.thoughtworks.xstream.security.ForbiddenClassException;

@Aspect
@Component
public class RoleAspectConfig {

	private boolean status = true;
	
	@Pointcut(value = "@annotation(roles)", argNames = "roles")
	public void annotationTest(ROLES roles) {
	}

	@Before("annotationTest(roles)")
	public void before(ROLES roles) {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
		HttpServletResponse response = sra.getResponse();
		String authoritesRoles = request.getHeader("AuthoritesRoles");
		String[] jiaoyanRoles = roles.value();
		status = vilateRoles(authoritesRoles, jiaoyanRoles);
		if(!status){
			throw new ForbiddenClassException(getClass());
		}
	}

	private boolean vilateRoles(String authoritesRoles, String[] jiaoyanRoles) {
		for (String string : jiaoyanRoles) {
			if (!authoritesRoles.toUpperCase().contains(string.toUpperCase())) {
				return false;
			}
		}

		return true;
	}
}
