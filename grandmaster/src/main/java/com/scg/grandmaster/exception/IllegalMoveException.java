package com.scg.grandmaster.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IllegalMoveException extends RuntimeException {

	private static final long serialVersionUID = -1666309168966696253L;
	
	public IllegalMoveException(String message) {
		super(message);
	}
	
}