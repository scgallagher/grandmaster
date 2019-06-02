package com.grandmaster.chesspieces;

import com.grandmaster.game.GameLogic;

public class Queen extends Piece {

	public Queen(boolean isWhite, String id, int row, int column) {
		
		super(isWhite, id, row, column);
		
	}
	
	public Queen(boolean isWhite, String id, Position position) {
		
		super(isWhite, id, position.getRow(), position.getColumn());

	}
	
	@Override
	public boolean isLegalMove(int newRow, int newColumn) {
		
		float slope = 1.0f;
		if (newRow - this.getRow() != 0) {
			slope = (newColumn - this.getColumn()) / (newRow - this.getRow());
		}
		
		return !GameLogic.isOutOfBounds(newRow, newColumn) &&
				// Diagonal move
				(Math.abs(slope) == 1.0 || 
				// Straight move
				(newRow == this.getRow() || newColumn == this.getColumn()));

		
	}

}
