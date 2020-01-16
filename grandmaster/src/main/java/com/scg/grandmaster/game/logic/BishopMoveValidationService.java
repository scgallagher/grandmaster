package com.scg.grandmaster.game.logic;

import org.springframework.stereotype.Service;

@Service
public class BishopMoveValidationService extends MoveValidationServiceBase {

	Boolean isValidDiagonalMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		Integer slope = (destinationColumn - sourceColumn) / (destinationRow - sourceRow);
		return Math.abs(slope) == 1;
	}
	
	@Override
	Boolean isValidMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		if (isValidDiagonalMove(sourceRow, sourceColumn, destinationRow, destinationColumn)) {
			return !isPathBlockedDiagonal(sourceRow, sourceColumn, destinationRow, destinationColumn)
					&& !isDestinationOccupiedByAlly(sourceRow, sourceColumn, destinationRow, destinationColumn);
		}
		else {
			return false;
		}
	}
}
