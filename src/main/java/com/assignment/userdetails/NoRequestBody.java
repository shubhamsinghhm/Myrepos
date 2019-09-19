package com.assignment.userdetails.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoRequestBody extends RuntimeException {

	public NoRequestBody(String message) {
		super(message);
		
	}

}
