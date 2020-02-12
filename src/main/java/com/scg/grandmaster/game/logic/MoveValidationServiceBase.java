package com.scg.grandmaster.game.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.scg.grandmaster.exception.IllegalMoveException;
import com.scg.grandmaster.game.entity.Piece;

public class MoveValidationServiceBase {
	
	private static final Logger logger = LoggerFactory.getLogger(MoveValidationServiceBase.class);

	@Autowired
	Board board;
	
	public Boolean isAlly(Piece pieceOne, Piece pieceTwo) {
		return pieceOne.getColor() == pieceTwo.getColor();
	}
	
	public Boolean isOpponent(Piece pieceOne, Piece pieceTwo) {
		return !isAlly(pieceOne, pieceTwo);
	}
	
	public Boolean isCapture(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		Piece occupant = board.getPieceAt(destinationRow, destinationColumn);
		if (occupant != null && !this.isAlly(board.getPieceAt(sourceRow, sourceColumn), occupant)) {
			return true;
		} else {
			return false;
		}
	}
	
	Boolean isDestinationOccupiedByAlly(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		Piece occupant = board.getPieceAt(destinationRow, destinationColumn);
		if (occupant != null && this.isAlly(board.getPieceAt(sourceRow, sourceColumn), occupant)) {
			return true;
		} else {
			return false;
		}
	}
	
	Boolean isPathBlockedDiagonal(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
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
		return false;
	}

	
	Boolean isPathBlockedVertical(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		if (destinationRow - sourceRow > 0) {
			// Up vertical path
			for (int i = sourceRow + 1; i < destinationRow; i++) {
				if (board.getPieceAt(i, sourceColumn) != null) {
					return true;
				}
			}
		}
		else if (destinationRow - sourceRow < 0) {
			// Down vertical path
			for (int i = sourceRow - 1; i > destinationRow; i--) {
				if (board.getPieceAt(i, sourceColumn) != null) {
					return true;
				}
			}
		}

		return false;
	}
	
	Boolean isPathBlockedHorizontal(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		if (destinationColumn - sourceColumn > 0) {
			// Right horizontal path
			for (int i = sourceColumn + 1; i < destinationColumn; i++) {
				if (board.getPieceAt(sourceRow, i) != null) {
					return true;
				}
			}
		}
		else if (destinationColumn - sourceColumn < 0) {
			// Left horizontal path
			for (int i = sourceColumn - 1; i > destinationColumn; i--) {
				if (board.getPieceAt(sourceRow, i) != null) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	Boolean isValidDiagonalMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		Integer slope = (destinationColumn - sourceColumn) / (destinationRow - sourceRow);
		return Math.abs(slope) == 1;
	}
	
	
	Boolean isValidHorizontalMove(Integer sourceColumn, Integer destinationColumn) {
		return sourceColumn == destinationColumn;
	}
	
	Boolean isValidVerticalMove(Integer sourceRow, Integer destinationRow) {
		return sourceRow == destinationRow;
	}
	
	Boolean isValidMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		return false;
	}
	
	public void validateMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		if (isValidMove(sourceRow, sourceColumn, destinationRow, destinationColumn)) {
			logger.debug("Valid move: ({}, {}) to ({}, {})", sourceRow, sourceColumn, destinationRow, destinationColumn);
		}
		else {
			String message = "(" + sourceRow + ", " + sourceColumn + ") to (" + destinationRow + ", " + destinationColumn + ")";
			logger.error("Illegal Move: " + message);
			throw new IllegalMoveException(message);
		}
	}
	
}
