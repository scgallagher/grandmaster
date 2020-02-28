package com.scg.grandmaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scg.grandmaster.entity.GameState;
import com.scg.grandmaster.game.domain.Move;
import com.scg.grandmaster.game.logic.MoveValidationService;

@Service
public class GameService {
	
	@Autowired
	private MoveValidationService moveValidationService;
	
	@Autowired
	private GameStateService gameStateService;
	
	public void movePiece(Move move) {
		GameState gameState = gameStateService.getGameStateById(move.getGameStateId());
		movePiece(gameState, move.getSourceRow(), move.getSourceColumn(), move.getDestinationRow(), move.getDestinationColumn());
	}

	public void movePiece(GameState gameState, Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		moveValidationService.validateMove(gameState, sourceRow, sourceColumn, destinationRow, destinationColumn);
		gameStateService.updateGameState(gameState, sourceRow, sourceColumn, destinationRow, destinationColumn);
	}
}
