package com.grandmaster.chesspieces;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.grandmaster.game.Board;
import com.grandmaster.game.Player;

public class PawnTest {

	@Test
	public void testValidMoveForwardOneSpace() throws Exception {
		
		Piece pawn = new Pawn(true, "K_w", 6, 0);
		Position newPosition = new Position(5, 0);
		pawn.move(newPosition);
		assertEquals(true, pawn.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveForwardTwoSpaces() throws Exception {
		
		Piece pawn = new Pawn(true, "K_w", 6, 0);
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
		Piece blackPawn = new Pawn(!isWhite, "p_b", 2, 2);
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
		Piece blackPawn = new Pawn(!isWhite, "p_b", 2, 4);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whitePawn);
		pieces.add(blackPawn);
		
		board.initialize(white, black, pieces);
		Position newPosition = new Position(2, 4);
		whitePawn.move(newPosition);
		assertEquals(true, whitePawn.getPosition().equals(newPosition));
		
	}
	
}
