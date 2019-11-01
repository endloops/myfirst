package com.wzz.demo.integration.service.common.header;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
/**
 * 
 * @author zhangshihao
 *
 */
public class ClientInformationResolver implements HandlerMethodArgumentResolver {
	
	/**
	 * 认证姓名头信息.
	 */
	private static final String HEADER_NAME = "X-Authentication-Name";
	
	private static final String VTMID = "Machine-Id";
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterAnnotation(ClientInfo.class) != null;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		String agentCode = webRequest.getHeader(HEADER_NAME);
		String vtmid = webRequest.getHeader(VTMID);
		ClientInformation clientInfo = new ClientInformation();
		clientInfo.setAgentCode(agentCode);
		clientInfo.setMachineid(vtmid);
		return clientInfo;
	}

}
