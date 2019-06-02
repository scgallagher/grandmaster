package com.grandmaster.cli;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.grandmaster.chesspieces.Position;
import com.grandmaster.cli.entity.Move;

public class MoveParserCoordinateNotation {

	private static Logger log = LogManager.getLogger(MoveParserCoordinateNotation.class);
	
	private static void validateMove(String move) throws MoveParserException {
		
		if (move.length() < 5) {
			throw new MoveParserException("Move is incorrectly formatted: " + move);
		}
		
	}
	
	private static Position parsePosition(String positionString) {
		
		log.debug("Parsing position string: {}", positionString);
		
		Character file = positionString.charAt(0);
		Character rank = positionString.charAt(1);
		
		int row = Utilities.parseRow(rank);
		int column = Utilities.parseColumn(file);
		
		Position position = new Position(row, column);
		log.debug("Parsed position: {}", position);
		return position;
		
	}
	
	public static Move parseMove(String moveString) throws MoveParserException {
		
		log.debug("Parsing move: {}", moveString);
		
		validateMove(moveString);
		String[] positions = moveString.split("-");
		Position startPosition = parsePosition(positions[0]);
		Position endPosition = parsePosition(positions[1]);
		return new Move(startPosition, endPosition, null);
		
	}
	
}
