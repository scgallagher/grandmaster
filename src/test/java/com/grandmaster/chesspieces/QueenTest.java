package com.grandmaster.chesspieces;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.grandmaster.game.IllegalMoveException;

public class QueenTest {

	@Test
	public void testValidMoveForward() throws Exception {
		
		Piece queen = new Queen("Q_w", 3, 3);
		Position newPosition = new Position(1, 3);
		queen.move(newPosition);
		assertEquals(true, queen.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveForwardRight() throws Exception {
		
		Piece queen = new Queen("Q_w", 3, 3);
		Position newPosition = new Position(1, 5);
		queen.move(newPosition);
		assertEquals(true, queen.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveRight() throws Exception {
		
		Piece queen = new Queen("Q_w", 3, 3);
		Position newPosition = new Position(3, 5);
		queen.move(newPosition);
		assertEquals(true, queen.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveDownRight() throws Exception {
		
		Piece queen = new Queen("Q_w", 3, 3);
		Position newPosition = new Position(5, 5);
		queen.move(newPosition);
		assertEquals(true, queen.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveDown() throws Exception {
		
		Piece queen = new Queen("Q_w", 3, 3);
		Position newPosition = new Position(5, 3);
		queen.move(newPosition);
		assertEquals(true, queen.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveDownLeft() throws Exception {
		
		Piece queen = new Queen("Q_w", 3, 3);
		Position newPosition = new Position(5, 1);
		queen.move(newPosition);
		assertEquals(true, queen.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveLeft() throws Exception {
		
		Piece queen = new Queen("Q_w", 3, 3);
		Position newPosition = new Position(3, 1);
		queen.move(newPosition);
		assertEquals(true, queen.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveForwardLeft() throws Exception {
		
		Piece queen = new Queen("Q_w", 3, 3);
		Position newPosition = new Position(1, 1);
		queen.move(newPosition);
		assertEquals(true, queen.getPosition().equals(newPosition));
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveKnightLike() throws Exception {
		
		Piece queen = new Queen("Q_w", 3, 3);
		Position newPosition = new Position(1, 4);
		queen.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveForward() throws Exception {
		
		Piece queen = new Queen("Q_w", 0, 0);
		Position newPosition = new Position(-1, 0);
		queen.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveForwardRight() throws Exception {
		
		Piece queen = new Queen("Q_w", 0, 0);
		Position newPosition = new Position(-1, 1);
		queen.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveRight() throws Exception {
		
		Piece queen = new Queen("Q_w", 7, 7);
		Position newPosition = new Position(7, 8);
		queen.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveDownRight() throws Exception {
		
		Piece queen = new Queen("Q_w", 7, 7);
		Position newPosition = new Position(8, 8);
		queen.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveDown() throws Exception {
		
		Piece queen = new Queen("Q_w", 7, 7);
		Position newPosition = new Position(8, 7);
		queen.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveDownLeft() throws Exception {
		
		Piece queen = new Queen("Q_w", 7, 7);
		Position newPosition = new Position(8, 6);
		queen.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveLeft() throws Exception {
		
		Piece queen = new Queen("Q_w",7, 0);
		Position newPosition = new Position(7, -1);
		queen.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveForwardLeft() throws Exception {
		
		Piece queen = new Queen("Q_w", 0, 0);
		Position newPosition = new Position(-1, -1);
		queen.move(newPosition);
		
	}
	
}
