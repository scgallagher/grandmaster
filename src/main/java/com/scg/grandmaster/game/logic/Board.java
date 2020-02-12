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
	
	public String createColumnLabels() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(" |");
		for (int i = 0; i < MAX_COLUMN; i++) {
			sb.append(" ");
			sb.append(i);
			sb.append(" ");
			sb.append("|");
		}
		sb.append("\n");
		
		return sb.toString();
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(createColumnLabels());
		
		for (int i = 0; i < MAX_ROW; i++) {
			sb.append(i);
			sb.append("|");
			for (int j = 0; j < MAX_COLUMN; j++) {
				if (boardGrid[i][j] == null) {
					sb.append("X  ");
				}
				else {
					sb.append(boardGrid[i][j].getShortName());
				}
				sb.append("|");
			}
			sb.append(i);
			sb.append("\n");
		}
		
		sb.append(createColumnLabels());
		
		return sb.toString();
	}
}
