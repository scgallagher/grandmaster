package com.scg.grandmaster.game.logic;

import org.springframework.stereotype.Service;

@Service
public class KnightMoveValidationService extends MoveValidationServiceBase {
	
	Boolean isValidMoveKnight(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		/*
		 *  Valid moves
		 *  Upright L:
		 *  (4, 4) to (2, 5)
		 *  (4, 4) to (2, 3)
		 *  (4, 4) to (6, 5)
		 *  (4, 4) to (6, 3)
		 *  Sideways L:
		 *  (4, 4) to (3, 6)
		 *  (4, 4) to (3, 2)
		 *  (4, 4) to (5, 2)
		 *  (4, 4) to (5, 6)
		 */
		return (Math.abs(sourceRow - destinationRow) == 2 && Math.abs(sourceColumn - destinationColumn) == 1) ||
				(Math.abs(sourceRow - destinationRow) == 1 && Math.abs(sourceColumn - destinationColumn) == 2);
	}
	
	@Override
	Boolean isValidMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		if (isValidMoveKnight(sourceRow, sourceColumn, destinationRow, destinationColumn)) {
			return !isDestinationOccupiedByAlly(sourceRow, sourceColumn, destinationRow, destinationColumn);
		}
		else {
			return false;
		}
	}
}
