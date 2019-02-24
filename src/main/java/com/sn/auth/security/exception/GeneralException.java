package com.sn.auth.security.exception;

import org.springframework.security.core.AuthenticationException;

public class GeneralException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public GeneralException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public GeneralException(String msg, Throwable t) {
		super(msg, t);
		// TODO Auto-generated constructor stub
	}

}
