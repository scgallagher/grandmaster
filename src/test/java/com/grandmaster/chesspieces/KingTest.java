package com.grandmaster.chesspieces;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.grandmaster.game.IllegalMoveException;

public class KingTest {

	@Test
	public void testValidMoveForward() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(2, 3);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveForwardRight() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(2, 4);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveRight() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(3, 4);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveDownRight() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(4, 4);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveDown() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(4, 3);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveDownLeft() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(4, 2);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveLeft() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(3, 2);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveForwardLeft() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(2, 2);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveForward() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(1, 3);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveForwardRight() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(1, 5);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveRight() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(3, 5);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDownRight() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(5, 5);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDown() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(5, 3);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDownLeft() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(5, 1);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveLeft() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(3, 1);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveForwardLeft() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(1, 1);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveForward() throws Exception {
		
		Piece king = new King(true, "K_w", 0, 0);
		Position newPosition = new Position(-1, 0);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveForwardRight() throws Exception {
		
		Piece king = new King(true, "K_w", 0, 0);
		Position newPosition = new Position(-1, 1);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveRight() throws Exception {
		
		Piece king = new King(true, "K_w", 7, 7);
		Position newPosition = new Position(7, 8);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveDownRight() throws Exception {
		
		Piece king = new King(true, "K_w", 7, 7);
		Position newPosition = new Position(8, 8);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveDown() throws Exception {
		
		Piece king = new King(true, "K_w", 7, 7);
		Position newPosition = new Position(8, 7);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveDownLeft() throws Exception {
		
		Piece king = new King(true, "K_w", 7, 7);
		Position newPosition = new Position(8, 6);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveLeft() throws Exception {
		
		Piece king = new King(true, "K_w",7, 0);
		Position newPosition = new Position(7, -1);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveForwardLeft() throws Exception {
		
		Piece king = new King(true, "K_w", 0, 0);
		Position newPosition = new Position(-1, -1);
		king.move(newPosition);
		
	}
	
	@Test
	public void testGetAvailableMovesCenter() throws Exception {
		
		King king = new King(true, "K_w", 3, 3);
		ArrayList<Position> moves = king.getAvailableMoves();

		assertEquals(8, moves.size());
		assertTrue(moves.contains(new Position(2, 2)));
		assertTrue(moves.contains(new Position(2, 3)));
		assertTrue(moves.contains(new Position(2, 4)));
		assertTrue(moves.contains(new Position(3, 2)));
		assertTrue(moves.contains(new Position(3, 4)));
		assertTrue(moves.contains(new Position(4, 2)));
		assertTrue(moves.contains(new Position(4, 3)));
		assertTrue(moves.contains(new Position(4, 4)));
		
	}
	
	@Test
	public void testGetAvailableMovesUpperLeftCorner() throws Exception {
		
		King king = new King(true, "K_w", 0, 0);
		ArrayList<Position> moves = king.getAvailableMoves();
		
		assertEquals(3, moves.size());
		assertTrue(moves.contains(new Position(1, 0)));
		assertTrue(moves.contains(new Position(1, 1)));
		assertTrue(moves.contains(new Position(0, 1)));
		
	}
	
	@Test
	public void testGetAvailableMovesUpperRightCorner() throws Exception {
		
		King king = new King(true, "K_w", 0, 7);
		ArrayList<Position> moves = king.getAvailableMoves();
		
		assertEquals(3, moves.size());
		assertTrue(moves.contains(new Position(0, 6)));
		assertTrue(moves.contains(new Position(1, 6)));
		assertTrue(moves.contains(new Position(1, 7)));
		
	}
	
	@Test
	public void testGetAvailableMovesLowerLeftCorner() throws Exception {
		
		King king = new King(true, "K_w", 7, 0);
		ArrayList<Position> moves = king.getAvailableMoves();
		
		assertEquals(3, moves.size());
		assertTrue(moves.contains(new Position(6, 0)));
		assertTrue(moves.contains(new Position(6, 1)));
		assertTrue(moves.contains(new Position(7, 1)));
		
	}
	
	@Test
	public void testGetAvailableMovesLowerRightCorner() throws Exception {
		
		King king = new King(true, "K_w", 7, 7);
		ArrayList<Position> moves = king.getAvailableMoves();
		
		assertEquals(3, moves.size());
		assertTrue(moves.contains(new Position(7, 6)));
		assertTrue(moves.contains(new Position(6, 6)));
		assertTrue(moves.contains(new Position(6, 7)));
		
	}
	
	@Test
	public void testGetAvailableMovesUpperEdge() throws Exception {
		
		King king = new King(true, "K_w", 0, 3);
		ArrayList<Position> moves = king.getAvailableMoves();
		
		assertEquals(5, moves.size());
		assertTrue(moves.contains(new Position(0, 2)));
		assertTrue(moves.contains(new Position(0, 4)));
		assertTrue(moves.contains(new Position(1, 2)));
		assertTrue(moves.contains(new Position(1, 3)));
		assertTrue(moves.contains(new Position(1, 4)));
		
	}
	
	@Test
	public void testGetAvailableMovesLowerEdge() throws Exception {
		
		King king = new King(true, "K_w", 7, 3);
		ArrayList<Position> moves = king.getAvailableMoves();
		
		assertEquals(5, moves.size());
		assertTrue(moves.contains(new Position(7, 2)));
		assertTrue(moves.contains(new Position(7, 4)));
		assertTrue(moves.contains(new Position(6, 2)));
		assertTrue(moves.contains(new Position(6, 3)));
		assertTrue(moves.contains(new Position(6, 4)));
		
	}
	
	@Test
	public void testGetAvailableMovesLeftEdge() throws Exception {
		
		King king = new King(true, "K_w", 3, 0);
		ArrayList<Position> moves = king.getAvailableMoves();
		
		assertEquals(5, moves.size());
		assertTrue(moves.contains(new Position(2, 0)));
		assertTrue(moves.contains(new Position(4, 0)));
		assertTrue(moves.contains(new Position(2, 1)));
		assertTrue(moves.contains(new Position(3, 1)));
		assertTrue(moves.contains(new Position(4, 1)));
		
	}
	
	@Test
	public void testGetAvailableMovesRightEdge() throws Exception {
		
		King king = new King(true, "K_w", 3, 7);
		ArrayList<Position> moves = king.getAvailableMoves();
		
		assertEquals(5, moves.size());
		assertTrue(moves.contains(new Position(2, 7)));
		assertTrue(moves.contains(new Position(4, 7)));
		assertTrue(moves.contains(new Position(2, 6)));
		assertTrue(moves.contains(new Position(3, 6)));
		assertTrue(moves.contains(new Position(4, 6)));
		
	}
	
}
