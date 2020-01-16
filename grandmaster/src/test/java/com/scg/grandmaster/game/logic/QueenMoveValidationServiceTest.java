package com.scg.grandmaster.game.logic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QueenMoveValidationServiceTest {

	@Spy
	@InjectMocks
	QueenMoveValidationService queenMoveValidationService;
	
	@Mock
	Board board;
	
	@Test
	public void isValidMove_ValidDiagonalMovePathIsNotBlockedDestinationIsNotOccupiedReturnsTrue() {
		doReturn(Boolean.TRUE).when(queenMoveValidationService).isValidDiagonalMove(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(queenMoveValidationService).isPathBlockedDiagonal(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(queenMoveValidationService).isPathBlockedVertical(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(queenMoveValidationService).isPathBlockedHorizontal(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(queenMoveValidationService).isDestinationOccupiedByAlly(any(), any(), any(), any());
		
		Boolean result = queenMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_ValidHorizontalOrVerticalMovePathIsNotBlockedDestinationIsNotOccupiedReturnsTrue() {
		doReturn(Boolean.FALSE).when(queenMoveValidationService).isValidDiagonalMove(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(queenMoveValidationService).isValidHorizontalOrVerticalMove(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(queenMoveValidationService).isPathBlockedDiagonal(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(queenMoveValidationService).isPathBlockedVertical(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(queenMoveValidationService).isPathBlockedHorizontal(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(queenMoveValidationService).isDestinationOccupiedByAlly(any(), any(), any(), any());
		
		Boolean result = queenMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_ValidDiagonalMovePathIsNotBlockedDestinationIsOccupiedReturnsFalse() {
		doReturn(Boolean.TRUE).when(queenMoveValidationService).isValidDiagonalMove(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(queenMoveValidationService).isPathBlockedDiagonal(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(queenMoveValidationService).isPathBlockedVertical(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(queenMoveValidationService).isPathBlockedHorizontal(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(queenMoveValidationService).isDestinationOccupiedByAlly(any(), any(), any(), any());
		
		Boolean result = queenMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_ValidDiagonalMovePathIsBlockedHorizontallyReturnsFalse() {
		doReturn(Boolean.TRUE).when(queenMoveValidationService).isValidDiagonalMove(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(queenMoveValidationService).isPathBlockedDiagonal(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(queenMoveValidationService).isPathBlockedVertical(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(queenMoveValidationService).isPathBlockedHorizontal(any(), any(), any(), any());
		
		Boolean result = queenMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_ValidDiagonalMovePathIsBlockedVeritcallyReturnsFalse() {
		doReturn(Boolean.TRUE).when(queenMoveValidationService).isValidDiagonalMove(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(queenMoveValidationService).isPathBlockedDiagonal(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(queenMoveValidationService).isPathBlockedVertical(any(), any(), any(), any());
		
		Boolean result = queenMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_ValidDiagonalMovePathIsBlockedDiagonallyReturnsFalse() {
		doReturn(Boolean.TRUE).when(queenMoveValidationService).isValidDiagonalMove(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(queenMoveValidationService).isPathBlockedDiagonal(any(), any(), any(), any());
		
		Boolean result = queenMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_InvalidDiagonalMoveReturnsFalse() {
		doReturn(Boolean.FALSE).when(queenMoveValidationService).isValidDiagonalMove(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(queenMoveValidationService).isValidHorizontalOrVerticalMove(any(), any(), any(), any());
		
		Boolean result = queenMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
}
