package com.wzz.demo.oauth2.config;

import org.springframework.security.oauth2.common.exceptions.InvalidRequestException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.endpoint.DefaultRedirectResolver;
import org.springframework.security.oauth2.provider.endpoint.RedirectResolver;
import org.springframework.stereotype.Component;
@Component
public class MyClientDetailService implements RedirectResolver{
	
	private final RedirectResolver delegate = new DefaultRedirectResolver();
	
	@Override
	public String resolveRedirect(String requestedRedirect, ClientDetails client) throws OAuth2Exception {
		try {
            return this.delegate.resolveRedirect(requestedRedirect, client);
        } catch ( InvalidRequestException ire ) {
            // do custom resolution
        }
		return requestedRedirect;
	}


}
