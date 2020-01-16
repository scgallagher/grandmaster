package com.scg.grandmaster.game.logic;

import org.springframework.stereotype.Service;

@Service
public class RookMoveValidationService extends MoveValidationServiceBase {
	
	Boolean isValidHorizontalOrVerticalMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		return sourceRow == destinationRow || sourceColumn == destinationColumn;
	}
	
	@Override
	Boolean isValidMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		if (isValidHorizontalOrVerticalMove(sourceRow, sourceColumn, destinationRow, destinationColumn)) {
			return !isPathBlockedVertical(sourceRow, sourceColumn, destinationRow, destinationColumn)
					&& !isPathBlockedHorizontal(sourceRow, sourceColumn, destinationRow, destinationColumn)
					&& !isDestinationOccupiedByAlly(sourceRow, sourceColumn, destinationRow, destinationColumn);
		}
		else {
			return false;
		}
	}
}
