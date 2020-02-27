package com.scg.grandmaster.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scg.grandmaster.entity.GameState;
import com.scg.grandmaster.game.logic.Board;
import com.scg.grandmaster.game.logic.MoveValidationService;

@Service
public class GameService {

	@Autowired
	private Board board;
	
	@Autowired
	private MoveValidationService moveValidationService;
	
	public void movePiece(GameState gameState, Move move) {
		movePiece(gameState, move.getSourceRow(), move.getSourceColumn(), move.getDestinationRow(), move.getDestinationColumn());
	}

	public void movePiece(GameState gameState, Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		moveValidationService.validateMove(gameState, sourceRow, sourceColumn, destinationRow, destinationColumn);
		board.putPiece(board.getPieceAt(sourceRow, sourceColumn), destinationRow, destinationColumn);
		board.removePiece(sourceRow, sourceColumn);
	}
}
