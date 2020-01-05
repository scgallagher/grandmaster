package com.grandmaster.game;

import com.grandmaster.chesspieces.Position;

public class Grandmaster {

	public static void main(String[] args) {

		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		board.initialize(white, black);
		System.out.println(board);		
		
		//System.out.println("\u2654");

	}

}
