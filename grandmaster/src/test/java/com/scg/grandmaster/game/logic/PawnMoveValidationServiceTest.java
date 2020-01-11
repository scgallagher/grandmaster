package com.scg.grandmaster.game.logic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
	public void isValidVerticalMove_BackwardMoveReturnsFalse() {
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isBackwardMove(any(), any(), any());

		Boolean result = pawnMoveValidationService.isValidVerticalMove(1, 0, 0, 0);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidVerticalMove_MoveMoreThanOneSpaceWhileNotInStartingPositionReturnsFalse() {
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isBackwardMove(any(), any(), any());
		
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isStartingPosition(any());

		Boolean result = pawnMoveValidationService.isValidVerticalMove(2, 0, 4, 0);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidVerticalMove_MoveMoreThanTwoSpacesFromStartingPositionReturnsFalse() {
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isBackwardMove(any(), any(), any());
		
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isStartingPosition(any());
		
		Boolean result = pawnMoveValidationService.isValidVerticalMove(1, 0, 4, 0);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidVerticalMove_MoveSingleSpaceReturnsTrue() {
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isBackwardMove(any(), any(), any());
		
		Boolean result = pawnMoveValidationService.isValidVerticalMove(1, 0, 2, 0);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidVerticalMove_MoveTwoSpacesFromStartingPositionReturnsTrue() {
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isBackwardMove(any(), any(), any());
		
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isStartingPosition(any());
		
		Boolean result = pawnMoveValidationService.isValidVerticalMove(1, 0, 3, 0);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidVerticalMove_DiagonalMoveReturnsFalse() {
		Boolean result = pawnMoveValidationService.isValidVerticalMove(4, 4, 5, 5);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidDiagonalMove_BackwardDiagonalMoveReturnsFalse() {
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isBackwardMove(any(), any(), any());
		
		Boolean result = pawnMoveValidationService.isValidDiagonalMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidDiagonalMove_InvalidDiagonalMoveReturnsFalse() {
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isBackwardMove(any(), any(), any());
		
		Boolean result = pawnMoveValidationService.isValidDiagonalMove(4, 4, 6, 6);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidDiagonalMove_ValidDiagonalMoveReturnsTrue() {
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isBackwardMove(any(), any(), any());
		
		Boolean result = pawnMoveValidationService.isValidDiagonalMove(4, 4, 5, 5);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void areOpponenets_PiecesAreNotOpponentsReturnsFalse() {
		Piece pieceOne = new Piece();
		pieceOne.setColor(Color.WHITE);
		
		Piece pieceTwo = new Piece();
		pieceTwo.setColor(Color.WHITE);
		
		Boolean result = pawnMoveValidationService.areOpponents(pieceOne, pieceTwo);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void areOpponenets_PiecesAreOpponentsReturnsTrue() {
		Piece pieceOne = new Piece();
		pieceOne.setColor(Color.WHITE);
		
		Piece pieceTwo = new Piece();
		pieceTwo.setColor(Color.BLACK);
		
		Boolean result = pawnMoveValidationService.areOpponents(pieceOne, pieceTwo);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidCapture_InavlidDiagonalMoveReturnsFalse() {
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isValidDiagonalMove(any(), any(), any(), any());
		
		Boolean result = pawnMoveValidationService.isValidCapture(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidCapture_AreNotOpponentsReturnsFalse() {
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isValidDiagonalMove(any(), any(), any(), any());
		
		when(board.getPieceAt(any(), any())).thenReturn(null);
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).areOpponents(any(), any());
		
		Boolean result = pawnMoveValidationService.isValidCapture(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidCapture_ValidCaptureReturnsTrue() {
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isValidDiagonalMove(any(), any(), any(), any());
		
		when(board.getPieceAt(any(), any())).thenReturn(null);
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).areOpponents(any(), any());
		
		Boolean result = pawnMoveValidationService.isValidCapture(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void validateMove_validVerticalMoveSuccess() {
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isValidVerticalMove(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isPathBlocked(any(), any(), any());
		
		pawnMoveValidationService.validateMove(null, null, null, null);
	}
	
	@Test
	public void validateMove_PathBlockedThrowsException() {
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isValidVerticalMove(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isPathBlocked(any(), any(), any());
		
		assertThatThrownBy(() -> pawnMoveValidationService.validateMove(null, null, null, null)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_validDiagonalMoveSuccess() {
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isValidVerticalMove(any(), any(), any(), any());
		
		doReturn(Boolean.TRUE).when(pawnMoveValidationService).isValidCapture(any(), any(), any(), any());
		
		pawnMoveValidationService.validateMove(null, null, null, null);
	}
	
	@Test
	public void validateMove_invalidMoveThrowsException() {
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isValidVerticalMove(any(), any(), any(), any());
		
		doReturn(Boolean.FALSE).when(pawnMoveValidationService).isValidCapture(any(), any(), any(), any());
		
		assertThatThrownBy(() -> pawnMoveValidationService.validateMove(null, null, null, null)).isInstanceOf(IllegalMoveException.class);
	}
}
