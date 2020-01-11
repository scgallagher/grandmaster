package com.scg.grandmaster.game.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scg.grandmaster.exception.IllegalMoveException;
import com.scg.grandmaster.game.entity.Piece;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class MoveValidationService {
	
	@Autowired
	private Board board;
	
	@Autowired
	private PawnMoveValidationService pawnMoveValidationService;
	
	Boolean isValueOutOfBounds(Integer value) {
		return value < 0 || value > 7;
	}
	
	public void validateMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		if (isValueOutOfBounds(sourceRow) || isValueOutOfBounds(sourceColumn) 
				|| isValueOutOfBounds(destinationRow) || isValueOutOfBounds(destinationColumn)) {
			throw new IllegalMoveException("Coordinates cannot be negative");
		}
		Piece piece = board.getPieceAt(sourceRow, sourceColumn);
		
		switch(piece.getPieceType()) {
			case PAWN:
				pawnMoveValidationService.validateMove(sourceRow, sourceColumn, destinationRow, destinationColumn);
				break;
			case ROOK:
				validateRookMove(sourceRow, sourceColumn, destinationRow, destinationColumn);
				break;
			case KNIGHT:
				validateKnightMove(sourceRow, sourceColumn, destinationRow, destinationColumn);
				break;
			case BISHOP:
				validateBishopMove(sourceRow, sourceColumn, destinationRow, destinationColumn);
				break;
			case QUEEN:
				validateQueenMove(sourceRow, sourceColumn, destinationRow, destinationColumn);
				break;
			case KING:
				validateKingMove(sourceRow, sourceColumn, destinationRow, destinationColumn);
				break;
		}
	}
	
	public void validatePawnMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		throw new IllegalMoveException("");
	}
	
	public void validateRookMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		throw new IllegalMoveException("");
	}
	
	public void validateKnightMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		throw new IllegalMoveException("");
	}
	
	public void validateBishopMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		throw new IllegalMoveException("");
	}
	
	public void validateQueenMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		throw new IllegalMoveException("");
	}
	
	public void validateKingMove(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		throw new IllegalMoveException("");
	}

}
