package com.grandmaster.cli;

import static org.junit.Assert.*;

import org.junit.Test;

import com.grandmaster.chesspieces.Position;
import com.grandmaster.cli.entity.Move;

public class MoveParserCoordinateNotationTest {

	@Test
	public void parseMove_goodFormat() throws Exception {
		
		Move expected = new Move(new Position(6, 4), new Position(4, 4), null);
		Move result = MoveParserCoordinateNotation.parseMove("E2-E4");
		
		assertEquals(expected, result);
		
	}
	
	@Test(expected = MoveParserException.class)
	public void parseMove_badFormat() throws Exception {
		
		MoveParserCoordinateNotation.parseMove("E2E4");
		
	}
	
}
