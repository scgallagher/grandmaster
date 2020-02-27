package com.scg.grandmaster.game.logic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.scg.grandmaster.game.domain.Color;
import com.scg.grandmaster.game.domain.Piece;

@RunWith(MockitoJUnitRunner.class)
public class PawnMoveValidationServiceTest {

	@Spy
	@InjectMocks
	PawnMoveValidationService pawnMoveValidationService;
	
	@Mock
	Board board;
	
	@Test
	public void isStartingPosition_WhiteStartingPositionReturnsTrue() {
		Boolean result = pawnMoveValidationService.isStartingPosition(1);
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isStartingPosition_BlackStartingPositionReturnsTrue() {
		Boolean result = pawnMoveValidationService.isStartingPosition(6);
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isStartingPosition_NotStartingPositionReturnsFalse() {
		Boolean result = pawnMoveValidationService.isStartingPosition(0);
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isPathBlocked_DestinationIsOccupiedReturnsTrue() {
		Integer desinationRow = 3;
		Integer desinationColumn = 0;
		
		when(board.getPieceAt(desinationRow, desinationColumn)).thenReturn(new Piece());
		
		Boolean result = pawnMoveValidationService.isPathBlocked(1, 0, desinationRow);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlocked_PathIsBlockedReturnsTrue() {
		Integer desinationRow = 3;
		Integer desinationColumn = 0;
		
		when(board.getPieceAt(2, desinationColumn)).thenReturn(new Piece());
		
		Boolean result = pawnMoveValidationService.isPathBlocked(1, 0, desinationRow);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlocked_PathIsNotBlockedReturnsFalse() {
		Integer desinationRow = 3;
		
		when(board.getPieceAt(any(), any())).thenReturn(null);
		
		Boolean result = pawnMoveValidationService.isPathBlocked(1, 0, desinationRow);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isBackwardsMove_WhitePieceMovesBackwardReturnsTrue() {
		Piece piece = new Piece();
		piece.setColor(Color.WHITE);
		when(board.getPieceAt(any(), any())).thenReturn(piece);
		
		Boolean result = pawnMoveValidationService.isBackwardMove(1, 0, 0);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isBackwardsMove_WhitePieceDoesNotMoveBackwardReturnsFalse() {
		Piece piece = new Piece();
		piece.setColor(Color.WHITE);
		when(board.getPieceAt(any(), any())).thenReturn(piece);
		
		Boolean result = pawnMoveValidationService.isBackwardMove(1, 0, 2);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isBackwardsMove_BlackPieceMovesBackwardReturnsTrue() {
		Piece piece = new Piece();
		piece.setColor(Color.BLACK);
		when(board.getPieceAt(any(), any())).thenReturn(piece);
		
		Boolean result = pawnMoveValidationService.isBackwardMove(6, 0, 7);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isBackwardsMove_BlackPieceDoesNotMoveBackwardReturnsFalse() {
		Piece piece = new Piece();
		piece.setColor(Color.BLACK);
		when(board.getPieceAt(any(), any())).thenReturn(piece);
		
		Boolean result = pawnMoveValidationService.isBackwardMove(6, 0, 5);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidVerticalPawnMove_BackwardMoveReturnsFalse() {
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isBackwardMove(any(), any(), any());

		Boolean result = pawnMoveValidationService.isValidVerticalPawnMove(1, 0, 0, 0);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidVerticalPawnMove_MoveMoreThanOneSpaceWhileNotInStartingPositionReturnsFalse() {
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isBackwardMove(any(), any(), any());
		
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isStartingPosition(any());

		Boolean result = pawnMoveValidationService.isValidVerticalPawnMove(2, 0, 4, 0);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidVerticalPawnMove_MoveMoreThanTwoSpacesFromStartingPositionReturnsFalse() {
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isBackwardMove(any(), any(), any());
		
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isStartingPosition(any());
		
		Boolean result = pawnMoveValidationService.isValidVerticalPawnMove(1, 0, 4, 0);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidVerticalPawnMove_MoveSingleSpaceReturnsTrue() {
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isBackwardMove(any(), any(), any());
		
		Boolean result = pawnMoveValidationService.isValidVerticalPawnMove(1, 0, 2, 0);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidVerticalPawnMove_MoveTwoSpacesFromStartingPositionReturnsTrue() {
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isBackwardMove(any(), any(), any());
		
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isStartingPosition(any());
		
		Boolean result = pawnMoveValidationService.isValidVerticalPawnMove(1, 0, 3, 0);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidVerticalPawnMove_DiagonalMoveReturnsFalse() {
		Boolean result = pawnMoveValidationService.isValidVerticalPawnMove(4, 4, 5, 5);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidDiagonalMoveForPawnCapture_InvalidDiagonalMoveReturnsFalse() {
		Boolean result = pawnMoveValidationService.isValidDiagonalMoveForPawnCapture(4, 4, 6, 6);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidDiagonalMoveForPawnCapture_ValidDiagonalMoveReturnsTrue() {
		Boolean result = pawnMoveValidationService.isValidDiagonalMoveForPawnCapture(4, 4, 5, 5);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidCapture_InavlidDiagonalMoveReturnsFalse() {
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isValidDiagonalMoveForPawnCapture(any(), any(), any(), any());
		
		Boolean result = pawnMoveValidationService.isValidCapture(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidCapture_AreAlliesReturnsFalse() {
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isValidDiagonalMoveForPawnCapture(any(), any(), any(), any());
		
		when(board.getPieceAt(any(), any())).thenReturn(null);
		
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isAlly(any(), any());
		
		Boolean result = pawnMoveValidationService.isValidCapture(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidCapture_ValidCaptureReturnsTrue() {
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isValidDiagonalMoveForPawnCapture(any(), any(), any(), any());
		
		when(board.getPieceAt(any(), any())).thenReturn(null);
		
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isAlly(any(), any());
		
		Boolean result = pawnMoveValidationService.isValidCapture(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_ValidVerticalMovePathIsNotBlockedReturnsTrue() {
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isValidVerticalPawnMove(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isPathBlocked(any(), any(), any());
		
		Boolean result = pawnMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_ValidVerticalMovePathIsBlockedReturnsFalse() {
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isValidVerticalPawnMove(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isPathBlocked(any(), any(), any());
		
		Boolean result = pawnMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_InvalidVerticalMoveValidCaptureReturnsTrue() {
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isValidVerticalPawnMove(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isValidCapture(any(), any(), any(), any());
		
		Boolean result = pawnMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidMove_InvalidVerticalMoveInvalidCaptureReturnsFalse() {
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isValidVerticalPawnMove(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isValidCapture(any(), any(), any(), any());
		
		Boolean result = pawnMoveValidationService.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
}
