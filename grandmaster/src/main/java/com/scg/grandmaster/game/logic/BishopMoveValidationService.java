package com.scg.grandmaster.game.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scg.grandmaster.exception.IllegalMoveException;
import com.scg.grandmaster.game.entity.Piece;

@Service
public class BishopMoveValidationService {

private static final Logger logger = LoggerFactory.getLogger(BishopMoveValidationService.class);
	
	@Autowired
	private Board board;
	
	Boolean isPathBlocked(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		if (destinationRow > sourceRow && destinationColumn > sourceColumn) {
			// Down right path
			for (int row = sourceRow + 1, column = sourceColumn + 1; row < destinationRow && column < destinationColumn; row++, column ++) {
				if (board.getPieceAt(row, column) != null) {
					return true;
				}
			}
		}
		else if(destinationRow > sourceRow && destinationColumn < sourceColumn) {
			// Down left path
			for (int row = sourceRow + 1, column = sourceColumn - 1; row < destinationRow && column > destinationColumn; row++, column--) {
				if (board.getPieceAt(row, column) != null) {
					return true;
				}
			}
		}
		else if (destinationRow < sourceRow && destinationColumn < sourceColumn) {
			// Up left path
			for (int row = sourceRow - 1, column = sourceColumn - 1; row > destinationRow && column > destinationColumn; row--, column --) {
				if (board.getPieceAt(row, column) != null) {
					return true;
				}
			}
		}
		else if(destinationRow < sourceRow && destinationColumn > sourceColumn) {
			// Up right path
			for (int row = sourceRow - 1, column = sourceColumn + 1; row > destinationRow && column < destinationColumn; row--, column ++) {
				if (board.getPieceAt(row, column) != null) {
					return true;
				}
			}
		}
		
		
		Piece occupant = board.getPieceAt(destinationRow, destinationColumn);
		if (occupant != null && CommonLogic.isAlly(board.getPieceAt(sourceRow, destinationRow), occupant)) {
			return true;
		} else {
			return false;
		}
	}

	Boolean isValidMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		Integer slope = (destinationColumn - sourceColumn) / (destinationRow - sourceRow);
		return Math.abs(slope) == 1;
	}
	
	public void validateMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		if (isValidMove(sourceRow, sourceColumn, destinationRow, destinationColumn)) {
			if (isPathBlocked(sourceRow, sourceColumn, destinationRow, destinationColumn)) {
				String message = "Bishop (" + sourceRow + ", " + sourceColumn + ") to (" + destinationRow + ", " + destinationColumn + ")";
				logger.error("Illegal Move: " + message);
				throw new IllegalMoveException(message);
			}
			else {
				logger.debug("Bishop: valid move: ({}, {}) to ({}, {})", sourceRow, sourceColumn, destinationRow, destinationColumn);
			}
		}
		else {
			String message = "Bishop (" + sourceRow + ", " + sourceColumn + ") to (" + destinationRow + ", " + destinationColumn + ")";
			logger.error("Illegal Move: " + message);
			throw new IllegalMoveException(message);
		}
	}
	
}
