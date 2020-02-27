package com.scg.grandmaster.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.scg.grandmaster.entity.GameState;
import com.scg.grandmaster.service.GameStateService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/game/state")
public class GameStateController {
	
	private static final Logger log = LoggerFactory.getLogger(GameStateController.class);
	
	@Autowired
	GameStateService gameStateService;
	
	@ApiOperation(value = "Initialize the game", notes = "Initialize the game", response = Void.class)
	@GetMapping("/initialize")
	public ResponseEntity<Void> initialize() {
		log.info("Initializing game");
		Integer createdId = gameStateService.initializeGameState();
		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host("").path("/state").queryParam("id", createdId).build();
		return ResponseEntity.created(uriComponents.toUri()).build();
	}
	
	@ApiOperation(value = "Get the current game state", notes = "Get the current game state", response = GameState.class)
	@GetMapping("/state")
	public ResponseEntity<GameState> getState(@RequestParam("id") Integer id) {
		log.info("Received request to retreive game state");
		return ResponseEntity.ok(gameStateService.getGameStateById(id));
	}
	
}
