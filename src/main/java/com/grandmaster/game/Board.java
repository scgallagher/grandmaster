package com.grandmaster.game;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.grandmaster.chesspieces.Bishop;
import com.grandmaster.chesspieces.King;
import com.grandmaster.chesspieces.Knight;
import com.grandmaster.chesspieces.Pawn;
import com.grandmaster.chesspieces.Piece;
import com.grandmaster.chesspieces.Position;
import com.grandmaster.chesspieces.Queen;
import com.grandmaster.chesspieces.Rook;
import com.grandmaster.cli.Cli;

public class Board {

	private static Logger log = LogManager.getLogger(Board.class);
	
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
	
	public void addPawn(Player player, boolean isWhite, int row, int column) {
		
		String id = "p_";
		if (isWhite)
			id += "w";
		else
			id += "b";
		
		Pawn pawn = new Pawn(isWhite, id, row, column, this);
		grid[row][column] = pawn;
		player.addPiece(pawn);
		
	}
	
	public void initializePawns(Player white, Player black) {
		
		for (int i = 0; i < 8; i++) {
			
			addPawn(white, true, 6, i);
			addPawn(black, false, 1, i);
			
		}
		
	}
	
	public void initialize(Player white, Player black) {
		
		boolean isWhite = true;
		
		initializePawns(white, black);
		
		// Initialize white pieces
		Piece piece = new Rook(isWhite, "R_w", 7, 0);
		grid[7][0] = piece;
		white.addPiece(piece);
		
		piece = new Knight(isWhite, "N_w", 7, 1);
		grid[7][1] = piece;
		white.addPiece(piece);
		
		piece = new Bishop(isWhite, "B_w", 7, 2);
		grid[7][2] = piece;
		white.addPiece(piece);
		
		piece = new Queen(isWhite, "Q_w", 7, 3);
		grid[7][3] = piece;
		white.addPiece(piece);
		
		piece = new King(isWhite, "K_w", 7, 4);
		grid[7][4] = piece;
		white.addPiece(piece);
		
		piece = new Bishop(isWhite, "B_w", 7, 5);
		grid[7][5] = piece;
		white.addPiece(piece);
		
		piece = new Knight(isWhite, "N_w", 7, 6);
		grid[7][6] = piece;
		white.addPiece(piece);
		
		piece = new Rook(isWhite, "R_w", 7, 7);
		grid[7][7] = piece;
		white.addPiece(piece);
						
		// Initialize black pieces
		piece = new Rook(!isWhite, "R_b", 0, 0);
		grid[0][0] = piece;
		white.addPiece(piece);
		
		piece = new Knight(!isWhite, "N_b", 0, 1);
		grid[0][1] = piece;
		white.addPiece(piece);
		
		piece = new Bishop(!isWhite, "B_b", 0, 2);
		grid[0][2] = piece;
		white.addPiece(piece);
		
		piece = new Queen(!isWhite, "Q_b", 0, 3);
		grid[0][3] = piece;
		white.addPiece(piece);
		
		piece = new King(!isWhite, "K_b", 0, 4);
		grid[0][4] = piece;
		black.addPiece(piece);
		
		piece = new Bishop(!isWhite, "B_b", 0, 5);
		grid[0][5] = piece;
		white.addPiece(piece);
		
		piece = new Knight(!isWhite, "N_b", 0, 6);
		grid[0][6] = piece;
		white.addPiece(piece);
		
		piece = new Rook(!isWhite, "R_b", 0, 7);
		grid[0][7] = piece;
		white.addPiece(piece);
		
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
	
	public void move(Player player, Position startPosition, Position endPosition) throws IllegalMoveException, UnauthorizedMoveException {
		
		String endPositionAlgebraicNotation = "" + endPosition.getFile() + endPosition.getRank();
		this.move(player, startPosition.getRow(), startPosition.getColumn(), endPosition.getRow(), endPosition.getColumn(), endPositionAlgebraicNotation);
		
	}
	
	public void move(Player player, int row, int column, int newRow, int newColumn, String endPositionAlgebraicNotation) 
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
				log.info("{} to {}", piece.getName(), endPositionAlgebraicNotation);
				
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
				log.info("{} captures {}", piece.getName(), occupant.getName());
				
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
