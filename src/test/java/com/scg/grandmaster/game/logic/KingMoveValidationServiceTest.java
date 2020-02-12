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
public class KingMoveValidationServiceTest {

	@Spy
	@InjectMocks
	KingMoveValidationService kingMoveValidationService;
	
	@Mock
	Board board;
	
	@Test
	public void isValidMoveKing_ValidVerticalMoveReturnsTrue() {
		Boolean result = kingMoveValidationService.isValidMoveKing(4, 4, 5, 4);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMoveKing_ValidHorizontalMoveReturnsTrue() {
		Boolean result = kingMoveValidationService.isValidMoveKing(4, 4, 4, 5);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMoveKing_InvalidMoveReturnsFalse() {
		Boolean result = kingMoveValidationService.isValidMoveKing(4, 4, 5, 5);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_ValidMoveDestinationIsNotOccupiedReturnsTrue() {
		doReturn(Boolean.TRUE).when(kingMoveValidationService).isValidMoveKing(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(kingMoveValidationService).isDestinationOccupiedByAlly(any(), any(), any(), any());
		
		Boolean result = kingMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_ValidMoveDestinationIsOccupiedReturnsFalse() {
		doReturn(Boolean.TRUE).when(kingMoveValidationService).isValidMoveKing(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(kingMoveValidationService).isDestinationOccupiedByAlly(any(), any(), any(), any());
		
		Boolean result = kingMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_InvalidMoveReturnsFalse() {
		doReturn(Boolean.FALSE).when(kingMoveValidationService).isValidMoveKing(any(), any(), any(), any());
		
		Boolean result = kingMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
}
