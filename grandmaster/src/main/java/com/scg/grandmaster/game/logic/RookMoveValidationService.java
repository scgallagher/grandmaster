package com.scg.grandmaster.game.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scg.grandmaster.exception.IllegalMoveException;
import com.scg.grandmaster.game.entity.Piece;

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
