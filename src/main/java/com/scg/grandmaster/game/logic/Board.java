package com.scg.grandmaster.game.logic;

import org.springframework.stereotype.Service;

import com.scg.grandmaster.game.entity.Piece;

@Service
public class Board {

	private final Integer MAX_ROW = 8;
	private final Integer MAX_COLUMN = 8;
	
	private Piece[][] boardGrid;
	
	public Board() {
		boardGrid = new Piece[MAX_ROW][MAX_COLUMN];
	}
	
	public Piece getPieceAt(Integer row, Integer column) {
		return boardGrid[row][column];
	}

	public void putPiece(Piece piece, Integer row, Integer column) {
		boardGrid[row][column] = piece;
	}

	public void removePiece(Integer row, Integer column) {
		boardGrid[row][column] = null;
	}
	
	public Piece[][] get() {
		return boardGrid;
	}
}
