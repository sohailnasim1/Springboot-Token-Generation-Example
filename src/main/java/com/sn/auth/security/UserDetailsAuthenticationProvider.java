/**
 * Retrieves the username and password fromfrom UsernamePasswordAuthenticationToken and
 * call the authenticate method of authentication service. UserDetails is returned on
 * successful authentication.
 * 
 * @author Sohail Nasim
 * 
 */
package com.sn.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.sn.auth.service.AuthenticationService;

@Component
public class UserDetailsAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	 @Autowired
	 private AuthenticationService authenticationService;
	
	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		return authenticationService.authenticate(username, authentication.getCredentials().toString());
	}
}
