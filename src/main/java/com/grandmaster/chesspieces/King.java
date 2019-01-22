package com.grandmaster.chesspieces;

import com.grandmaster.game.Utilities;

public class King extends Piece {

	public King(String id, int row, int column) {
		
		this.setId(id);
		this.setRow(row);
		this.setColumn(column);
		
	}
	
	@Override
	public boolean isLegalMove(int newRow, int newColumn) {
		
		return !Utilities.isOutOfBounds(newRow, newColumn) && 
				(newRow == this.getRow() + 1 || newRow == this.getRow() - 1 ||
				newColumn == this.getColumn() + 1 || newColumn == this.getColumn() - 1);
		
	}
	
}
