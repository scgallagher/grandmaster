package com.scg.grandmaster.game.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scg.grandmaster.exception.IllegalMoveException;
import com.scg.grandmaster.game.entity.Piece;

@Service
public class KnightMoveValidationService {

	private static final Logger logger = LoggerFactory.getLogger(KnightMoveValidationService.class);
	
	@Autowired
	private Board board;
	
	Boolean isPathBlocked(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		Piece occupant = board.getPieceAt(destinationRow, destinationColumn);
		if (occupant == null) {
			return false;
		}
		else {
			return CommonLogic.isAlly(board.getPieceAt(sourceRow, sourceColumn), occupant);
		}
	}
	
	Boolean isValidMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
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
	
	public void validateMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		if (isValidMove(sourceRow, sourceColumn, destinationRow, destinationColumn)) {
			if (isPathBlocked(sourceRow, sourceColumn, destinationRow, destinationColumn)) {
				String message = "Knight (" + sourceRow + ", " + sourceColumn + ") to (" + destinationRow + ", " + destinationColumn + ")";
				logger.error("Illegal Move: " + message);
				throw new IllegalMoveException(message);
			}
			else {
				logger.debug("Knight: valid move: ({}, {}) to ({}, {})", sourceRow, sourceColumn, destinationRow, destinationColumn);
			}
		}
		else {
			String message = "Knight (" + sourceRow + ", " + sourceColumn + ") to (" + destinationRow + ", " + destinationColumn + ")";
			logger.error("Illegal Move: " + message);
			throw new IllegalMoveException(message);
		}
	}
	
}
