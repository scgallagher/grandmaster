package com.scg.grandmaster.game.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scg.grandmaster.exception.IllegalMoveException;
import com.scg.grandmaster.game.entity.Color;
import com.scg.grandmaster.game.entity.Piece;

@Service
public class PawnMoveValidationService {

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
	
	Boolean areOpponents(Piece pieceOne, Piece pieceTwo) {
		return pieceOne.getColor() != pieceTwo.getColor();
	}
	
	Boolean isValidCapture(Integer sourceRow, Integer sourceColumn, Integer destinationRow,
			Integer destinationColumn) {
		return isValidDiagonalMove(sourceRow, sourceColumn, destinationRow, destinationColumn) &&
				areOpponents(board.getPieceAt(sourceRow, sourceColumn), board.getPieceAt(destinationRow, destinationColumn));
	}
	
	public void validateMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		if (isValidVerticalMove(sourceRow, sourceColumn, destinationRow, destinationColumn)) {
			if (isPathBlocked(sourceRow, sourceColumn, destinationRow)) {
				throw new IllegalMoveException("Pawn (" + sourceRow + ", " + sourceColumn + ") to (" + destinationRow + ", " + destinationColumn + ")");
			}
			else {
				// good move
			}
		}
		else if(isValidCapture(sourceRow, sourceColumn, destinationRow, destinationColumn)) {
			// good move
		}
		else {
			throw new IllegalMoveException("Pawn (" + sourceRow + ", " + sourceColumn + ") to (" + destinationRow + ", " + destinationColumn + ")");
		}
	}
}
