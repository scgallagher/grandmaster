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

import com.scg.grandmaster.controller.GlobalExceptionHandler.IllegalMoveException;
import com.scg.grandmaster.game.domain.Color;
import com.scg.grandmaster.game.domain.Piece;

@RunWith(MockitoJUnitRunner.class)
public class MoveValidationServiceBaseTest {

	@Spy
	@InjectMocks
	MoveValidationServiceBase moveValidationServiceBase;
	
	@Mock
	Board board;
	
	@Test
	public void isAlly_AllyPiecesReturnsTrue() {
		Piece piece = new Piece();
		piece.setColor(Color.WHITE);
		
		Boolean result = moveValidationServiceBase.isAlly(piece, piece);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isAlly_NonAllyPiecesReturnsFalse() {
		Piece whitePiece = new Piece();
		whitePiece.setColor(Color.WHITE);
		
		Piece blackPiece = new Piece();
		blackPiece.setColor(Color.BLACK);
		
		Boolean result = moveValidationServiceBase.isAlly(whitePiece, blackPiece);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isOpponent_OpponentPiecesReturnsTrue() {
		doReturn(Boolean.FALSE).when(moveValidationServiceBase).isAlly(any(), any());
		
		Boolean result = moveValidationServiceBase.isOpponent(null, null);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isOpponent_AllyPiecesReturnsFalse() {
		doReturn(Boolean.TRUE).when(moveValidationServiceBase).isAlly(any(), any());
		
		Boolean result = moveValidationServiceBase.isOpponent(null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isCapture_DestinationIsUnoccupiedReturnsFalse() {
		when(board.getPieceAt(any(), any())).thenReturn(null);
		
		Boolean result = moveValidationServiceBase.isCapture(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isCapture_DestinationIsOccupiedByAllyReturnsFalse() {
		when(board.getPieceAt(any(), any())).thenReturn(new Piece());
		
		doReturn(Boolean.TRUE).when(moveValidationServiceBase).isAlly(any(), any());
		
		Boolean result = moveValidationServiceBase.isCapture(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isCapture_DestinationIsOccupiedByOpponentReturnsTrue() {
		when(board.getPieceAt(any(), any())).thenReturn(new Piece());
		
		doReturn(Boolean.FALSE).when(moveValidationServiceBase).isAlly(any(), any());
		
		Boolean result = moveValidationServiceBase.isCapture(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isDestinationOccupiedByAlly_DestinationIsNotOccupiedReturnsFalse() {
		when(board.getPieceAt(any(), any())).thenReturn(null);
		
		Boolean result = moveValidationServiceBase.isDestinationOccupiedByAlly(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isDestinationOccupiedByAlly_DestinationIsOccupiedByOpponenReturnsFalset() {
		when(board.getPieceAt(any(), any())).thenReturn(new Piece());
		
		doReturn(Boolean.FALSE).when(moveValidationServiceBase).isAlly(any(), any());
		
		Boolean result = moveValidationServiceBase.isDestinationOccupiedByAlly(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isDestinationOccupiedByAlly_DestinationIsOccupiedByAllyReturnsTrue() {
		when(board.getPieceAt(any(), any())).thenReturn(new Piece());
		
		doReturn(Boolean.TRUE).when(moveValidationServiceBase).isAlly(any(), any());
		
		Boolean result = moveValidationServiceBase.isDestinationOccupiedByAlly(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlockedDiagonal_DownRightPathIsBlockedByAllyReturnsTrue() {
		Integer occupiedRow = 5;
		Integer occupiedColumn = 5;
		
		when(board.getPieceAt(occupiedRow, occupiedColumn)).thenReturn(new Piece());
		
		Boolean result = moveValidationServiceBase.isPathBlockedDiagonal(4, 4, 6, 6);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlockedDiagonal_DownRightPathIsNotBlockedReturnsFalse() {
		when(board.getPieceAt(any(), any())).thenReturn(null);
		
		Boolean result = moveValidationServiceBase.isPathBlockedDiagonal(4, 4, 6, 6);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isPathBlockedDiagonal_DownLeftPathIsBlockedByAllyReturnsTrue() {
		Integer occupiedRow = 5;
		Integer occupiedColumn = 3;
		
		when(board.getPieceAt(occupiedRow, occupiedColumn)).thenReturn(new Piece());
		
		Boolean result = moveValidationServiceBase.isPathBlockedDiagonal(4, 4, 6, 2);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlockedDiagonal_DownLeftPathIsNotBlockedReturnsFalse() {
		when(board.getPieceAt(any(), any())).thenReturn(null);
		
		Boolean result = moveValidationServiceBase.isPathBlockedDiagonal(4, 4, 6, 2);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isPathBlockedDiagonal_UpLeftPathIsBlockedByAllyReturnsTrue() {
		Integer occupiedRow = 3;
		Integer occupiedColumn = 3;
		
		when(board.getPieceAt(occupiedRow, occupiedColumn)).thenReturn(new Piece());
		
		Boolean result = moveValidationServiceBase.isPathBlockedDiagonal(4, 4, 2, 2);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlockedDiagonal_UpLeftPathIsNotBlockedReturnsFalse() {
		when(board.getPieceAt(any(), any())).thenReturn(null);
		
		Boolean result = moveValidationServiceBase.isPathBlockedDiagonal(4, 4, 2, 2);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isPathBlockedDiagonal_UpRightPathIsBlockedByAllyReturnsTrue() {
		Integer occupiedRow = 3;
		Integer occupiedColumn = 5;
		
		when(board.getPieceAt(occupiedRow, occupiedColumn)).thenReturn(new Piece());
		
		Boolean result = moveValidationServiceBase.isPathBlockedDiagonal(4, 4, 2, 6);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlockedDiagonal_UpRightPathIsNotBlockedReturnsFalse() {
		when(board.getPieceAt(any(), any())).thenReturn(null);
		
		Boolean result = moveValidationServiceBase.isPathBlockedDiagonal(4, 4, 2, 6);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isPathBlockedVertical_DownwardPathIsBlockedReturnsTrue() {
		Integer destinationRow = 3;
		Integer destinationColumn = 0;
		Integer obstructionRow = 2;
		
		when(board.getPieceAt(obstructionRow, destinationColumn)).thenReturn(new Piece());
		
		Boolean result = moveValidationServiceBase.isPathBlockedVertical(0, 0, destinationRow, destinationColumn);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlockedVertical_UpwardPathIsBlockedReturnsTrue() {
		Integer destinationRow = 0;
		Integer destinationColumn = 0;
		Integer obstructionRow = 2;
		
		when(board.getPieceAt(obstructionRow, destinationColumn)).thenReturn(new Piece());
		
		Boolean result = moveValidationServiceBase.isPathBlockedVertical(3, 0, destinationRow, destinationColumn);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlockedVertical_PathIsNotBlockedReturnsFalse() {
		when(board.getPieceAt(any(), any())).thenReturn(null);
		
		Boolean result = moveValidationServiceBase.isPathBlockedVertical(3, 0, 1, 0);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isPathBlockedHorizontal_RightwardPathIsBlockedReturnsTrue() {
		Integer destinationRow = 0;
		Integer destinationColumn = 3;
		Integer obstructionColumn = 2;
		
		when(board.getPieceAt(destinationRow, obstructionColumn)).thenReturn(new Piece());
		
		Boolean result = moveValidationServiceBase.isPathBlockedHorizontal(0, 0, destinationRow, destinationColumn);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlockedHorizontal_LeftwardPathIsBlockedReturnsTrue() {
		Integer destinationRow = 0;
		Integer destinationColumn = 0;
		Integer obstructionColumn = 2;
		
		when(board.getPieceAt(destinationRow, obstructionColumn)).thenReturn(new Piece());
		
		Boolean result = moveValidationServiceBase.isPathBlockedHorizontal(0, 3, destinationRow, destinationColumn);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isPathBlocked_PathIsNotBlockedReturnsFalse() {
		when(board.getPieceAt(any(), any())).thenReturn(null);
		
		Boolean result = moveValidationServiceBase.isPathBlockedHorizontal(0, 3, 0, 0);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidDiagonalMove_DownRightDiagonalReturnsTrue() {
		Boolean result = moveValidationServiceBase.isValidDiagonalMove(4, 4, 6, 6);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidDiagonalMove_DownLeftDiagonalReturnsTrue() {
		Boolean result = moveValidationServiceBase.isValidDiagonalMove(4, 4, 6, 2);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidDiagonalMove_UpLeftDiagonalReturnsTrue() {
		Boolean result = moveValidationServiceBase.isValidDiagonalMove(4, 4, 2, 2);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidDiagonalMove_UpRightDiagonalReturnsTrue() {
		Boolean result = moveValidationServiceBase.isValidDiagonalMove(4, 4, 2, 6);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidDiagonalMove_UpStraightReturnsFalse() {
		Boolean result = moveValidationServiceBase.isValidDiagonalMove(4, 4, 2, 4);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidHorizontalMove_ValidHorizontalMoveReturnsTrue() {
		Boolean result = moveValidationServiceBase.isValidHorizontalMove(0, 0);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidHorizontalMove_InvalidHorizontalMoveReturnsFalse() {
		Boolean result = moveValidationServiceBase.isValidHorizontalMove(0, 1);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidVerticalMove_ValidVerticalMoveReturnsTrue() {
		Boolean result = moveValidationServiceBase.isValidVerticalMove(0, 0);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValidVerticalMove_InvalidVerticalMoveReturnsFalse() {
		Boolean result = moveValidationServiceBase.isValidVerticalMove(0, 1);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isValidMove_ReturnsFalse() {
		Boolean result = moveValidationServiceBase.isValidMove(null, null, null, null);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void validateMove_ValidMoveSuccess() {
		doReturn(Boolean.TRUE).when(moveValidationServiceBase).isValidMove(any(), any(), any(), any());
		
		moveValidationServiceBase.validateMove(null, null, null, null, null);
	}
	
	@Test
	public void validateMove_InvalidMoveThrowsException() {
		doReturn(Boolean.FALSE).when(moveValidationServiceBase).isValidMove(any(), any(), any(), any());
		
		assertThatThrownBy(() -> moveValidationServiceBase.validateMove(null, null, null, null, null)).isInstanceOf(IllegalMoveException.class);
	}
	
}
