package com.grandmaster.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.grandmaster.cli.entity.Move;
import com.grandmaster.game.Board;
import com.grandmaster.game.IllegalMoveException;
import com.grandmaster.game.Player;
import com.grandmaster.game.UnauthorizedMoveException;

public class Cli {

	private static Logger log = LogManager.getLogger(Cli.class);
	
	public static void eventLoop() throws IOException {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		board.initialize(white, black);
		System.out.println(board);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String command = reader.readLine();
		
		while (!command.equals("quit")) {
			
			try {
				Move move = MoveParserCoordinateNotation.parseMove(command);
				log.debug(move);
				board.move(white, move.getStartPosition(), move.getEndPosition());
			}
			catch (MoveParserException e) {
				log.error(e.getMessage());
			}
			catch (UnauthorizedMoveException e) {
				log.error(e.getMessage());
			}
			catch (IllegalMoveException e) {
				log.error(e.getMessage());
			}
			System.out.println(board);
			command = reader.readLine();
			
		}
		
	}
	
	public static void main(String[] args) {
		
		try {
			eventLoop();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
