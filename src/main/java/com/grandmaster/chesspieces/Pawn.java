package com.grandmaster.chesspieces;

import com.grandmaster.game.Board;
import com.grandmaster.game.GameLogic;
import com.grandmaster.game.IllegalMoveException;

public class Pawn extends Piece {

	private boolean firstMove;
	private Board board;
	
	public Pawn(boolean isWhite, String id, int row, int column, Board board) {
		
		super(isWhite, id, row, column);
		this.firstMove = true;
		this.board = board;
		
	}
	
	public Pawn(boolean isWhite, String id, Position position, Board board) {
		
		super(isWhite, id, position.getRow(), position.getColumn());
		this.firstMove = true;
		this.board = board;
		
	}
	
	public boolean isFirstMove() {
		
		return this.firstMove;
		
	}
	
	@Override
	public boolean isLegalMove(int newRow, int newColumn) {
		
		int rowDifference = 1;
		if (!this.isWhite())
			rowDifference = -1;
		
		if (GameLogic.isOutOfBounds(newRow, newColumn))
			return false;
		
		if (newColumn == this.getColumn()) {
			
			if (firstMove) {
				
				return newRow == this.getRow() + 1 || newRow == this.getRow() - 1 ||
						newRow == this.getRow() + 2 || newRow == this.getRow() - 2;
				
			}
			else {
				
				return newRow == this.getRow() + 1 || newRow == this.getRow() - 1;
				
			}
			
		}
		else if (newRow == this.getRow() - rowDifference && (newColumn == this.getColumn() - 1 || newColumn == this.getColumn() + 1)) {
			
			Piece occupant = this.board.getPieceAt(newRow, newColumn);
			return occupant != null && !this.isAlly(occupant);
			
		}
		else {
			
			return false;
			
		}
		
	}
	
	@Override
	public void move(int newRow, int newColumn) throws IllegalMoveException {

		super.move(newRow, newColumn);
		if (this.firstMove) {
			this.firstMove = false;
		}
		
	}

}
