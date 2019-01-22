package com.grandmaster.chesspieces;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PositionTest {

	@Test
	public void testPositionCoordinates() throws Exception {
		
		Position position = new Position(0, 0);
		assertEquals(0, position.getRow());
		assertEquals(0, position.getColumn());
		
	}
	
	@Test
	public void testEquality() throws Exception {
		
		Position positionA = new Position(0, 0);
		Position positionB = new Position(0, 0);
		assertEquals(true, positionA.equals(positionB));
		
	}
	
}
