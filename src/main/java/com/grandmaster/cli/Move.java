package com.grandmaster.cli;

import com.grandmaster.chesspieces.Piece;
import com.grandmaster.chesspieces.Position;

public class Move {

	private int row;
	private int column;
	private Piece piece;
	
	public Move(int row, int column, Piece piece) {
		
		this.row = row;
		this.column = column;
		this.piece = piece;
		
	}
	
	public Position getCoordinate() {
		
		return new Position(row, column);
		
	}
	
	public Piece getPiece() {
		
		return this.piece;
		
	}
	
}
