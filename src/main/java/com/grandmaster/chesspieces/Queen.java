package com.grandmaster.chesspieces;

import com.grandmaster.game.Utilities;

public class Queen extends Piece {

	public Queen(String id, int row, int column) {
		
		this.setId(id);
		this.setRow(row);
		this.setColumn(column);
		
	}
	
	@Override
	public boolean isLegalMove(int newRow, int newColumn) {
		
		float slope = 1.0f;
		if (newRow - this.getRow() != 0) {
			slope = (newColumn - this.getColumn()) / (newRow - this.getRow());
		}
		
		return !Utilities.isOutOfBounds(newRow, newColumn) &&
				// Diagonal move
				(Math.abs(slope) == 1.0 || 
				// Straight move
				(newRow == this.getRow() || newColumn == this.getColumn()));

		
	}

}
