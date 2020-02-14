package com.scg.grandmaster.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.scg.grandmaster.game.Game;
import com.scg.grandmaster.game.Move;
import com.scg.grandmaster.to.GameStateTo;

@RunWith(MockitoJUnitRunner.class)
public class GameControllerTest {
	
	@Mock
	private Game game;
	
	@InjectMocks
	private GameController gameController;
	
	@Test
	public void initialize_Success() {
		doNothing().when(game).initialize();
		
		ResponseEntity<Void> result = gameController.initialize();
		
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void move_Success() {
		doNothing().when(game).movePiece(any());
		
		ResponseEntity<Void> result = gameController.move(new Move());
		
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void state_Success() {
		when(game.getState()).thenReturn(new GameStateTo());
		
		ResponseEntity<GameStateTo> result = gameController.state();
		
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
