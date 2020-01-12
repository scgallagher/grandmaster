package com.scg.grandmaster.game.logic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.scg.grandmaster.exception.IllegalMoveException;
import com.scg.grandmaster.game.entity.Piece;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CommonLogic.class)
public class KnightMoveValidationServiceTest {

	@InjectMocks
	KnightMoveValidationService knightMoveValidationService;
	
	@Mock
	Board board;
	
	KnightMoveValidationService spiedKnightMoveValidationService;
	
	@Before
	public void setup() {
		PowerMockito.mockStatic(CommonLogic.class);
		spiedKnightMoveValidationService = PowerMockito.spy(knightMoveValidationService);
	}
	
	@Test
	public void isPathBlocked_DestinationIsOccupiedByAllyReturnsTrue() throws Exception {
		when(board.getPieceAt(any(), any())).thenReturn(new Piece());
		PowerMockito.when(CommonLogic.isAlly(any(), any())).thenReturn(Boolean.TRUE);
		
		Boolean result = knightMoveValidationService.isPathBlocked(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlocked_DestinationIsOccupiedByOpponentReturnsFalse() throws Exception {
		when(board.getPieceAt(any(), any())).thenReturn(new Piece());
		PowerMockito.when(CommonLogic.isAlly(any(), any())).thenReturn(Boolean.FALSE);
		
		Boolean result = knightMoveValidationService.isPathBlocked(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isPathBlocked_DestinationIsNotUnoccupiedReturnsTrue() throws Exception {
		when(board.getPieceAt(any(), any())).thenReturn(null);
		
		Boolean result = knightMoveValidationService.isPathBlocked(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_MoveUpTwoRightOneReturnsTrue() {
		Boolean result = knightMoveValidationService.isValidMove(4, 4, 2, 5);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_MoveUpTwoLeftOneReturnsTrue() {
		Boolean result = knightMoveValidationService.isValidMove(4, 4, 2, 3);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_DownTwoLeftOneReturnsTrue() {
		Boolean result = knightMoveValidationService.isValidMove(4, 4, 6, 3);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_MoveDownTwoRightOneReturnsTrue() {
		Boolean result = knightMoveValidationService.isValidMove(4, 4, 6, 5);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_MoveUpOneRightTwoReturnsTrue() {
		Boolean result = knightMoveValidationService.isValidMove(4, 4, 3, 6);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_MoveUpOneLeftTwoReturnsTrue() {
		Boolean result = knightMoveValidationService.isValidMove(4, 4, 3, 2);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_MoveDownOneLeftTwoReturnsTrue() {
		Boolean result = knightMoveValidationService.isValidMove(4, 4, 5, 2);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_MoveDownOneRightTwoReturnsTrue() {
		Boolean result = knightMoveValidationService.isValidMove(4, 4, 5, 6);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_OneSpaceDiagonalMoveReturnsFalse() {
		Boolean result = knightMoveValidationService.isValidMove(4, 4, 5, 5);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_TwoSpaceDiagonalMoveReturnsFalse() {
		Boolean result = knightMoveValidationService.isValidMove(4, 4, 6, 6);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void validateMove_ValidVerticalOrHorizontalMoveSuccess() {
		doReturn(Boolean.TRUE).when(spiedKnightMoveValidationService).isValidMove(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(spiedKnightMoveValidationService).isPathBlocked(any(), any(), any(), any());
		
		spiedKnightMoveValidationService.validateMove(null, null, null, null);
	}
	
	@Test
	public void validateMove_BlockedPathThrowsException() {
		doReturn(Boolean.TRUE).when(spiedKnightMoveValidationService).isValidMove(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(spiedKnightMoveValidationService).isPathBlocked(any(), any(), any(), any());
		
		assertThatThrownBy(() -> spiedKnightMoveValidationService.validateMove(null, null, null, null)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_DiagonalPathThrowsException() {
		doReturn(Boolean.FALSE).when(spiedKnightMoveValidationService).isValidMove(any(), any(), any(), any());
		
		assertThatThrownBy(() -> spiedKnightMoveValidationService.validateMove(null, null, null, null)).isInstanceOf(IllegalMoveException.class);
	}
	
}
