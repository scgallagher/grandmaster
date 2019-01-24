package com.grandmaster.game;

import java.util.ArrayList;

import com.grandmaster.chesspieces.King;
import com.grandmaster.chesspieces.Piece;

public class Grandmaster {

	public static void main(String[] args) {

		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		Piece whiteKing = new King(isWhite, "K_w", 7, 4);
		Piece blackKing = new King(!isWhite, "K_b", 0, 4);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackKing);
		
		board.initialize(white, black, pieces);
		System.out.println(board);
		white.printPieces();
		
		try {
			board.move(white, 7, 4, 6, 4);
			System.out.println(board);
			white.printPieces();
			white.printCapturePieces();
			
			board.move(white, 6, 4, 5, 5);
			System.out.println(board);
			white.printPieces();
			white.printCapturePieces();
		}
		catch (IllegalMoveException ime) {
			ime.printStackTrace();
		}
		catch (UnauthorizedMoveException ume) {
			ume.printStackTrace();
		}
		
		
		//System.out.println("\u2654");

	}

}
