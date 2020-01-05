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
	
	@Test
	public void testGetRankTopEdge() throws Exception {
		
		Position position = new Position (0, 0);
		assertEquals('8', position.getRank());
		
	}
	
	@Test
	public void testGetRankBottomEdge() throws Exception {
		
		Position position = new Position (7, 0);
		assertEquals('1', position.getRank());
		
	}
	
	@Test
	public void testGetFileLeftEdge() throws Exception {
		
		Position position = new Position (0, 0);
		assertEquals('a', position.getFile());
		
	}
	
	@Test
	public void testGetFileRightEdge() throws Exception {
		
		Position position = new Position (0, 7);
		assertEquals('h', position.getFile());
		
	}
	
}
