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
public class RookMoveValidationServiceTest {

	@Spy
	@InjectMocks
	RookMoveValidationService rookMoveValidationService;
	
	@Mock
	Board board;
	
	@Test
	public void isValidHorizontalOrVerticalMove_ValidVerticalMoveReturnsTrue() {
		Boolean result = rookMoveValidationService.isValidHorizontalOrVerticalMove(0, 0, 3, 0);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidHorizontalOrVerticalMove_ValidHorizontalMoveReturnsTrue() {
		Boolean result = rookMoveValidationService.isValidHorizontalOrVerticalMove(0, 0, 0, 3);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidHorizontalOrVerticalMove_NotValidVerticalOrHorizontalMoveReturnsFalse() {
		Boolean result = rookMoveValidationService.isValidHorizontalOrVerticalMove(0, 0, 3, 3);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_ValidMovePathIsNotBlockedDestinationIsNotOccupiedReturnsTrue() {
		doReturn(Boolean.TRUE).when(rookMoveValidationService).isValidHorizontalOrVerticalMove(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(rookMoveValidationService).isPathBlockedVertical(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(rookMoveValidationService).isPathBlockedHorizontal(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(rookMoveValidationService).isDestinationOccupiedByAlly(any(), any(), any(), any());
		
		Boolean result = rookMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_ValidMovePathIsNotBlockedDestinationIsOccupiedReturnsFalse() {
		doReturn(Boolean.TRUE).when(rookMoveValidationService).isValidHorizontalOrVerticalMove(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(rookMoveValidationService).isPathBlockedVertical(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(rookMoveValidationService).isPathBlockedHorizontal(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(rookMoveValidationService).isDestinationOccupiedByAlly(any(), any(), any(), any());
		
		Boolean result = rookMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_ValidMovePathIsBlockedHorizontallyReturnsFalse() {
		doReturn(Boolean.TRUE).when(rookMoveValidationService).isValidHorizontalOrVerticalMove(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(rookMoveValidationService).isPathBlockedVertical(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(rookMoveValidationService).isPathBlockedHorizontal(any(), any(), any(), any());
		
		Boolean result = rookMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_ValidMovePathIsBlockedVerticallyReturnsFalse() {
		doReturn(Boolean.TRUE).when(rookMoveValidationService).isValidHorizontalOrVerticalMove(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(rookMoveValidationService).isPathBlockedVertical(any(), any(), any(), any());
		
		Boolean result = rookMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_InvalidMoveReturnsFalse() {
		doReturn(Boolean.FALSE).when(rookMoveValidationService).isValidHorizontalOrVerticalMove(any(), any(), any(), any());
		
		Boolean result = rookMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
}
