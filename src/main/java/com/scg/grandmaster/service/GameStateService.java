package com.scg.grandmaster.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.scg.grandmaster.entity.GameState;
import com.scg.grandmaster.entity.PieceState;
import com.scg.grandmaster.game.Game;
import com.scg.grandmaster.repository.GameStateRepository;

@Service
public class GameStateService {
	
	private static final Logger log = LoggerFactory.getLogger(GameStateService.class);

	@Autowired
	private GameStateRepository gameStateRepository;
	
	@Autowired
	private Game game;
	
	public GameState getGameStateById(Integer id) {
		Optional<GameState> response = gameStateRepository.findById(id);
		
		return response.orElseThrow(ResourceNotFoundException::new);
	}
	
	public Integer initializeGameState() {
		game.initialize();
		
		List<PieceState> pieceStates = game.getPieceStates();
		GameState gameState = new GameState();
		pieceStates.stream().forEach(pieceState -> pieceState.setGameState(gameState));
		gameState.setPieceStateList(pieceStates);
		
		gameStateRepository.save(gameState);
		
		Integer createdId = gameState.getId();
		log.info("Created game state with Id: {}", createdId);
		return createdId;
	}
	
}
