package com.scg.grandmaster.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.scg.grandmaster.game.Move;

@RunWith(MockitoJUnitRunner.class)
public class GameControllerTest {

	@InjectMocks
	private GameController gameController;
	
	@Test
	public void move_Success() {
		ResponseEntity<Void> result = gameController.move(new Move());
		
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
}
