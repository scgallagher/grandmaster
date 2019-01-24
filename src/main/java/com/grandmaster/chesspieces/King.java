package com.grandmaster.chesspieces;

import com.grandmaster.game.Board;
import com.grandmaster.game.Utilities;

public class King extends Piece {

	public King(boolean isWhite, String id, int row, int column) {
		
		super(isWhite, id, row, column);
		
	}
	
	@Override
	public boolean isLegalMove(int newRow, int newColumn) {
		
		return !Utilities.isOutOfBounds(newRow, newColumn) && 
				(newRow == this.getRow() + 1 || newRow == this.getRow() - 1 ||
				newColumn == this.getColumn() + 1 || newColumn == this.getColumn() - 1);
		
	}
	
	public boolean pawnThreat(Board board) {
		
		int rowDifference = 1;
		if (!this.isWhite())
			rowDifference = -1;
		
		Piece piece = board.getPieceAt(this.getRow() - rowDifference, this.getColumn() - 1);
		if (piece != null && piece instanceof Pawn && !this.equals(piece)) {
			return true;
		}
		
		piece = board.getPieceAt(this.getRow() - rowDifference, this.getColumn() + 1);
		if (piece != null && piece instanceof Pawn && !this.equals(piece)) {
			return true;
		}
		
		return false;
		
	}
	
	public boolean isCheck(Board board) {
		
		return pawnThreat(board);
		
	}
	
}
