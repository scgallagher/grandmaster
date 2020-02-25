package com.scg.grandmaster.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
		
		PieceState pieceStateOne = new PieceState();
		pieceStateOne.setColor(Color.WHITE.name());
		pieceStateOne.setPieceType(PieceType.BISHOP.toString());
		pieceStateOne.setShortName("B_w");
		pieceStateOne.setRow(0);
		pieceStateOne.setColumn(1);
		pieceStateOne.setGameState(gameState);
		
		PieceState pieceStateTwo = new PieceState();
		pieceStateTwo.setColor(Color.WHITE.name());
		pieceStateTwo.setPieceType(PieceType.KNIGHT.toString());
		pieceStateTwo.setShortName("B_w");
		pieceStateTwo.setRow(0);
		pieceStateTwo.setColumn(2);
		pieceStateTwo.setGameState(gameState);
		
		List<PieceState> pieceStates = new ArrayList<>();
		pieceStates.add(pieceStateOne);
		pieceStates.add(pieceStateTwo);
		gameState.setPieceStateList(pieceStates);
		
		gameStateRepository.save(gameState);
		
		Integer createdId = gameState.getId();
		log.info("Created game state with Id: {}", createdId);
		return createdId;
	}
	
}
