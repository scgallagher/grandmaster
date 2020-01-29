package com.scg.grandmaster.game.logic;

import org.springframework.stereotype.Service;

@Service
public class RookMoveValidationService extends MoveValidationServiceBase {
	
	@Override
	Boolean isValidMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		return ((isValidHorizontalMove(sourceColumn, destinationColumn) && !isPathBlockedHorizontal(sourceRow, sourceColumn, destinationRow, destinationColumn))
					|| (isValidVerticalMove(sourceRow, destinationRow) && !isPathBlockedVertical(sourceRow, sourceColumn, destinationRow, destinationColumn)))
				&& !isDestinationOccupiedByAlly(sourceRow, sourceColumn, destinationRow, destinationColumn);
	}
}
