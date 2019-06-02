package com.grandmaster.chesspieces;

import java.util.ArrayList;

import com.grandmaster.game.GameLogic;

public class King extends Piece {

	public King(boolean isWhite, String id, int row, int column) {
		
		super(isWhite, id, row, column);
		
	}
	
	public King(boolean isWhite, String id, Position position) {
		
		super(isWhite, id, position.getRow(), position.getColumn());

	}
	
	@Override
	public boolean isLegalMove(int newRow, int newColumn) {
		
		return !GameLogic.isOutOfBounds(newRow, newColumn) && 
				(newRow == this.getRow() + 1 || newRow == this.getRow() - 1 ||
				newColumn == this.getColumn() + 1 || newColumn == this.getColumn() - 1);
		
	}
	
	public ArrayList<Position> getAvailableMoves() {
		
		ArrayList<Position> moves = new ArrayList<>();
		
		int row = this.getRow() - 1;
		int column = this.getColumn();
		
		if (this.isLegalMove(row, column))
			moves.add(new Position(row, column));
		column = this.getColumn() - 1;
		if (this.isLegalMove(row, column))
			moves.add(new Position(row, column));
		column = this.getColumn() + 1;
		if (this.isLegalMove(row, column))
			moves.add(new Position(row, column));
		
		row = this.getRow();
		column = this.getColumn() - 1;
		if (this.isLegalMove(row, column))
			moves.add(new Position(row, column));
		column = this.getColumn() + 1;
		if (this.isLegalMove(row, column))
			moves.add(new Position(row, column));
		
		row = this.getRow() + 1;
		column = this.getColumn();
		if (this.isLegalMove(row, column))
			moves.add(new Position(row, column));
		column = this.getColumn()- 1;
		if (this.isLegalMove(row, column))
			moves.add(new Position(row, column));
		column = this.getColumn() + 1;
		if (this.isLegalMove(row, column))
			moves.add(new Position(row, column));
		
		return moves;
		
	}
	
}
