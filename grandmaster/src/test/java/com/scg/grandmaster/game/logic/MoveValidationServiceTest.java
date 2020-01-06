package com.scg.grandmaster.game.logic;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.scg.grandmaster.exception.IllegalMoveException;
import com.scg.grandmaster.game.entity.Piece;
import com.scg.grandmaster.game.entity.PieceType;

@RunWith(MockitoJUnitRunner.class)
public class MoveValidationServiceTest {

	@Spy
	@InjectMocks
	MoveValidationService moveValidationService;
	
	@Mock
	Board board;
	
	@Test
	public void validateMove_InvalidMoveForPawnThrowsException() {
		Piece pawn = new Piece();
		pawn.setPieceType(PieceType.PAWN);
		
		when(board.getPieceAt(any(), any())).thenReturn(pawn);
		
		doThrow(new IllegalMoveException("")).when(moveValidationService).validatePawnMove(any(), any(), any(), any());
		
		assertThatThrownBy(() -> moveValidationService.validateMove(0, 0, 0, 0)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_ValidMoveForPawnCompletesSuccessfully() {
		Piece pawn = new Piece();
		pawn.setPieceType(PieceType.PAWN);
		
		when(board.getPieceAt(any(), any())).thenReturn(pawn);
		
		doNothing().when(moveValidationService).validatePawnMove(any(), any(), any(), any());
		
		moveValidationService.validateMove(0, 0, 0, 0);
		
		verify(moveValidationService).validatePawnMove(any(), any(), any(), any());
	}
	
	@Test
	public void validateMove_InvalidMoveForRookThrowsException() {
		Piece rook = new Piece();
		rook.setPieceType(PieceType.ROOK);
		
		when(board.getPieceAt(any(), any())).thenReturn(rook);
		
		doThrow(new IllegalMoveException("")).when(moveValidationService).validateRookMove(any(), any(), any(), any());
		
		assertThatThrownBy(() -> moveValidationService.validateMove(0, 0, 0, 0)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_ValidMoveForRookCompletesSuccessfully() {
		Piece rook = new Piece();
		rook.setPieceType(PieceType.ROOK);
		
		when(board.getPieceAt(any(), any())).thenReturn(rook);
		
		doNothing().when(moveValidationService).validateRookMove(any(), any(), any(), any());
		
		moveValidationService.validateMove(0, 0, 0, 0);
		
		verify(moveValidationService).validateRookMove(any(), any(), any(), any());
	}
	
	@Test
	public void validateMove_InvalidMoveForKnightThrowsException() {
		Piece knight = new Piece();
		knight.setPieceType(PieceType.KNIGHT);
		
		when(board.getPieceAt(any(), any())).thenReturn(knight);
		
		doThrow(new IllegalMoveException("")).when(moveValidationService).validateKnightMove(any(), any(), any(), any());
		
		assertThatThrownBy(() -> moveValidationService.validateMove(0, 0, 0, 0)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_ValidMoveForKnightCompletesSuccessfully() {
		Piece knight = new Piece();
		knight.setPieceType(PieceType.KNIGHT);
		
		when(board.getPieceAt(any(), any())).thenReturn(knight);
		
		doNothing().when(moveValidationService).validateKnightMove(any(), any(), any(), any());
		
		moveValidationService.validateMove(0, 0, 0, 0);
		
		verify(moveValidationService).validateKnightMove(any(), any(), any(), any());
	}
	
	@Test
	public void validateMove_InvalidMoveForBishopThrowsException() {
		Piece bishop = new Piece();
		bishop.setPieceType(PieceType.BISHOP);
		
		when(board.getPieceAt(any(), any())).thenReturn(bishop);
		
		doThrow(new IllegalMoveException("")).when(moveValidationService).validateBishopMove(any(), any(), any(), any());
		
		assertThatThrownBy(() -> moveValidationService.validateMove(0, 0, 0, 0)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_ValidMoveForBishopCompletesSuccessfully() {
		Piece bishop = new Piece();
		bishop.setPieceType(PieceType.BISHOP);
		
		when(board.getPieceAt(any(), any())).thenReturn(bishop);
		
		doNothing().when(moveValidationService).validateBishopMove(any(), any(), any(), any());
		
		moveValidationService.validateMove(0, 0, 0, 0);
		
		verify(moveValidationService).validateBishopMove(any(), any(), any(), any());
	}
	
	@Test
	public void validateMove_InvalidMoveForQueenThrowsException() {
		Piece queen = new Piece();
		queen.setPieceType(PieceType.QUEEN);
		
		when(board.getPieceAt(any(), any())).thenReturn(queen);
		
		doThrow(new IllegalMoveException("")).when(moveValidationService).validateQueenMove(any(), any(), any(), any());
		
		assertThatThrownBy(() -> moveValidationService.validateMove(0, 0, 0, 0)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_ValidMoveForQueenCompletesSuccessfully() {
		Piece queen = new Piece();
		queen.setPieceType(PieceType.QUEEN);
		
		when(board.getPieceAt(any(), any())).thenReturn(queen);
		
		doNothing().when(moveValidationService).validateQueenMove(any(), any(), any(), any());
		
		moveValidationService.validateMove(0, 0, 0, 0);
		
		verify(moveValidationService).validateQueenMove(any(), any(), any(), any());
	}
	
	@Test
	public void validateMove_InvalidMoveForKingThrowsException() {
		Piece king = new Piece();
		king.setPieceType(PieceType.KING);
		
		when(board.getPieceAt(any(), any())).thenReturn(king);
		
		doThrow(new IllegalMoveException("")).when(moveValidationService).validateKingMove(any(), any(), any(), any());
		
		assertThatThrownBy(() -> moveValidationService.validateMove(0, 0, 0, 0)).isInstanceOf(IllegalMoveException.class);
	}
	
	@Test
	public void validateMove_ValidMoveForKingCompletesSuccessfully() {
		Piece king = new Piece();
		king.setPieceType(PieceType.KING);
		
		when(board.getPieceAt(any(), any())).thenReturn(king);
		
		doNothing().when(moveValidationService).validateKingMove(any(), any(), any(), any());
		
		moveValidationService.validateMove(0, 0, 0, 0);
		
		verify(moveValidationService).validateKingMove(any(), any(), any(), any());
	}
	
}
