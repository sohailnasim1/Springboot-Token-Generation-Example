/**
 * This class retrieves the username, password from request and pass those on to.
 * the authenticate method of Authentication Manager for authentication.
 * @author Sohail Nasim
 */
package com.sn.auth.security;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.fasterxml.jackson.databind.ObjectMapper;


public class UsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter { // OncePerRequestFilter {

	private final ObjectMapper objectMapper = new ObjectMapper();
	private AuthenticationFailureHandler failureHandler;
	
	public UsernamePasswordAuthenticationFilter(String API_URL, AuthenticationFailureHandler failureHandler) {
		super(API_URL);
		this.failureHandler = failureHandler;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		try (BufferedReader reader = request.getReader()) {
			String requestBody = reader.lines().collect(Collectors.joining());
			LoginCredentials loginCredentials = objectMapper.readValue(requestBody, LoginCredentials.class);
			return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(loginCredentials.getUsername(), loginCredentials.getPassword()));
		}

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		SecurityContext context = SecurityContextHolder.createEmptyContext();
		context.setAuthentication(authResult);
		SecurityContextHolder.setContext(context);
		chain.doFilter(request, response);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		SecurityContextHolder.clearContext();
		failureHandler.onAuthenticationFailure(request, response, failed);
	}

}
