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
public class BishopMoveValidationServiceTest {

	@Spy
	@InjectMocks
	BishopMoveValidationService bishopMoveValidationService;
	
	@Mock
	Board board;
	
	@Test
	public void isValidMove_ValidDiagonalMovePathIsNotBlockedDestinationIsNotOccupiedReturnsTrue() {
		doReturn(Boolean.TRUE).when(bishopMoveValidationService).isValidDiagonalMove(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(bishopMoveValidationService).isPathBlockedDiagonal(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(bishopMoveValidationService).isDestinationOccupiedByAlly(any(), any(), any(), any());
		
		Boolean result = bishopMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_ValidDiagonalMovePathIsNotBlockedDestinationNotOccupiedReturnsTrue() {
		doReturn(Boolean.TRUE).when(bishopMoveValidationService).isValidDiagonalMove(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(bishopMoveValidationService).isPathBlockedDiagonal(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(bishopMoveValidationService).isDestinationOccupiedByAlly(any(), any(), any(), any());
		
		Boolean result = bishopMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_ValidDiagonalMovePathIsBlockedReturnsFalse() {
		doReturn(Boolean.TRUE).when(bishopMoveValidationService).isValidDiagonalMove(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(bishopMoveValidationService).isPathBlockedDiagonal(any(), any(), any(), any());
		
		Boolean result = bishopMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_InvalidDiagonalMoveReturnsFalse() {
		doReturn(Boolean.FALSE).when(bishopMoveValidationService).isValidDiagonalMove(any(), any(), any(), any());
		
		Boolean result = bishopMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}	
}
