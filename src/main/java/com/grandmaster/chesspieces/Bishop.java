package com.grandmaster.chesspieces;

import com.grandmaster.game.Utilities;

public class Bishop extends Piece {

	public Bishop(boolean isWhite, String id, int row, int column) {
		
		super(isWhite, id, row, column);

	}

	@Override
	public boolean isLegalMove(int newRow, int newColumn) {

		float slope = 0.0f;
		if (newRow - this.getRow() != 0) {
			slope = (newColumn - this.getColumn()) / (newRow - this.getRow());
		}
		
		return !Utilities.isOutOfBounds(newRow, newColumn) && Math.abs(slope) == 1.0;
		
	}

}
