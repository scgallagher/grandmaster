package com.scg.grandmaster.game.logic;

import com.scg.grandmaster.game.entity.Piece;

public class CommonLogic {

	public static Boolean areOpponents(Piece pieceOne, Piece pieceTwo) {
		return pieceOne.getColor() != pieceTwo.getColor();
	}
	
}
