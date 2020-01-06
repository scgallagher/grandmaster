package com.grandmaster.chesspieces;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.grandmaster.game.IllegalMoveException;

public class RookTest {
	
	@Test
	public void testValidMoveForwardOneSpace() throws Exception {
		
		Rook rook = new Rook(true, "R_w", 3, 3);
		Position newPosition = new Position(2, 3);
		rook.move(newPosition);
		assertEquals(true, rook.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveForwardTwoSpaces() throws Exception {
		
		Rook rook = new Rook(true, "R_w", 3, 3);
		Position newPosition = new Position(1, 3);
		rook.move(newPosition);
		assertEquals(true, rook.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveBackwardOneSpace() throws Exception {
		
		Rook rook = new Rook(true, "R_w", 3, 3);
		Position newPosition = new Position(4, 3);
		rook.move(newPosition);
		assertEquals(true, rook.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveBackwardTwoSpaces() throws Exception {
		
		Rook rook = new Rook(true, "R_w", 3, 3);
		Position newPosition = new Position(5, 3);
		rook.move(newPosition);
		assertEquals(true, rook.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveLeftOneSpace() throws Exception {
		
		Rook rook = new Rook(true, "R_w", 3, 3);
		Position newPosition = new Position(3, 2);
		rook.move(newPosition);
		assertEquals(true, rook.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveLeftTwoSpaces() throws Exception {
		
		Rook rook = new Rook(true, "R_w", 3, 3);
		Position newPosition = new Position(3, 1);
		rook.move(newPosition);
		assertEquals(true, rook.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveRightOneSpace() throws Exception {
		
		Rook rook = new Rook(true, "R_w", 3, 3);
		Position newPosition = new Position(3, 4);
		rook.move(newPosition);
		assertEquals(true, rook.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveRightTwoSpaces() throws Exception {
		
		Rook rook = new Rook(true, "R_w", 3, 3);
		Position newPosition = new Position(3, 5);
		rook.move(newPosition);
		assertEquals(true, rook.getPosition().equals(newPosition));
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalForwardLeftOneSpace() throws Exception {
		
		Rook rook = new Rook(true, "R_w", 3, 3);
		Position newPosition = new Position(2, 2);
		rook.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalForwardLeftTwoSpaces() throws Exception {
		
		Rook rook = new Rook(true, "R_w", 3, 3);
		Position newPosition = new Position(1, 1);
		rook.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalForwardRightOneSpace() throws Exception {
		
		Rook rook = new Rook(true, "R_w", 3, 3);
		Position newPosition = new Position(2, 4);
		rook.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalForwardRightTwoSpaces() throws Exception {
		
		Rook rook = new Rook(true, "R_w", 3, 3);
		Position newPosition = new Position(1, 5);
		rook.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalDownwardLeftOneSpace() throws Exception {
		
		Rook rook = new Rook(true, "R_w", 3, 3);
		Position newPosition = new Position(4, 2);
		rook.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalDownwardLeftTwoSpaces() throws Exception {
		
		Rook rook = new Rook(true, "R_w", 3, 3);
		Position newPosition = new Position(5, 1);
		rook.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalDownwardRightOneSpace() throws Exception {
		
		Rook rook = new Rook(true, "R_w", 3, 3);
		Position newPosition = new Position(4, 4);
		rook.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalDownwardRightTwoSpaces() throws Exception {
		
		Rook rook = new Rook(true, "R_w", 3, 3);
		Position newPosition = new Position(5, 5);
		rook.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveOutOfBounds() throws Exception {
		
		Rook rook = new Rook(true, "R_w", 3, 3);
		Position newPosition = new Position(3, 8);
		rook.move(newPosition);
		
	}

}