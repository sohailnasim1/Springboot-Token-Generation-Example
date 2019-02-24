package com.sn.auth.security.util;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCodes {
	GENERAl(1), UNAUTHORIZED(2);
	
	private int errorCode;
	
	private ErrorCodes(int errorCode) {
		this.errorCode = errorCode;
	}
	
	@JsonValue
	public int getErrorCode() {
		return errorCode;
	}

}
