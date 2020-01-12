package com.scg.grandmaster.game.logic;

import com.scg.grandmaster.game.entity.Piece;

public class CommonLogic {

	public static Boolean isAlly(Piece pieceOne, Piece pieceTwo) {
		return pieceOne.getColor() == pieceTwo.getColor();
	}
	
	public static Boolean isOpponent(Piece pieceOne, Piece pieceTwo) {
		return !isAlly(pieceOne, pieceTwo);
	}
	
}
