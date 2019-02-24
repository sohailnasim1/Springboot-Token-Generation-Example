package com.sn.auth.security.util;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	private final String message;
	
	private final ErrorCodes error;
	
	private final HttpStatus httpStatus;
	
	private final Date timestamp;
	
	protected ErrorResponse(final String message, final ErrorCodes error, HttpStatus httpStatus) {
        this.message = message;
        this.error = error;
        this.httpStatus = httpStatus;
        this.timestamp = new java.util.Date();
    }
	
	public static ErrorResponse getErrorResponse(final String message, final ErrorCodes error, HttpStatus httpStatus) {
		return new ErrorResponse(message, error, httpStatus);
	}

	public String getMessage() {
		return message;
	}

	public ErrorCodes getError() {
		return error;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public Date getTimestamp() {
		return timestamp;
	}

}
