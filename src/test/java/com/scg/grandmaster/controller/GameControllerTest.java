package com.scg.grandmaster.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.scg.grandmaster.entity.GameState;
import com.scg.grandmaster.game.domain.Move;
import com.scg.grandmaster.service.GameService;

@RunWith(MockitoJUnitRunner.class)
public class GameControllerTest {

	@InjectMocks
	private GameController gameController;
	
	@Mock
	GameService gameService;
	
	@Test
	public void move_Success() {
		when(gameService.movePiece(any())).thenReturn(null);
		
		ResponseEntity<GameState> result = gameController.move(new Move());
		
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
}
