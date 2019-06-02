package com.grandmaster.cli;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilitiesTest {

	@Test
	public void parseRow_LowEdge() {
		char rank = '1';
		int expected = 7;
		int result = Utilities.parseRow(rank);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void parseRow_HighEdge() {
		char rank = '8';
		int expected = 0;
		int result = Utilities.parseRow(rank);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void parseColumn_LowEdge() {
		char file = 'A';
		int expected = 0;
		int result = Utilities.parseColumn(file);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void parseColumn_HighEdge() {
		char file = 'H';
		int expected = 7;
		int result = Utilities.parseColumn(file);
		
		assertEquals(expected, result);
	}
	
}
