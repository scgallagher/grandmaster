package com.grandmaster.game;

import java.util.ArrayList;

import com.grandmaster.chesspieces.Bishop;
import com.grandmaster.chesspieces.King;
import com.grandmaster.chesspieces.Knight;
import com.grandmaster.chesspieces.Piece;
import com.grandmaster.chesspieces.Queen;
import com.grandmaster.chesspieces.Rook;

public class Board {

	private final int numRows = 8;
	private final int numColumns = 8;
	
	private Piece[][] grid;
	
	public Board() {
		
		grid = new Piece[numRows][numColumns];
		
	}
	
	public int getNumRows() {
		
		return this.numRows;
		
	}
	
	public int getNumColumns() {
		
		return this.numColumns;
		
	}
	
	public void initialize(Player white, Player black) {
		
		boolean isWhite = true;
		
		// Initialize white pieces
		Piece piece = new Rook(isWhite, "R_w", 7, 0);
		grid[7][0] = piece;
		white.addPiece(piece);
		
		piece = new Knight(isWhite, "Q_w", 7, 1);
		grid[7][1] = piece;
		white.addPiece(piece);
		
		piece = new Bishop(isWhite, "Q_w", 7, 2);
		grid[7][2] = piece;
		white.addPiece(piece);
		
		piece = new Queen(isWhite, "Q_w", 7, 3);
		grid[7][3] = piece;
		white.addPiece(piece);
		
		piece = new King(isWhite, "K_w", 7, 4);
		grid[7][4] = piece;
		white.addPiece(piece);
						
		// Initialize black pieces
		piece = new King(!isWhite, "K_b", 0, 4);
		grid[0][4] = piece;
		black.addPiece(piece);
		
	}
	
	public void initialize(Player white, Player black, ArrayList<Piece> pieces) {
		
		for (Piece piece : pieces) {
			
			int row = piece.getRow();
			int column = piece.getColumn();
			boolean isWhite = piece.isWhite();
			
			grid[row][column] = piece;
			if (isWhite) {
				white.addPiece(piece);
			}
			else {
				black.addPiece(piece);
			}
			
		}
		
	}
	
	public void initializeAlternate(Player white, Player black) {
		
		boolean isWhite = true;
		
		// Initialize white pieces
		Piece piece = new King(isWhite, "K_w", 7, 4);
		grid[7][4] = piece;
		white.addPiece(piece);
				
		// Initialize black pieces
		piece = new King(!isWhite, "K_b", 6, 4);
		grid[6][4] = piece;
		black.addPiece(piece);
		
	}
	
	public void move(Player player, int row, int column, int newRow, int newColumn) 
			throws IllegalMoveException, UnauthorizedMoveException {
		
		Piece piece = grid[row][column];
		
		if (piece != null) {
			
			if (!player.isAuthorized(piece)) {
				throw new UnauthorizedMoveException("Player is not authorized to move this piece");
			}
			
			Piece occupant = grid[newRow][newColumn];
			if (occupant == null) {
				
				// Space is not occupied, safe to move here
				piece.move(newRow, newColumn);
				grid[newRow][newColumn] = piece;
				grid[row][column] = null;
				
			}
			else if (piece.isAlly(occupant)) {
				
				// Space is occupied by ally, cannot move here
				throw new IllegalMoveException("Space already occupied by ally");
				
			}
			else {
				
				// Space is occupied by enemy, capture enemy and move here
				piece.move(newRow, newColumn);
				player.capturePiece(occupant);
				grid[newRow][newColumn] = piece;
				grid[row][column] = null;
				
			}
			
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
	
	public Piece getPieceAt(int row, int column) {
		
		return this.grid[row][column];
		
	}
	
}
