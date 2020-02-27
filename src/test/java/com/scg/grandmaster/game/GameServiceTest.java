package com.scg.grandmaster.game;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.scg.grandmaster.entity.GameState;
import com.scg.grandmaster.game.logic.Board;
import com.scg.grandmaster.game.logic.MoveValidationService;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

	@Spy
	@InjectMocks
	GameService gameService;
	
	@Mock
	Board board;
	
	@Mock
	MoveValidationService moveValidationService;
	
	@Test
	public void movePiece_MoveObjectPieceIsMovedSuccessfully() {
		gameService.movePiece(new GameState(), new Move());
		
		verify(gameService).movePiece(any(), any(), any(), any(), any());
	}
	
	@Test
	public void movePiece_PieceIsMovedSuccessfully() {
		GameState gameState = new GameState();
		Integer sourceRow = 1;
		Integer sourceColumn = 0;
		Integer destinationRow = 2;
		Integer destinationColumn = 0;
		
		gameService.movePiece(gameState, sourceRow, sourceColumn, destinationRow, destinationColumn);
		
		verify(moveValidationService).validateMove(gameState, sourceRow, sourceColumn, destinationRow, destinationColumn);
	}
}
