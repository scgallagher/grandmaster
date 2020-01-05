package com.grandmaster.chesspieces;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.grandmaster.game.IllegalMoveException;

public class BishopTest {

	@Test
	public void testValidMoveDiagonalForwardLeftOneSpace() throws Exception {
		
		Bishop bishop = new Bishop(true, "B_w", 3, 3);
		Position newPosition = new Position(2, 2);
		bishop.move(newPosition);
		assertEquals(true, bishop.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveDiagonalForwardRightOneSpace() throws Exception {
		
		Bishop bishop = new Bishop(true, "B_w", 3, 3);
		Position newPosition = new Position(2, 4);
		bishop.move(newPosition);
		assertEquals(true, bishop.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveDiagonalBackwardLeftOneSpace() throws Exception {
		
		Bishop bishop = new Bishop(true, "B_w", 3, 3);
		Position newPosition = new Position(4, 2);
		bishop.move(newPosition);
		assertEquals(true, bishop.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveDiagonalBackwardRightOneSpace() throws Exception {
		
		Bishop bishop = new Bishop(true, "B_w", 3, 3);
		Position newPosition = new Position(4, 4);
		bishop.move(newPosition);
		assertEquals(true, bishop.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveDiagonalForwardLeftTwoSpaces() throws Exception {
		
		Bishop bishop = new Bishop(true, "B_w", 3, 3);
		Position newPosition = new Position(1, 1);
		bishop.move(newPosition);
		assertEquals(true, bishop.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveDiagonalForwardRightTwoSpaces() throws Exception {
		
		Bishop bishop = new Bishop(true, "B_w", 3, 3);
		Position newPosition = new Position(1, 5);
		bishop.move(newPosition);
		assertEquals(true, bishop.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveDiagonalBackwardLeftTwoSpaces() throws Exception {
		
		Bishop bishop = new Bishop(true, "B_w", 3, 3);
		Position newPosition = new Position(5, 1);
		bishop.move(newPosition);
		assertEquals(true, bishop.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveDiagonalBackwardRightTwoSpaces() throws Exception {
		
		Bishop bishop = new Bishop(true, "B_w", 3, 3);
		Position newPosition = new Position(5, 5);
		bishop.move(newPosition);
		assertEquals(true, bishop.getPosition().equals(newPosition));
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveForwardOneSpace() throws Exception {
		
		Bishop bishop = new Bishop(true, "B_w", 3, 3);
		Position newPosition = new Position(2, 3);
		bishop.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveForwardTwoSpaces() throws Exception {
		
		Bishop bishop = new Bishop(true, "B_w", 3, 3);
		Position newPosition = new Position(1, 3);
		bishop.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveBackwardOneSpace() throws Exception {
		
		Bishop bishop = new Bishop(true, "B_w", 3, 3);
		Position newPosition = new Position(4, 3);
		bishop.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveBackwardTwoSpaces() throws Exception {
		
		Bishop bishop = new Bishop(true, "B_w", 3, 3);
		Position newPosition = new Position(5, 3);
		bishop.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveLeftOneSpace() throws Exception {
		
		Bishop bishop = new Bishop(true, "B_w", 3, 3);
		Position newPosition = new Position(3, 2);
		bishop.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveLeftTwoSpaces() throws Exception {
		
		Bishop bishop = new Bishop(true, "B_w", 3, 3);
		Position newPosition = new Position(3, 1);
		bishop.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveRightOneSpace() throws Exception {
		
		Bishop bishop = new Bishop(true, "B_w", 3, 3);
		Position newPosition = new Position(3, 4);
		bishop.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveRightTwoSpaces() throws Exception {
		
		Bishop bishop = new Bishop(true, "B_w", 3, 3);
		Position newPosition = new Position(3, 5);
		bishop.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveOutOfBounds() throws Exception {
		
		Bishop bishop = new Bishop(true, "B_w", 3, 3);
		Position newPosition = new Position(8, 8);
		bishop.move(newPosition);
		
	}
	
}
