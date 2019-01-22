package com.grandmaster.game;

import com.grandmaster.chesspieces.King;
import com.grandmaster.chesspieces.Piece;

public class Board {

	private final int numRows = 8;
	private final int numColumns = 8;
	
	private Piece[][] grid;
	
	public Board() {
		
		grid = new Piece[numRows][numColumns];
		this.initialize();
		
	}
	
	public void initialize() {
		
		grid[7][3] = new King("K_w", 7, 3);
		grid[0][4] = new King("K_b", 0, 4);
		
	}
	
	public void move(int row, int column, int newRow, int newColumn) throws IllegalMoveException {
		
		Piece piece = grid[row][column];
		
		if (piece != null) {
			
			piece.move(newRow, newColumn);
			grid[newRow][newColumn] = piece;
			grid[row][column] = null;
			
		}
		
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < numRows; i++) {
			sb.append("|");
			for (int j = 0; j < numColumns; j++) {
				
				if (grid[i][j] == null) {
					
					sb.append(Utilities.rightPad("X"));
					
				}
				else {
					sb.append(grid[i][j]);
				}
				sb.append("|");
				
			}
			
			sb.append("\n");
			
		}
		
		return sb.toString();
		
	}
	
}
