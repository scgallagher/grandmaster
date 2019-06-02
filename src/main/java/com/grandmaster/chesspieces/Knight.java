package com.grandmaster.chesspieces;

import com.grandmaster.game.GameLogic;

public class Knight extends Piece {

	public Knight(boolean isWhite, String id, int row, int column) {
		
		super(isWhite, id, row, column);

	}
	
	public Knight(boolean isWhite, String id, Position position) {
		
		super(isWhite, id, position.getRow(), position.getColumn());

	}

	@Override
	public boolean isLegalMove(int newRow, int newColumn) {
		
		return !GameLogic.isOutOfBounds(newRow, newColumn) &&
				(
						((newRow == this.getRow() - 2 || newRow == this.getRow() + 2) &&
						(newColumn == this.getColumn() - 1 || newColumn == this.getColumn() + 1)) ||
						((newRow == this.getRow() - 1 || newRow == this.getRow() + 1) &&
								(newColumn == this.getColumn() - 2 || newColumn == this.getColumn() + 2))
				);
		
	}

}
