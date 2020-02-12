package com.scg.grandmaster.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scg.grandmaster.game.Game;
import com.scg.grandmaster.game.Move;
import com.scg.grandmaster.to.GameState;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/game")
public class GameController {
	
	private static final Logger log = LoggerFactory.getLogger(GameController.class);

	@Autowired
	Game game;
	
	@ApiOperation(value = "Initialize the game", notes = "Initialize the game", response = Void.class)
	@GetMapping("/initialize")
	public ResponseEntity<Void> initialize() {
		log.info("Initializing game");
		game.initialize();
		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value = "Make a move", notes = "Make a move", response = Void.class)
	@PostMapping("/move")
	public ResponseEntity<Void> move(@RequestBody Move move) {
		log.info("Received move request: {}", move);
		game.movePiece(move);
		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value = "Get the current game state", notes = "Get the current game state", response = GameState.class)
	@GetMapping("/state")
	public ResponseEntity<GameState> state() {
		log.info("Received request to retreive game state");
		return ResponseEntity.ok(game.getState());
	}
	
}
