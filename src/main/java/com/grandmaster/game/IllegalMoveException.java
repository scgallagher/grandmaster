package com.grandmaster.game;

public class IllegalMoveException extends Exception {

	private static final long serialVersionUID = -1666309168966696253L;

	public IllegalMoveException() {
		
	}
	
	public IllegalMoveException(String message) {
		
		super(message);
		
	}
	
}
