package com.scg.grandmaster.controller;

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
	
	@Autowired
	Game game;
	
	@GetMapping(value = "initialize")
	public ResponseEntity<Void> initialize() {
		game.initialize();
		game.printBoard();
		return ResponseEntity.ok().build();
	}
	
	@PostMapping(value = "move")
	public ResponseEntity<Void> move(@RequestBody Move move) {
		game.movePiece(move.getSourceRow(), move.getSourceColumn(), move.getDestinationRow(), move.getDestinationColumn());
		game.printBoard();
		return ResponseEntity.ok().build();
	}

}
