package com.grandmaster.game;

public class UnauthorizedMoveException extends Exception {

	private static final long serialVersionUID = 6052429704124416026L;
	
	public UnauthorizedMoveException(String message) {
		
		super(message);
		
	}

}
