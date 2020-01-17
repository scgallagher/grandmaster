package com.scg.grandmaster.game.logic;

import org.springframework.stereotype.Service;

@Service
public class KingMoveValidationService extends MoveValidationServiceBase {

	Boolean isValidMoveKing(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		return Math.abs(destinationRow - sourceRow) == 1 ^ Math.abs(destinationColumn - sourceColumn) == 1;
	}
	
	@Override
	Boolean isValidMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		return isValidMoveKing(sourceRow, sourceColumn, destinationRow, destinationColumn)
				&& !isDestinationOccupiedByAlly(sourceRow, sourceColumn, destinationRow, destinationColumn);
	}
}
