package com.grandmaster.chesspieces;

import com.grandmaster.game.Utilities;

public class Knight extends Piece {

	public Knight(boolean isWhite, String id, int row, int column) {
		
		super(isWhite, id, row, column);

	}

	@Override
	public boolean isLegalMove(int newRow, int newColumn) {
		
		return !Utilities.isOutOfBounds(newRow, newColumn) &&
				(
						((newRow == this.getRow() - 2 || newRow == this.getRow() + 2) &&
						(newColumn == this.getColumn() - 1 || newColumn == this.getColumn() + 1)) ||
						((newRow == this.getRow() - 1 || newRow == this.getRow() + 1) &&
								(newColumn == this.getColumn() - 2 || newColumn == this.getColumn() + 2))
				);
		
	}

}
