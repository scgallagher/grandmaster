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
public class KnightMoveValidationServiceTest {

	@Spy
	@InjectMocks
	KnightMoveValidationService knightMoveValidationService;
	
	@Mock
	Board board;
	
	@Test
	public void isValidMoveKnight_MoveUpTwoRightOneReturnsTrue() {
		Boolean result = knightMoveValidationService.isValidMoveKnight(4, 4, 2, 5);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMoveKnight_MoveUpTwoLeftOneReturnsTrue() {
		Boolean result = knightMoveValidationService.isValidMoveKnight(4, 4, 2, 3);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMoveKnight_DownTwoLeftOneReturnsTrue() {
		Boolean result = knightMoveValidationService.isValidMoveKnight(4, 4, 6, 3);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMoveKnight_MoveDownTwoRightOneReturnsTrue() {
		Boolean result = knightMoveValidationService.isValidMoveKnight(4, 4, 6, 5);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMoveKnight_MoveUpOneRightTwoReturnsTrue() {
		Boolean result = knightMoveValidationService.isValidMoveKnight(4, 4, 3, 6);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMoveKnight_MoveUpOneLeftTwoReturnsTrue() {
		Boolean result = knightMoveValidationService.isValidMoveKnight(4, 4, 3, 2);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMoveKnight_MoveDownOneLeftTwoReturnsTrue() {
		Boolean result = knightMoveValidationService.isValidMoveKnight(4, 4, 5, 2);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMoveKnight_MoveDownOneRightTwoReturnsTrue() {
		Boolean result = knightMoveValidationService.isValidMoveKnight(4, 4, 5, 6);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMoveKnight_OneSpaceDiagonalMoveReturnsFalse() {
		Boolean result = knightMoveValidationService.isValidMoveKnight(4, 4, 5, 5);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMoveKnight_TwoSpaceDiagonalMoveReturnsFalse() {
		Boolean result = knightMoveValidationService.isValidMoveKnight(4, 4, 6, 6);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_ValidMoveDestinationIsNotOccupiedReturnsTrue() {
		doReturn(Boolean.TRUE).when(knightMoveValidationService).isValidMoveKnight(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(knightMoveValidationService).isDestinationOccupiedByAlly(any(), any(), any(), any());
		
		Boolean result = knightMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_ValidMoveDestinationIsOccupiedReturnsFalse() {
		doReturn(Boolean.TRUE).when(knightMoveValidationService).isValidMoveKnight(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(knightMoveValidationService).isDestinationOccupiedByAlly(any(), any(), any(), any());
		
		Boolean result = knightMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_InvalidMoveReturnsFalse() {
		doReturn(Boolean.FALSE).when(knightMoveValidationService).isValidMoveKnight(any(), any(), any(), any());
		
		Boolean result = knightMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
}
