package com.scg.grandmaster.game.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scg.grandmaster.controller.GlobalExceptionHandler.IllegalMoveException;
import com.scg.grandmaster.entity.GameState;
import com.scg.grandmaster.game.entity.Color;
import com.scg.grandmaster.game.entity.Piece;
import com.scg.grandmaster.game.entity.PieceType;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class MoveValidationService {
	
	private static final Logger logger = LoggerFactory.getLogger(MoveValidationService.class);
	
	@Autowired
	private PawnMoveValidationService pawnMoveValidationService;
	
	@Autowired
	private RookMoveValidationService rookMoveValidationService;
	
	@Autowired
	private KnightMoveValidationService knightMoveValidationService;
	
	@Autowired
	private BishopMoveValidationService bishopMoveValidationService;
	
	@Autowired
	private QueenMoveValidationService queenMoveValidationService;
	
	@Autowired
	private KingMoveValidationService kingMoveValidationService;
	
	Boolean isValueOutOfBounds(Integer value) {
		return value < 0 || value > 7;
	}
	
	public void validateMove(GameState gameState, Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		logger.info("Validating move ({}, {}) to ({}, {})", sourceRow, sourceColumn, destinationRow, destinationColumn );
		
		if (isValueOutOfBounds(sourceRow) || isValueOutOfBounds(sourceColumn) 
				|| isValueOutOfBounds(destinationRow) || isValueOutOfBounds(destinationColumn)) {
			String message = "Coordinates cannot be negative: (" + sourceRow + ", " + sourceColumn + ") to (" + destinationRow + ", " + destinationColumn + ")"; 
			logger.error(message);
			throw new IllegalMoveException(message);
		}
		
		Board board = createBoardFromGameState(gameState);
		Piece piece = board.getPieceAt(sourceRow, sourceColumn);
		if (piece == null) {
			throw new IllegalMoveException("There is no piece at this location");
		}
		switch(piece.getPieceType()) {
			case PAWN:
				pawnMoveValidationService.validateMove(sourceRow, sourceColumn, destinationRow, destinationColumn);
				break;
			case ROOK:
				rookMoveValidationService.validateMove(sourceRow, sourceColumn, destinationRow, destinationColumn);
				break;
			case KNIGHT:
				knightMoveValidationService.validateMove(sourceRow, sourceColumn, destinationRow, destinationColumn);
				break;
			case BISHOP:
				bishopMoveValidationService.validateMove(sourceRow, sourceColumn, destinationRow, destinationColumn);
				break;
			case QUEEN:
				queenMoveValidationService.validateMove(sourceRow, sourceColumn, destinationRow, destinationColumn);
				break;
			case KING:
				kingMoveValidationService.validateMove(sourceRow, sourceColumn, destinationRow, destinationColumn);
				break;
		}
	}
	
	public Board createBoardFromGameState(GameState gameState) {
		Board board = new Board();
		gameState.getPieceStateList().stream().forEach(pieceState -> {
			Piece piece = new Piece();
			piece.setColor(Color.valueOf(pieceState.getColor()));
			piece.setPieceType(PieceType.valueOf(pieceState.getPieceType()));
			piece.setShortName(pieceState.getShortName());
			board.putPiece(piece, pieceState.getRow(), pieceState.getColumn());
		});
		return board;
	}
}
