package com.grandmaster.chesspieces;

import lombok.Data;

@Data
public class Position {

	private final int row;
	private final int column;
	
	public char getRank() {
		
		return (char) ('8' - this.row);
		
	}
	
	public char getFile() {
		
		return (char) ('a' + this.getColumn());
		
	}
	
}
