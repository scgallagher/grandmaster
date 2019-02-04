package com.grandmaster.chesspieces;

import com.grandmaster.game.GameLogic;

public class Rook extends Piece {

	public Rook(boolean isWhite, String id, int row, int column) {
		
		super(isWhite, id, row, column);
		
	}
	
	@Override
	public boolean isLegalMove(int newRow, int newColumn) {

		return !GameLogic.isOutOfBounds(newRow, newColumn) && 
				(this.getRow() == newRow ^ this.getColumn() == newColumn);
		
	}

}
