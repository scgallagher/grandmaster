package com.grandmaster.cli;

import com.grandmaster.chesspieces.Bishop;
import com.grandmaster.chesspieces.King;
import com.grandmaster.chesspieces.Knight;
import com.grandmaster.chesspieces.Pawn;
import com.grandmaster.chesspieces.Piece;
import com.grandmaster.chesspieces.Queen;
import com.grandmaster.chesspieces.Rook;

public class MoveFactory {
	
	private static int parseRow(char rank) {
		
		return 7 - (rank - '1');
		
	}
	
	private static int parseColumn(char file) {
		
		file = Character.toUpperCase(file);
		return file - 'A';
		
	}
	
	private static Piece parsePiece(char piece) throws MoveParserException {
		
		switch (piece) {
			case 'p':
				return new Pawn(true, "", 0, 0, null);
			case 'R':
				return new Rook(true, "", 0, 0);
			case 'N':
				return new Knight(true, "", 0, 0);
			case 'B':
				return new Bishop(true, "", 0, 0);
			case 'Q':
				return new Queen(true, "", 0, 0);
			case 'K':
				return new King(true, "", 0, 0);
			default:
				throw new MoveParserException();
		}
		
	}
	
	public static Move parseMove(String move) throws MoveParserException {
		
		if (move.length() < 3) {
			throw new MoveParserException();
		}
		
		char cPiece = move.charAt(0);
		char file = move.charAt(1);
		char rank = move.charAt(2);
		
		int row = parseRow(rank);
		int column = parseColumn(file);
		Piece piece = parsePiece(cPiece);
		
		return new Move(row, column, piece);
		
	}
	
}
