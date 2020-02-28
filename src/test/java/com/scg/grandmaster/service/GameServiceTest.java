package com.scg.grandmaster.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.scg.grandmaster.entity.GameState;
import com.scg.grandmaster.game.domain.Move;
import com.scg.grandmaster.game.logic.MoveValidationService;
import com.scg.grandmaster.service.GameService;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

	@Spy
	@InjectMocks
	GameService gameService;
	
	@Mock
	GameStateService gameStateService;
	
	@Mock
	MoveValidationService moveValidationService;
	
	@Test
	public void movePiece_MoveObjectPieceIsMovedSuccessfully() {
		when(gameStateService.getGameStateById(any())).thenReturn(null);
		
		gameService.movePiece(new Move());
		
		verify(gameService).movePiece(any(), any(), any(), any(), any());
	}
	
	@Test
	public void movePiece_PieceIsMovedSuccessfully() {
		GameState gameState = new GameState();
		Integer sourceRow = 1;
		Integer sourceColumn = 0;
		Integer destinationRow = 2;
		Integer destinationColumn = 0;
		
		doNothing().when(moveValidationService).validateMove(any(), any(), any(), any(), any());
		
		doNothing().when(gameStateService).updateGameState(any(), any(), any(), any(), any());
		
		gameService.movePiece(gameState, sourceRow, sourceColumn, destinationRow, destinationColumn);
	}
}
