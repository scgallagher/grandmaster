package com.scg.grandmaster.service;

import java.util.Collections;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.scg.grandmaster.entity.GameState;
import com.scg.grandmaster.entity.PieceState;
import com.scg.grandmaster.game.entity.Color;
import com.scg.grandmaster.game.entity.PieceType;
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
		
		PieceState pieceState = new PieceState();
		pieceState.setColor(Color.WHITE.name());
		pieceState.setPieceType(PieceType.BISHOP.toString());
		pieceState.setShortName("B_w");
		pieceState.setRow(0);
		pieceState.setColumn(1);
		gameState.setPieceStateList(Collections.singletonList(pieceState));
		
		gameStateRepository.save(gameState);
		
		Integer createdId = gameState.getId();
		log.info("Created game state with Id: {}", createdId);
		return createdId;
	}
	
}
