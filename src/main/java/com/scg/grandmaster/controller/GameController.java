package com.scg.grandmaster.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scg.grandmaster.game.Game;
import com.scg.grandmaster.game.Move;

@RestController
public class GameController {
	
	private static final Logger log = LoggerFactory.getLogger(GameController.class);

	@Autowired
	Game game;
	
	@GetMapping(value = "initialize")
	public ResponseEntity<Void> initialize() {
		log.info("Initializing game");
		game.initialize();
		return ResponseEntity.ok().build();
	}
	
	@PostMapping(value = "move")
	public ResponseEntity<Void> move(@RequestBody Move move) {
		log.info("Received move request: {}", move);
		game.movePiece(move.getSourceRow(), move.getSourceColumn(), move.getDestinationRow(), move.getDestinationColumn());
		return ResponseEntity.ok().build();
	}
	
}
