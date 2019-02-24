package com.sn.auth.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class BypassPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		 return rawPassword.toString().equals(encodedPassword);
	}

}
