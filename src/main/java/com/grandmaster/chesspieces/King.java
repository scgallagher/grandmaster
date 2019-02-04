package com.grandmaster.chesspieces;

import com.grandmaster.game.GameLogic;

public class King extends Piece {

	public King(boolean isWhite, String id, int row, int column) {
		
		super(isWhite, id, row, column);
		
	}
	
	@Override
	public boolean isLegalMove(int newRow, int newColumn) {
		
		return !GameLogic.isOutOfBounds(newRow, newColumn) && 
				(newRow == this.getRow() + 1 || newRow == this.getRow() - 1 ||
				newColumn == this.getColumn() + 1 || newColumn == this.getColumn() - 1);
		
	}
	
}
