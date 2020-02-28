package com.scg.grandmaster.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.scg.grandmaster.entity.GameState;
import com.scg.grandmaster.service.GameStateService;

@RunWith(MockitoJUnitRunner.class)
public class GameStateControllerTest {
	
	@Mock
	private GameStateService gameStateService;
	
	@InjectMocks
	private GameStateController gameController;
	
	@Test
	public void initialize_Success() {
		when(gameStateService.initializeGameState()).thenReturn(null);
		
		ResponseEntity<GameState> result = gameController.initialize();
		
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void state_Success() {
		when(gameStateService.getGameStateById(any())).thenReturn(new GameState());
		
		ResponseEntity<GameState> result = gameController.getState(null);
		
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
