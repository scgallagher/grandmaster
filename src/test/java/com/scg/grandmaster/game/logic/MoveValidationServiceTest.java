package com.scg.grandmaster.game.logic;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.scg.grandmaster.controller.GlobalExceptionHandler.IllegalMoveException;
import com.scg.grandmaster.game.domain.Piece;
import com.scg.grandmaster.game.domain.PieceType;

@RunWith(MockitoJUnitRunner.class)
public class MoveValidationServiceTest {

	@Spy
	@InjectMocks
	MoveValidationService moveValidationService;
	
	@Mock
	Board board;
	
	@Mock
	PawnMoveValidationService pawnMoveValidationService;
	
	@Mock
	RookMoveValidationService rookMoveValidationService;
	
	@Mock
	KnightMoveValidationService knightMoveValidationService;
	
	@Mock
	BishopMoveValidationService bishopMoveValidationService;
	
	@Mock
	QueenMoveValidationService queenMoveValidationService;
	
	@Mock
	KingMoveValidationService kingMoveValidationService;
	
	@Test
	public void isValueOutOfBounds_NegativeValueReturnsTrue() {
		Boolean result = moveValidationService.isValueOutOfBounds(-1);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValueOutOfBounds_ValueExceedingUpperBoundReturnsTrue() {
		Boolean result = moveValidationService.isValueOutOfBounds(8);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isValueOutOfBounds_ValueWithinBoundsReturnsFalse() {
		Boolean result = moveValidationService.isValueOutOfBounds(4);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void validateMove_SourceRowOutOfBoundsThrowsException() {
		Integer outOfBoundsValue = -1;
		
		doReturn(Boolean.TRUE).when(moveValidationService).isValueOutOfBounds(outOfBoundsValue);
		
		assertThatThrownBy(() -> moveValidationService.validateMove(null, outOfBoundsValue, null, null, null)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_SourceColumnOutOfBoundsThrowsException() {
		Integer inBoundsValue = 0;
		Integer outOfBoundsValue = -1;
		
		doReturn(Boolean.FALSE).when(moveValidationService).isValueOutOfBounds(inBoundsValue);
		doReturn(Boolean.TRUE).when(moveValidationService).isValueOutOfBounds(outOfBoundsValue);
		
		assertThatThrownBy(() -> moveValidationService.validateMove(null, inBoundsValue, outOfBoundsValue, null, null)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_DestinationRowOutOfBoundsThrowsException() {
		Integer inBoundsValue = 0;
		Integer outOfBoundsValue = -1;
		
		doReturn(Boolean.FALSE).when(moveValidationService).isValueOutOfBounds(inBoundsValue);
		doReturn(Boolean.TRUE).when(moveValidationService).isValueOutOfBounds(outOfBoundsValue);
		
		assertThatThrownBy(() -> moveValidationService.validateMove(null, inBoundsValue, inBoundsValue, outOfBoundsValue, null)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_DestinationColumnOutOfBoundsThrowsException() {
		Integer inBoundsValue = 0;
		Integer outOfBoundsValue = -1;
		
		doReturn(Boolean.FALSE).when(moveValidationService).isValueOutOfBounds(inBoundsValue);
		doReturn(Boolean.TRUE).when(moveValidationService).isValueOutOfBounds(outOfBoundsValue);
		
		assertThatThrownBy(() -> moveValidationService.validateMove(null, inBoundsValue, inBoundsValue, inBoundsValue, outOfBoundsValue)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_InvalidMoveForPawnThrowsException() {
		Piece pawn = new Piece();
		pawn.setPieceType(PieceType.PAWN);
		
		Board board = mock(Board.class);
		
		doReturn(board).when(moveValidationService).createBoardFromGameState(any());
		
		doReturn(pawn).when(board).getPieceAt(any(), any());
		
		doThrow(new IllegalMoveException("")).when(pawnMoveValidationService).validateMove(any(), any(), any(), any(), any());
		
		assertThatThrownBy(() -> moveValidationService.validateMove(null, 0, 0, 0, 0)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_ValidMoveForPawnCompletesSuccessfully() {
		Piece pawn = new Piece();
		pawn.setPieceType(PieceType.PAWN);
		
		Board board = mock(Board.class);
		
		doReturn(board).when(moveValidationService).createBoardFromGameState(any());
		
		doReturn(pawn).when(board).getPieceAt(any(), any());
		
		doNothing().when(pawnMoveValidationService).validateMove(any(), any(), any(), any(), any());
		
		moveValidationService.validateMove(null, 0, 0, 0, 0);
		
		verify(pawnMoveValidationService).validateMove(any(), any(), any(), any(), any());
	}
	
	@Test
	public void validateMove_InvalidMoveForRookThrowsException() {
		Piece rook = new Piece();
		rook.setPieceType(PieceType.ROOK);
		
		Board board = mock(Board.class);
		
		doReturn(board).when(moveValidationService).createBoardFromGameState(any());
		
		doReturn(rook).when(board).getPieceAt(any(), any());
		
		doThrow(new IllegalMoveException("")).when(rookMoveValidationService).validateMove(any(), any(), any(), any(), any());
		
		assertThatThrownBy(() -> moveValidationService.validateMove(null, 0, 0, 0, 0)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_ValidMoveForRookCompletesSuccessfully() {
		Piece rook = new Piece();
		rook.setPieceType(PieceType.ROOK);
		
		Board board = mock(Board.class);
		
		doReturn(board).when(moveValidationService).createBoardFromGameState(any());
		
		doReturn(rook).when(board).getPieceAt(any(), any());
		
		doNothing().when(rookMoveValidationService).validateMove(any(), any(), any(), any(), any());
		
		moveValidationService.validateMove(null, 0, 0, 0, 0);
		
		verify(rookMoveValidationService).validateMove(any(), any(), any(), any(), any());
	}
	
	@Test
	public void validateMove_InvalidMoveForKnightThrowsException() {
		Piece knight = new Piece();
		knight.setPieceType(PieceType.KNIGHT);
		
		Board board = mock(Board.class);
		
		doReturn(board).when(moveValidationService).createBoardFromGameState(any());
		
		doReturn(knight).when(board).getPieceAt(any(), any());
		
		doThrow(new IllegalMoveException("")).when(knightMoveValidationService).validateMove(any(), any(), any(), any(), any());
		
		assertThatThrownBy(() -> moveValidationService.validateMove(null, 0, 0, 0, 0)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_ValidMoveForKnightCompletesSuccessfully() {
		Piece knight = new Piece();
		knight.setPieceType(PieceType.KNIGHT);
		
		Board board = mock(Board.class);
		
		doReturn(board).when(moveValidationService).createBoardFromGameState(any());
		
		doReturn(knight).when(board).getPieceAt(any(), any());
		
		doNothing().when(knightMoveValidationService).validateMove(any(), any(), any(), any(), any());
		
		moveValidationService.validateMove(null, 0, 0, 0, 0);
		
		verify(knightMoveValidationService).validateMove(any(), any(), any(), any(), any());
	}
	
	@Test
	public void validateMove_InvalidMoveForBishopThrowsException() {
		Piece bishop = new Piece();
		bishop.setPieceType(PieceType.BISHOP);
		
		Board board = mock(Board.class);
		
		doReturn(board).when(moveValidationService).createBoardFromGameState(any());
		
		doReturn(bishop).when(board).getPieceAt(any(), any());
		
		doThrow(new IllegalMoveException("")).when(bishopMoveValidationService).validateMove(any(), any(), any(), any(), any());
		
		assertThatThrownBy(() -> moveValidationService.validateMove(null, 0, 0, 0, 0)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_ValidMoveForBishopCompletesSuccessfully() {
		Piece bishop = new Piece();
		bishop.setPieceType(PieceType.BISHOP);
		
		Board board = mock(Board.class);
		
		doReturn(board).when(moveValidationService).createBoardFromGameState(any());
		
		doReturn(bishop).when(board).getPieceAt(any(), any());
		
		doNothing().when(bishopMoveValidationService).validateMove(any(), any(), any(), any(), any());
		
		moveValidationService.validateMove(null, 0, 0, 0, 0);
		
		verify(bishopMoveValidationService).validateMove(any(), any(), any(), any(), any());
	}
	
	@Test
	public void validateMove_InvalidMoveForQueenThrowsException() {
		Piece queen = new Piece();
		queen.setPieceType(PieceType.QUEEN);
		
		Board board = mock(Board.class);
		
		doReturn(board).when(moveValidationService).createBoardFromGameState(any());
		
		doReturn(queen).when(board).getPieceAt(any(), any());
		
		doThrow(new IllegalMoveException("")).when(queenMoveValidationService).validateMove(any(), any(), any(), any(), any());
		
		assertThatThrownBy(() -> moveValidationService.validateMove(null, 0, 0, 0, 0)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_ValidMoveForQueenCompletesSuccessfully() {
		Piece queen = new Piece();
		queen.setPieceType(PieceType.QUEEN);
		
		Board board = mock(Board.class);
		
		doReturn(board).when(moveValidationService).createBoardFromGameState(any());
		
		doReturn(queen).when(board).getPieceAt(any(), any());
		
		doNothing().when(queenMoveValidationService).validateMove(any(), any(), any(), any(), any());
		
		moveValidationService.validateMove(null, 0, 0, 0, 0);
		
		verify(queenMoveValidationService).validateMove(any(), any(), any(), any(), any());
	}
	
	@Test
	public void validateMove_InvalidMoveForKingThrowsException() {
		Piece king = new Piece();
		king.setPieceType(PieceType.KING);
		
		Board board = mock(Board.class);
		
		doReturn(board).when(moveValidationService).createBoardFromGameState(any());
		
		doReturn(king).when(board).getPieceAt(any(), any());
		
		doThrow(new IllegalMoveException("")).when(kingMoveValidationService).validateMove(any(), any(), any(), any(), any());
		
		assertThatThrownBy(() -> moveValidationService.validateMove(null, 0, 0, 0, 0)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_ValidMoveForKingCompletesSuccessfully() {
		Piece king = new Piece();
		king.setPieceType(PieceType.KING);
		
		Board board = mock(Board.class);
		
		doReturn(board).when(moveValidationService).createBoardFromGameState(any());
		
		doReturn(king).when(board).getPieceAt(any(), any());
		
		doNothing().when(kingMoveValidationService).validateMove(any(), any(), any(), any(), any());
		
		moveValidationService.validateMove(null, 0, 0, 0, 0);
		
		verify(kingMoveValidationService).validateMove(any(), any(), any(), any(), any());
	}
	
}
