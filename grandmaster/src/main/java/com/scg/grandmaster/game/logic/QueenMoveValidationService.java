package com.scg.grandmaster.game.logic;

import org.springframework.stereotype.Service;

@Service
public class QueenMoveValidationService extends MoveValidationServiceBase {

	@Override
	Boolean isValidMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		return ((isValidHorizontalMove(sourceRow, destinationRow) && !isPathBlockedHorizontal(sourceRow, sourceColumn, destinationRow, destinationColumn))
					|| (isValidVerticalMove(sourceColumn, destinationColumn) && !isPathBlockedVertical(sourceRow, sourceColumn, destinationRow, destinationColumn))
					|| (isValidDiagonalMove(sourceRow, sourceColumn, destinationRow, destinationColumn) && !isPathBlockedDiagonal(sourceRow, sourceColumn, destinationRow, destinationColumn)))
				&& !isDestinationOccupiedByAlly(sourceRow, sourceColumn, destinationRow, destinationColumn);
	}
}
