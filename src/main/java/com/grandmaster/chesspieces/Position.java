package com.grandmaster.chesspieces;

public class Position {

	private final int row;
	private final int column;
	
	public Position(int row, int column) {
		
		this.row = row;
		this.column = column;
		
	}
	
	public int getRow() {
		
		return this.row;
		
	}
	
	public int getColumn() {
		
		return this.column;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj == this) {
			return true;
		}
		
		if (!(obj instanceof Position)) {
			return false;
		}
		
		Position pos = (Position) obj;
		
		return pos.getRow() == this.getRow() && pos.getColumn() == this.getColumn();
		
	}
	
}
