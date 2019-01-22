package com.grandmaster.chesspieces;

import com.grandmaster.game.IllegalMoveException;
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
	
	@Override
	public void move(int newRow, int newColumn) throws IllegalMoveException {

		if (this.isLegalMove(newRow, newColumn)) {
			
			this.setRow(newRow);
			this.setColumn(newColumn);
			
		}
		else {
			throw new IllegalMoveException();
		}
		
	}
	
}
