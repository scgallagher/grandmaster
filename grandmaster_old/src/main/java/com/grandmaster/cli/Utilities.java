package com.grandmaster.cli;

import com.grandmaster.chesspieces.Bishop;
import com.grandmaster.chesspieces.King;
import com.grandmaster.chesspieces.Knight;
import com.grandmaster.chesspieces.Pawn;
import com.grandmaster.chesspieces.Piece;
import com.grandmaster.chesspieces.Position;
import com.grandmaster.chesspieces.Queen;
import com.grandmaster.chesspieces.Rook;

public class Utilities {

	public static int parseRow(char rank) {
		
		return 7 - (rank - '1');
		
	}
	
	public static int parseColumn(char file) {
		
		file = Character.toUpperCase(file);
		return file - 'A';
		
	}
	
	public static String parcePiece(char symbol) throws MoveParserException {
		
		switch (symbol) {
			case 'p':
				return "pawn";
			case 'R':
				return "rook";
			case 'N':
				return "knight";
			case 'B':
				return "bishop";
			case 'Q':
				return "queen";
			case 'K':
				return "king";
			default:
				throw new MoveParserException("");
		}
		
	}
	
	public static Piece parcePiece(char symbol, Position position) throws MoveParserException {
		
		switch (symbol) {
			case 'p':
				return new Pawn(true, "", position, null);
			case 'R':
				return new Rook(true, "", position);
			case 'N':
				return new Knight(true, "", position);
			case 'B':
				return new Bishop(true, "", position);
			case 'Q':
				return new Queen(true, "", position);
			case 'K':
				return new King(true, "", position);
			default:
				throw new MoveParserException("");
		}
		
	}
	
}
