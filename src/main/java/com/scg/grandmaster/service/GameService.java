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
	
	public GameState movePiece(Move move) {
		GameState gameState = gameStateService.getGameStateById(move.getGameStateId());
		return movePiece(gameState, move.getSourceRow(), move.getSourceColumn(), move.getDestinationRow(), move.getDestinationColumn());
	}

	public GameState movePiece(GameState gameState, Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		moveValidationService.validateMove(gameState, sourceRow, sourceColumn, destinationRow, destinationColumn);
		return gameStateService.updateGameState(gameState, sourceRow, sourceColumn, destinationRow, destinationColumn);
	}
}
