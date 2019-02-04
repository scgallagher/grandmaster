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
	
	public boolean isThreat(int row, int column, Board board, Piece comparator) {
		
		if (row < 0 || row > 7 || column < 0 || column > 7) {
			return false;
		}
		
		Piece piece = board.getPieceAt(row, column);
		if (piece != null && piece.getClass().isInstance(comparator) && !this.isAlly(piece)) {
			return true;
		}
		
		return false;
		
	}
	
	public boolean pawnThreat(Board board) {
		
		int rowDifference = 1;
		if (!this.isWhite())
			rowDifference = -1;
		
		Pawn comparator = new Pawn(true, "", 0, 0, null);
		return this.isThreat(this.getRow() - rowDifference, this.getColumn() - 1, board, comparator) ||
				this.isThreat(this.getRow() - rowDifference, this.getColumn() + 1, board, comparator);
		
	}
	
	public boolean rookThreat(Board board) {
		
		for (int i = 0; i < board.getNumRows(); i++) {
			
			Rook comparator = new Rook(true, "", 0, 0);
			
			if (this.isThreat(this.getRow(), i, board, comparator) ||
					this.isThreat(i, this.getColumn(), board, comparator)) {
				return true;
			}
			
		}
		
		return false;
		
	}
	
	public boolean bishopThreat(Board board) {
		
		Bishop bishop = new Bishop(true, "", 0, 0);
		
		for (int i = 1; i < board.getNumRows(); i++) {
			
			if (this.isThreat(this.getRow() - i, this.getColumn() - i, board, bishop) ||
					this.isThreat(this.getRow() - i, this.getColumn() + i, board, bishop) ||
					this.isThreat(this.getRow() + i, this.getColumn() + i, board, bishop) ||
					this.isThreat(this.getRow() + i, this.getColumn() - i, board, bishop)) {
				return true;
			}
			
		}
		
		return false;
		
	}
	
	public boolean knightThreat(Board board) {
		
		Knight knight = new Knight(true, "", 0, 0);
		
		return this.isThreat(this.getRow() - 2, this.getColumn() - 1, board, knight) ||
				this.isThreat(this.getRow() - 2, this.getColumn() + 1, board, knight) ||
				this.isThreat(this.getRow() + 2, this.getColumn() - 1, board, knight) ||
				this.isThreat(this.getRow() + 2, this.getColumn() + 1, board, knight) ||
				this.isThreat(this.getRow() - 1, this.getColumn() - 2, board, knight) ||
				this.isThreat(this.getRow() - 1, this.getColumn() + 2, board, knight) ||
				this.isThreat(this.getRow() + 1, this.getColumn() - 2, board, knight) ||
				this.isThreat(this.getRow() + 1, this.getColumn() + 2, board, knight);
		
	}
	
	public boolean isCheck(Board board) {
		
		return pawnThreat(board) || rookThreat(board) || bishopThreat(board) || knightThreat(board);
		
	}
	
}
