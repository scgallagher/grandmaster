package com.scg.grandmaster.game.logic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.scg.grandmaster.exception.IllegalMoveException;
import com.scg.grandmaster.game.entity.Color;
import com.scg.grandmaster.game.entity.Piece;

@RunWith(MockitoJUnitRunner.class)
public class RookMoveValidationServiceTest {
	
	@Spy
	@InjectMocks
	RookMoveValidationService rookMoveValidationService;
	
	@Mock
	Board board;

	@Test
	public void areOpponenets_PiecesAreNotOpponentsReturnsFalse() {
		Piece pieceOne = new Piece();
		pieceOne.setColor(Color.WHITE);
		
		Piece pieceTwo = new Piece();
		pieceTwo.setColor(Color.WHITE);
		
		Boolean result = rookMoveValidationService.areOpponents(pieceOne, pieceTwo);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void areOpponenets_PiecesAreOpponentsReturnsTrue() {
		Piece pieceOne = new Piece();
		pieceOne.setColor(Color.WHITE);
		
		Piece pieceTwo = new Piece();
		pieceTwo.setColor(Color.BLACK);
		
		Boolean result = rookMoveValidationService.areOpponents(pieceOne, pieceTwo);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlocked_DownVerticalPathIsBlockedReturnsTrue() {
		Integer destinationRow = 3;
		Integer destinationColumn = 0;
		Integer obstructionRow = 2;
		
		when(board.getPieceAt(obstructionRow, destinationColumn)).thenReturn(new Piece());
		
		doReturn(Boolean.FALSE).when(rookMoveValidationService).areOpponents(any(), any());
		
		Boolean result = rookMoveValidationService.isPathBlocked(0, 0, destinationRow, destinationColumn);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlocked_UpwVerticalPathIsBlockedReturnsTrue() {
		Integer destinationRow = 0;
		Integer destinationColumn = 0;
		Integer obstructionRow = 2;
		
		when(board.getPieceAt(obstructionRow, destinationColumn)).thenReturn(new Piece());
		
		doReturn(Boolean.FALSE).when(rookMoveValidationService).areOpponents(any(), any());
		
		Boolean result = rookMoveValidationService.isPathBlocked(3, 0, destinationRow, destinationColumn);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlocked_RightHorizontalPathIsBlockedReturnsTrue() {
		Integer destinationRow = 0;
		Integer destinationColumn = 3;
		Integer obstructionColumn = 2;
		
		when(board.getPieceAt(destinationRow, obstructionColumn)).thenReturn(new Piece());
		
		doReturn(Boolean.FALSE).when(rookMoveValidationService).areOpponents(any(), any());
		
		Boolean result = rookMoveValidationService.isPathBlocked(0, 0, destinationRow, destinationColumn);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlocked_LeftHorizontalPathIsBlockedReturnsTrue() {
		Integer destinationRow = 0;
		Integer destinationColumn = 0;
		Integer obstructionColumn = 2;
		
		when(board.getPieceAt(destinationRow, obstructionColumn)).thenReturn(new Piece());
		
		doReturn(Boolean.FALSE).when(rookMoveValidationService).areOpponents(any(), any());
		
		Boolean result = rookMoveValidationService.isPathBlocked(0, 3, destinationRow, destinationColumn);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlocked_PathIsNotBlockedHorizontallyReturnsTrue() {
		when(board.getPieceAt(any(), any())).thenReturn(null);
		
		Boolean result = rookMoveValidationService.isPathBlocked(0, 3, 0, 0);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidVerticalOrHorizontalMove_ValidVerticalMoveReturnsTrue() {
		Boolean result = rookMoveValidationService.isValidVerticalOrHorizontalMove(0, 0, 3, 0);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidVerticalOrHorizontalMove_ValidHorizontalMoveReturnsTrue() {
		Boolean result = rookMoveValidationService.isValidVerticalOrHorizontalMove(0, 0, 0, 3);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidVerticalOrHorizontalMove_NotValidVerticalOrHorizontalMoveReturnsFalse() {
		Boolean result = rookMoveValidationService.isValidVerticalOrHorizontalMove(0, 0, 3, 3);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void validateMove_ValidVerticalOrHorizontalMoveSuccess() {
		doReturn(Boolean.TRUE).when(rookMoveValidationService).isValidVerticalOrHorizontalMove(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(rookMoveValidationService).isPathBlocked(any(), any(), any(), any());
		
		rookMoveValidationService.validateMove(null, null, null, null);
	}
	
	@Test
	public void validateMove_BlockedPathThrowsException() {
		doReturn(Boolean.TRUE).when(rookMoveValidationService).isValidVerticalOrHorizontalMove(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(rookMoveValidationService).isPathBlocked(any(), any(), any(), any());
		
		assertThatThrownBy(() -> rookMoveValidationService.validateMove(null, null, null, null)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_DiagonalPathThrowsException() {
		doReturn(Boolean.FALSE).when(rookMoveValidationService).isValidVerticalOrHorizontalMove(any(), any(), any(), any());
		
		assertThatThrownBy(() -> rookMoveValidationService.validateMove(null, null, null, null)).isInstanceOf(IllegalMoveException.class);
	}
	
}
