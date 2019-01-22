package com.grandmaster.chesspieces;

import static org.junit.Assert.*;

import org.junit.Test;

import com.grandmaster.game.IllegalMoveException;

public class KingTest {

	@Test
	public void testValidMoveForward() throws Exception {
		
		Piece king = new King("K_w", 3, 3);
		Position newPosition = new Position(2, 3);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveForwardRight() throws Exception {
		
		Piece king = new King("K_w", 3, 3);
		Position newPosition = new Position(2, 4);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveRight() throws Exception {
		
		Piece king = new King("K_w", 3, 3);
		Position newPosition = new Position(3, 4);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveDownRight() throws Exception {
		
		Piece king = new King("K_w", 3, 3);
		Position newPosition = new Position(4, 4);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveDown() throws Exception {
		
		Piece king = new King("K_w", 3, 3);
		Position newPosition = new Position(4, 3);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveDownLeft() throws Exception {
		
		Piece king = new King("K_w", 3, 3);
		Position newPosition = new Position(4, 2);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveLeft() throws Exception {
		
		Piece king = new King("K_w", 3, 3);
		Position newPosition = new Position(3, 2);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveForwardLeft() throws Exception {
		
		Piece king = new King("K_w", 3, 3);
		Position newPosition = new Position(2, 2);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveForward() throws Exception {
		
		Piece king = new King("K_w", 3, 3);
		Position newPosition = new Position(1, 3);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveForwardRight() throws Exception {
		
		Piece king = new King("K_w", 3, 3);
		Position newPosition = new Position(1, 5);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveRight() throws Exception {
		
		Piece king = new King("K_w", 3, 3);
		Position newPosition = new Position(3, 5);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDownRight() throws Exception {
		
		Piece king = new King("K_w", 3, 3);
		Position newPosition = new Position(5, 5);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDown() throws Exception {
		
		Piece king = new King("K_w", 3, 3);
		Position newPosition = new Position(5, 3);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDownLeft() throws Exception {
		
		Piece king = new King("K_w", 3, 3);
		Position newPosition = new Position(5, 1);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveLeft() throws Exception {
		
		Piece king = new King("K_w", 3, 3);
		Position newPosition = new Position(3, 1);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveForwardLeft() throws Exception {
		
		Piece king = new King("K_w", 3, 3);
		Position newPosition = new Position(1, 1);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveForward() throws Exception {
		
		Piece king = new King("K_w", 0, 0);
		Position newPosition = new Position(-1, 0);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveForwardRight() throws Exception {
		
		Piece king = new King("K_w", 0, 0);
		Position newPosition = new Position(-1, 1);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveRight() throws Exception {
		
		Piece king = new King("K_w", 7, 7);
		Position newPosition = new Position(7, 8);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveDownRight() throws Exception {
		
		Piece king = new King("K_w", 7, 7);
		Position newPosition = new Position(8, 8);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveDown() throws Exception {
		
		Piece king = new King("K_w", 7, 7);
		Position newPosition = new Position(8, 7);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveDownLeft() throws Exception {
		
		Piece king = new King("K_w", 7, 7);
		Position newPosition = new Position(8, 6);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveLeft() throws Exception {
		
		Piece king = new King("K_w",7, 0);
		Position newPosition = new Position(7, -1);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveForwardLeft() throws Exception {
		
		Piece king = new King("K_w", 0, 0);
		Position newPosition = new Position(-1, -1);
		king.move(newPosition);
		
	}
	
}
