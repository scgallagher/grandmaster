package com.scg.grandmaster.game.logic;

import org.springframework.stereotype.Service;

@Service
public class QueenMoveValidationService extends MoveValidationServiceBase {

	@Override
	Boolean isValidMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		if (isValidDiagonalMove(sourceRow, sourceColumn, destinationRow, destinationColumn)
				|| isValidHorizontalOrVerticalMove(sourceRow, sourceColumn, destinationRow, destinationColumn)) {
			return !isPathBlockedDiagonal(sourceRow, sourceColumn, destinationRow, destinationColumn)
					&& !isPathBlockedVertical(sourceRow, sourceColumn, destinationRow, destinationColumn)
					&& !isPathBlockedHorizontal(sourceRow, sourceColumn, destinationRow, destinationColumn)
					&& !isDestinationOccupiedByAlly(sourceRow, sourceColumn, destinationRow, destinationColumn);
		}
		else {
			return false;
		}
	}
}
