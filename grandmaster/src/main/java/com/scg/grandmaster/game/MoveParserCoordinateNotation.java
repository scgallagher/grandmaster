package com.scg.grandmaster.game;

public class MoveParserCoordinateNotation {

	public static Move parseMove(String command) {
		String[] coordinates = command.split(" ");
		
		Move move = new Move();
		move.setSourceRow(Integer.parseInt(coordinates[0]));
		move.setSourceColumn(Integer.parseInt(coordinates[1]));
		move.setDestinationRow(Integer.parseInt(coordinates[2]));
		move.setDestinationColumn(Integer.parseInt(coordinates[3]));
		
		return move;
	}

}
