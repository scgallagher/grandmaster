package com.scg.grandmaster.game.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scg.grandmaster.exception.IllegalMoveException;
import com.scg.grandmaster.game.entity.Piece;

@Service
public class RookMoveValidationService {
	
	private static final Logger logger = LoggerFactory.getLogger(PawnMoveValidationService.class);

	@Autowired
	private Board board;
	
	Boolean isPathBlocked(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		if (destinationRow - sourceRow > 0) {
			// Up vertical path
			for (int i = sourceRow + 1; i <= destinationRow; i++) {
				Piece piece = board.getPieceAt(i, sourceColumn);
				if (piece != null && CommonLogic.isAlly(board.getPieceAt(sourceRow, sourceColumn), piece)) {
					return true;
				}
			}
		}
		else if (destinationRow - sourceRow < 0) {
			// Down vertical path
			for (int i = sourceRow - 1; i >= destinationRow; i--) {
				Piece piece = board.getPieceAt(i, sourceColumn);
				if (piece != null && CommonLogic.isAlly(board.getPieceAt(sourceRow, sourceColumn), piece)) {
					return true;
				}
			}
		}
		else if (destinationColumn - sourceColumn > 0) {
			// Right horizontal path
			for (int i = sourceColumn + 1; i <= destinationColumn; i++) {
				Piece piece = board.getPieceAt(sourceRow, i);
				if (piece != null && CommonLogic.isAlly(board.getPieceAt(sourceRow, sourceColumn), piece)) {
					return true;
				}
			}
		}
		else if (destinationColumn - sourceColumn < 0) {
			// Left horizontal path
			for (int i = sourceColumn - 1; i >= destinationColumn; i--) {
				Piece piece = board.getPieceAt(sourceRow, i);
				if (piece != null && CommonLogic.isAlly(board.getPieceAt(sourceRow, sourceColumn), piece)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	Boolean isValidVerticalOrHorizontalMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		return sourceRow == destinationRow || sourceColumn == destinationColumn;
	}
	
	public void validateMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		if (isValidVerticalOrHorizontalMove(sourceRow, sourceColumn, destinationRow, destinationColumn)) {
			if (isPathBlocked(sourceRow, sourceColumn, destinationRow, destinationColumn)) {
				String message = "Rook (" + sourceRow + ", " + sourceColumn + ") to (" + destinationRow + ", " + destinationColumn + ")";
				logger.error("Illegal Move: " + message);
				throw new IllegalMoveException(message);
			}
			else {
				logger.debug("Rook: valid move: ({}, {}) to ({}, {})", sourceRow, sourceColumn, destinationRow, destinationColumn);
			}
		}
		else {
			String message = "Rook (" + sourceRow + ", " + sourceColumn + ") to (" + destinationRow + ", " + destinationColumn + ")";
			logger.error("Illegal Move: " + message);
			throw new IllegalMoveException(message);
		}
	}
}
