package com.sn.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sn.auth.security.Token;
import com.sn.auth.security.exception.ForbiddenException;
import com.sn.auth.security.util.AuthenticationHelper;


@RequestMapping(path = "/token", produces = "application/json")
@CrossOrigin(origins = "*")
@RestController
public class TokenController {
	
	@Autowired
	private AuthenticationHelper authHelper;
	
	@PostMapping(path="/create")
    public Token createToken() throws AuthenticationException {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof String && "anonymousUser".equals(principal)) {
			throw new ForbiddenException("UnAuthorized");
		} else {
		UserDetails userDetails = (UserDetails)principal;
		
		System.out.println(userDetails);
      
		return authHelper.generateToken(userDetails);
		}
    }

}
