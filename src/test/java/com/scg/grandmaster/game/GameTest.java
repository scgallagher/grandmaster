package com.scg.grandmaster.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.scg.grandmaster.exception.IllegalMoveException;
import com.scg.grandmaster.game.entity.Color;
import com.scg.grandmaster.game.entity.Piece;
import com.scg.grandmaster.game.entity.PieceType;
import com.scg.grandmaster.game.logic.Board;
import com.scg.grandmaster.game.logic.MoveValidationService;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

	@Spy
	@InjectMocks
	Game game;
	
	@Mock
	Board board;
	
	@Mock
	MoveValidationService moveValidationService;
	
	@Test
	public void inititalize_GameIsInitialized() {
		doNothing().when(game).initializeForColor(Color.WHITE);
		doNothing().when(game).initializeForColor(Color.BLACK);
		
		game.initialize();
		
		verify(game).initializeForColor(Color.WHITE);
		verify(game).initializeForColor(Color.BLACK);
	}
	
	@Test
	public void initializeForColor_InitializedForWhite() {
		game.initializeForColor(Color.WHITE);
		
		Piece pawn = new Piece();
		pawn.setColor(Color.WHITE);
		pawn.setPieceType(PieceType.PAWN);
		pawn.setShortName("p_w");
		
		verify(board).putPiece(eq(pawn), eq(1), eq(0));
		verify(board).putPiece(eq(pawn), eq(1), eq(1));
		verify(board).putPiece(eq(pawn), eq(1), eq(2));
		verify(board).putPiece(eq(pawn), eq(1), eq(3));
		verify(board).putPiece(eq(pawn), eq(1), eq(4));
		verify(board).putPiece(eq(pawn), eq(1), eq(5));
		verify(board).putPiece(eq(pawn), eq(1), eq(6));
		verify(board).putPiece(eq(pawn), eq(1), eq(7));
		
		Piece rook = new Piece();
		rook.setPieceType(PieceType.ROOK);
		rook.setColor(Color.WHITE);
		rook.setShortName("R_w");
		verify(board).putPiece(eq(rook), eq(0), eq(0));
		
		Piece knight = new Piece();
		knight.setPieceType(PieceType.KNIGHT);
		knight.setColor(Color.WHITE);
		knight.setShortName("N_w");
		verify(board).putPiece(eq(knight), eq(0), eq(1));
		
		Piece bishop = new Piece();
		bishop.setPieceType(PieceType.BISHOP);
		bishop.setColor(Color.WHITE);
		bishop.setShortName("B_w");
		verify(board).putPiece(eq(bishop), eq(0), eq(2));
		
		Piece queen = new Piece();
		queen.setPieceType(PieceType.QUEEN);
		queen.setColor(Color.WHITE);
		queen.setShortName("Q_w");
		verify(board).putPiece(eq(queen), eq(0), eq(3));
		
		Piece king = new Piece();
		king.setPieceType(PieceType.KING);
		king.setColor(Color.WHITE);
		king.setShortName("K_w");
		verify(board).putPiece(eq(king), eq(0), eq(4));
		
		verify(board).putPiece(eq(bishop), eq(0), eq(5));
		verify(board).putPiece(eq(knight), eq(0), eq(6));
		verify(board).putPiece(eq(rook), eq(0), eq(7));
	}
	
	@Test
	public void initializeForColor_InitializeForBlack() {
		game.initializeForColor(Color.BLACK);
		
		Piece pawn = new Piece();
		pawn.setColor(Color.BLACK);
		pawn.setPieceType(PieceType.PAWN);
		pawn.setShortName("p_b");
		
		verify(board).putPiece(eq(pawn), eq(6), eq(0));
		verify(board).putPiece(eq(pawn), eq(6), eq(1));
		verify(board).putPiece(eq(pawn), eq(6), eq(2));
		verify(board).putPiece(eq(pawn), eq(6), eq(3));
		verify(board).putPiece(eq(pawn), eq(6), eq(4));
		verify(board).putPiece(eq(pawn), eq(6), eq(5));
		verify(board).putPiece(eq(pawn), eq(6), eq(6));
		verify(board).putPiece(eq(pawn), eq(6), eq(7));
		
		Piece rook = new Piece();
		rook.setPieceType(PieceType.ROOK);
		rook.setColor(Color.BLACK);
		rook.setShortName("R_b");
		verify(board).putPiece(eq(rook), eq(7), eq(0));
		
		Piece knight = new Piece();
		knight.setPieceType(PieceType.KNIGHT);
		knight.setColor(Color.BLACK);
		knight.setShortName("N_b");
		verify(board).putPiece(eq(knight), eq(7), eq(1));
		
		Piece bishop = new Piece();
		bishop.setPieceType(PieceType.BISHOP);
		bishop.setColor(Color.BLACK);
		bishop.setShortName("B_b");
		verify(board).putPiece(eq(bishop), eq(7), eq(2));
		
		Piece queen = new Piece();
		queen.setPieceType(PieceType.QUEEN);
		queen.setColor(Color.BLACK);
		queen.setShortName("Q_b");
		verify(board).putPiece(eq(queen), eq(7), eq(3));
		
		Piece king = new Piece();
		king.setPieceType(PieceType.KING);
		king.setColor(Color.BLACK);
		king.setShortName("K_b");
		verify(board).putPiece(eq(king), eq(7), eq(4));
		
		verify(board).putPiece(eq(bishop), eq(7), eq(5));
		verify(board).putPiece(eq(knight), eq(7), eq(6));
		verify(board).putPiece(eq(rook), eq(7), eq(7));
	}
	
	@Test
	public void movePiece_MoveObjectPieceIsMovedSuccessfully() {
		game.movePiece(new Move());
		
		verify(game).movePiece(any(), any(), any(), any());
	}
	
	@Test
	public void movePiece_PieceIsMovedSuccessfully() {
		Integer sourceRow = 1;
		Integer sourceColumn = 0;
		Integer destinationRow = 2;
		Integer destinationColumn = 0;
		
		game.movePiece(sourceRow, sourceColumn, destinationRow, destinationColumn);
		
		verify(board).getPieceAt(sourceRow, sourceColumn);
		verify(board).putPiece(any(), eq(destinationRow), eq(destinationColumn));
		verify(board).removePiece(sourceRow, sourceColumn);
	}
	
	@Test
	public void movePiece_InvalidMoveThrowsException() {
		doThrow(new IllegalMoveException("")).when(moveValidationService).validateMove(any(), any(), any(), any());
		
		assertThatThrownBy(() -> game.movePiece(1, 0, 3, 0)).isInstanceOf(IllegalMoveException.class);
	}
	
}
