package com.scg.grandmaster.game.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scg.grandmaster.exception.IllegalMoveException;
import com.scg.grandmaster.game.entity.Color;
import com.scg.grandmaster.game.entity.Piece;

@Service
public class PawnMoveValidationService {
	
	private static final Logger logger = LoggerFactory.getLogger(PawnMoveValidationService.class);

	@Autowired
	private Board board;
	
	Boolean isStartingPosition(Integer sourceRow) {
		return sourceRow == 1 || sourceRow == 6;
	}
	
	Boolean isPathBlocked(Integer sourceRow, Integer sourceColumn, Integer destinationRow) {
		for (int i = sourceRow + 1; i <= destinationRow; i++) {
			if (board.getPieceAt(i, sourceColumn) != null) {
				return true;
			}
		}
		return false;
	}
	
	Boolean isBackwardMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow) {
		Piece piece = board.getPieceAt(sourceRow, sourceColumn);
		if (piece.getColor() == Color.WHITE) {
			return destinationRow < sourceRow;
		}
		else {
			return destinationRow > sourceRow;
		}
	}
	
	Boolean isValidVerticalMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		/*
		 *  Valid moves for white:
		 *  (1, 0) to (2, 0)
		 *  (1, 0) to (3, 0)
		 *  Valid moves for black:
		 *  (6, 0) to (5, 0)
		 *  (6, 0) to (4, 0)
		 */
		if (sourceColumn == destinationColumn) {
			if(isBackwardMove(sourceRow, sourceColumn, destinationRow)) {
				return false;
			}
			else if (Math.abs(destinationRow - sourceRow) == 1) {
				return true;
			}
			else if (isStartingPosition(sourceRow) && Math.abs(destinationRow - sourceRow) == 2) {
				return true;
			}
		}
		return false;
	}
	
	Boolean isValidDiagonalMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		/*
		 *  Possible diagonal moves white:
		 *  (4, 4) to (5, 5)
		 *  (4, 4) to (5, 3)
		 *  Possible diagonal moves black:
		 *  (4, 4) to (3, 3)
		 *  (4, 4) to (3, 5)
		 */
		if (isBackwardMove(sourceRow, sourceColumn, destinationRow)) {
			return false;
		}
		else {
			return Math.abs(sourceRow - destinationRow) == 1 && Math.abs(sourceColumn - destinationColumn) == 1;
		}
	}
	
	Boolean isValidCapture(Integer sourceRow, Integer sourceColumn, Integer destinationRow,
			Integer destinationColumn) {
		return isValidDiagonalMove(sourceRow, sourceColumn, destinationRow, destinationColumn) &&
				CommonLogic.isOpponent(board.getPieceAt(sourceRow, sourceColumn), board.getPieceAt(destinationRow, destinationColumn));
	}
	
	Boolean isValidMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		if (isValidVerticalMove(sourceRow, sourceColumn, destinationRow, destinationColumn)) {
			return isPathBlocked(sourceRow, sourceColumn, destinationRow);
		}
		else {
			return isValidCapture(sourceRow, sourceColumn, destinationRow, destinationColumn);
		}
	}
	
	public void validateMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		if (isValidMove(sourceRow, sourceColumn, destinationRow, destinationColumn)) {
			logger.info("Valid Move: Pawn ({}, {}) to ({}, {})", sourceRow, sourceColumn, destinationRow, destinationColumn);
		}
		else {
			String message = "Pawn (" + sourceRow + ", " + sourceColumn + ") to (" + destinationRow + ", " + destinationColumn + ")";
			logger.error("Illegal Move: " + message);
			throw new IllegalMoveException(message);
		}
	}
}
