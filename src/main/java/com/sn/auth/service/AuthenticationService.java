package com.sn.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sn.auth.domain.User;
import com.sn.auth.repository.UserRepository;
import com.sn.auth.security.exception.ForbiddenException;

@Service
public class AuthenticationService {
	private static String USER_NOT_FOUND = "User not found";
	private static String INVALID_PASSWORD = "Invalid password";
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	public User authenticate(String username, String password) {
		Optional<User> user = userRepository.findById(username);
		if (user.isPresent()) {
			if (user.get().getPassword() == null || !passwordEncoder.matches(password, user.get().getPassword())) {
				throw new ForbiddenException(INVALID_PASSWORD);
			}
			return user.get();
		} else {
			throw new ForbiddenException(USER_NOT_FOUND);
		}
		
	}

}
