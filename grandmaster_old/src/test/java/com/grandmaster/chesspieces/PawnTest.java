package com.grandmaster.chesspieces;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.grandmaster.game.Board;
import com.grandmaster.game.IllegalMoveException;
import com.grandmaster.game.Player;

public class PawnTest {

	@Test
	public void testValidMoveForwardOneSpace() throws Exception {
		
		Piece pawn = new Pawn(true, "p_w", 6, 0, null);
		Position newPosition = new Position(5, 0);
		pawn.move(newPosition);
		assertEquals(true, pawn.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveForwardTwoSpaces() throws Exception {
		
		Piece pawn = new Pawn(true, "p_w", 6, 0, null);
		Position newPosition = new Position(4, 0);
		pawn.move(newPosition);
		assertEquals(true, pawn.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveCaptureLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		Piece whitePawn = new Pawn(true, "p_w", 3, 3, board);
		Piece blackPawn = new Pawn(!isWhite, "p_b", 2, 2, board);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whitePawn);
		pieces.add(blackPawn);
		
		board.initialize(white, black, pieces);
		Position newPosition = new Position(2, 2);
		whitePawn.move(newPosition);
		assertEquals(true, whitePawn.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveCaptureRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		Piece whitePawn = new Pawn(true, "p_w", 3, 3, board);
		Piece blackPawn = new Pawn(!isWhite, "p_b", 2, 4, board);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whitePawn);
		pieces.add(blackPawn);
		
		board.initialize(white, black, pieces);
		Position newPosition = new Position(2, 4);
		whitePawn.move(newPosition);
		assertEquals(true, whitePawn.getPosition().equals(newPosition));
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveForwardTwoSpaces() throws Exception {
		
		Piece pawn = new Pawn(true, "p_w", 6, 0, null);
		Position newPosition = new Position(5, 0);
		pawn.move(newPosition);
		newPosition = new Position(3, 0);
		pawn.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveLeft() throws Exception {
		
		Piece pawn = new Pawn(true, "p_w", 3, 3, null);
		Position newPosition = new Position(3, 2);
		pawn.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveRight() throws Exception {
		
		Piece pawn = new Pawn(true, "p_w", 3, 3, null);
		Position newPosition = new Position(3, 4);
		pawn.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalForwardLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		Piece pawn = new Pawn(true, "p_w", 3, 3, board);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(pawn);
		
		board.initialize(white, black, pieces);
		Position newPosition = new Position(2, 2);
		pawn.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalForwardRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		Piece pawn = new Pawn(true, "p_w", 3, 3, board);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(pawn);
		
		board.initialize(white, black, pieces);
		Position newPosition = new Position(2, 4);
		pawn.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalBackwardLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		Piece pawn = new Pawn(true, "p_w", 3, 3, board);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(pawn);
		
		board.initialize(white, black, pieces);
		Position newPosition = new Position(4, 2);
		pawn.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalBackwardRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		Piece pawn = new Pawn(true, "p_w", 3, 3, board);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(pawn);
		
		board.initialize(white, black, pieces);
		Position newPosition = new Position(4, 4);
		pawn.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveOutOfBounds() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		Piece pawn = new Pawn(true, "p_w", 0, 0, board);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(pawn);
		
		board.initialize(white, black, pieces);
		Position newPosition = new Position(-1, 0);
		pawn.move(newPosition);
		
	}
	
}
