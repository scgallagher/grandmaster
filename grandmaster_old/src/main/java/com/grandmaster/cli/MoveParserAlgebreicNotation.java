package com.grandmaster.cli;

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
import com.grandmaster.cli.entity.Move;

public class MoveParserAlgebreicNotation {
	
	private static Logger log = LogManager.getLogger(MoveParserAlgebreicNotation.class);
	
	public static Position parsePosition(String move) throws MoveParserException {
		
		char file = move.charAt(1);
		char rank = move.charAt(2);
		
		int row = Utilities.parseRow(rank);
		int column = Utilities.parseColumn(file);
		
		return new Position(row, column);
		
	}
	
	public static Move parseMove(String move) throws MoveParserException {
		
		log.debug("Parsing move: {}", move);
		
		if (move.length() < 3) {
			throw new MoveParserException("");
		}
		
		char pieceSymbol = move.charAt(0);
		Position position = parsePosition(move);
		Piece piece = Utilities.parcePiece(pieceSymbol, position);
		
		return new Move(null, position, piece);
		
	}
	
}
