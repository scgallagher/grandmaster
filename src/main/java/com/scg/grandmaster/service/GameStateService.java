package com.scg.grandmaster.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.scg.grandmaster.entity.GameState;
import com.scg.grandmaster.repository.GameStateRepository;

@Service
public class GameStateService {
	
	private static final Logger log = LoggerFactory.getLogger(GameStateService.class);

	@Autowired
	private GameStateRepository gameStateRepository;
	
	public GameState getGameStateById(Integer id) {
		Optional<GameState> response = gameStateRepository.findById(id);
		
		return response.orElseThrow(ResourceNotFoundException::new);
	}
	
	public Integer initializeGameState() {
		GameState gameState = new GameState();
		gameState.setState("");
		
		gameStateRepository.save(gameState);
		
		Integer createdId = gameState.getId();
		log.info("Created game state with Id: {}", createdId);
		return createdId;
	}
	
}
