package com.scg.grandmaster.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	private GlobalExceptionHandler() {
		// Don't create objects at this level
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public static class IllegalMoveException extends RuntimeException {
		public IllegalMoveException(String error) {
			super(error);
		}
	}
	
}
