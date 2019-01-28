package com.grandmaster.chesspieces;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.grandmaster.game.IllegalMoveException;

public class KnightTest {

	@Test
	public void testValidMoveForwardLeft() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(1, 2);
		knight.move(newPosition);
		assertEquals(true, knight.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveForwardRight() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(1, 4);
		knight.move(newPosition);
		assertEquals(true, knight.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveBackwardLeft() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(5, 2);
		knight.move(newPosition);
		assertEquals(true, knight.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveBackwardRight() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(5, 4);
		knight.move(newPosition);
		assertEquals(true, knight.getPosition().equals(newPosition));
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveOutOfBounds() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 7, 7);
		Position newPosition = new Position(9, 8);
		knight.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveForwardOneSpace() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(2, 3);
		knight.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveForwardTwoSpaces() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(1, 3);
		knight.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveBackwardOneSpace() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(4, 3);
		knight.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveBackwardTwoSpaces() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(5, 3);
		knight.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveLeftOneSpace() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(3, 2);
		knight.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveLeftdTwoSpaces() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(3, 1);
		knight.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveRightOneSpace() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(3, 4);
		knight.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveRightTwoSpaces() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(3, 5);
		knight.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalForwardLeftOneSpace() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(2, 2);
		knight.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalForwardLeftTwoSpaces() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(1, 1);
		knight.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalForwardRightOneSpace() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(2, 4);
		knight.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalForwardRightTwoSpaces() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(1, 5);
		knight.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalBackwardLeftOneSpace() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(4, 2);
		knight.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalBackwardLeftTwoSpaces() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(5, 1);
		knight.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalBackwardRightOneSpace() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(4, 4);
		knight.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDiagonalBackwardRightTwoSpaces() throws Exception {
		
		Knight knight = new Knight(true, "N_w", 3, 3);
		Position newPosition = new Position(5, 5);
		knight.move(newPosition);
		
	}
	
}
