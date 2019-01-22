package com.grandmaster.game;

public class Grandmaster {

	public static void main(String[] args) {

		Board board = new Board();
		System.out.println(board);
		
		try {
			board.move(7, 4, 6, 3);
		}
		catch (IllegalMoveException e) {
			e.printStackTrace();
		}
		
		System.out.println(board);
		System.out.println("\u2654");

	}

}
