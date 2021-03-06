package com.scg.grandmaster.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scg.grandmaster.entity.GameState;
import com.scg.grandmaster.game.domain.Move;
import com.scg.grandmaster.service.GameService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/game")
public class GameController {

	private static final Logger log = LoggerFactory.getLogger(GameStateController.class);
	
	@Autowired
	private GameService gameService;
	
	@ApiOperation(value = "Make a move", notes = "Make a move", response = Void.class)
	@PostMapping("/move")
	public ResponseEntity<GameState> move(@RequestBody Move move) {
		log.info("Received move request: {}", move);
		GameState gameState = gameService.movePiece(move);
		return ResponseEntity.ok(gameState);
	}
	
	
}
