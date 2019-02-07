package com.grandmaster.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.grandmaster.game.Board;
import com.grandmaster.game.Player;

public class Cli {

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
			
			System.out.println(board);
			command = reader.readLine();
			
		}
		
	}
	
	public static void main(String[] args) {
		
//		try {
//			eventLoop();
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try {
			MoveFactory.parseMove("Ng7");
		} catch (MoveParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
