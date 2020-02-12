package com.scg.grandmaster.cli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.scg.grandmaster.game.Game;
import com.scg.grandmaster.game.Move;
import com.scg.grandmaster.game.logic.Board;

@ShellComponent
public class Commands {
	
	@Autowired
	private Board board;
	
	@Autowired
	Game game;

	@ShellMethod("Prints the board")
	public String board() {
		return board.toString();
	}
	
	@ShellMethod("Start new game")
	public void start() {
		game.initialize();
	}
	
	@ShellMethod("Move piece")
	public String move(
			@ShellOption Integer sourceRow,
			@ShellOption Integer sourceColumn,
			@ShellOption Integer destinationRow,
			@ShellOption Integer destinationColumn) {
		Move move = new Move();
		move.setSourceRow(sourceRow);
		move.setSourceColumn(sourceColumn);
		move.setDestinationRow(destinationRow);
		move.setDestinationColumn(destinationColumn);
		
		game.movePiece(move);
		
		return board.toString();
	}
}
