package com.grandmaster.chesspieces;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.grandmaster.game.Board;
import com.grandmaster.game.IllegalMoveException;
import com.grandmaster.game.Player;

public class KingTest {

	@Test
	public void testValidMoveForward() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(2, 3);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveForwardRight() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(2, 4);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveRight() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(3, 4);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveDownRight() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(4, 4);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveDown() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(4, 3);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveDownLeft() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(4, 2);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveLeft() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(3, 2);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test
	public void testValidMoveForwardLeft() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(2, 2);
		king.move(newPosition);
		assertEquals(true, king.getPosition().equals(newPosition));
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveForward() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(1, 3);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveForwardRight() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(1, 5);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveRight() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(3, 5);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDownRight() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(5, 5);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDown() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(5, 3);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveDownLeft() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(5, 1);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveLeft() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(3, 1);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testInvalidMoveForwardLeft() throws Exception {
		
		Piece king = new King(true, "K_w", 3, 3);
		Position newPosition = new Position(1, 1);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveForward() throws Exception {
		
		Piece king = new King(true, "K_w", 0, 0);
		Position newPosition = new Position(-1, 0);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveForwardRight() throws Exception {
		
		Piece king = new King(true, "K_w", 0, 0);
		Position newPosition = new Position(-1, 1);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveRight() throws Exception {
		
		Piece king = new King(true, "K_w", 7, 7);
		Position newPosition = new Position(7, 8);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveDownRight() throws Exception {
		
		Piece king = new King(true, "K_w", 7, 7);
		Position newPosition = new Position(8, 8);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveDown() throws Exception {
		
		Piece king = new King(true, "K_w", 7, 7);
		Position newPosition = new Position(8, 7);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveDownLeft() throws Exception {
		
		Piece king = new King(true, "K_w", 7, 7);
		Position newPosition = new Position(8, 6);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveLeft() throws Exception {
		
		Piece king = new King(true, "K_w",7, 0);
		Position newPosition = new Position(7, -1);
		king.move(newPosition);
		
	}
	
	@Test (expected = IllegalMoveException.class)
	public void testOutOfBoundsMoveForwardLeft() throws Exception {
		
		Piece king = new King(true, "K_w", 0, 0);
		Position newPosition = new Position(-1, -1);
		king.move(newPosition);
		
	}
	
	@Test
	public void testIsThreatYes() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Pawn blackPawn = new Pawn(!isWhite, "p_b", 2, 2, null);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackPawn);
		
		board.initialize(white, black, pieces);
		assertEquals(true, whiteKing.isThreat(2, 2, board, blackPawn));
		
	}
	
	@Test
	public void testIsThreatNo() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Pawn whitePawn = new Pawn(isWhite, "p_w", 2, 2, null);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whitePawn);
		
		board.initialize(white, black, pieces);
		assertEquals(false, whiteKing.isThreat(2, 2, board, whitePawn));
		
	}
	
	@Test
	public void testIsThreatNoWrongType() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Pawn blackPawn = new Pawn(!isWhite, "p_b", 2, 2, null);
		Bishop bishop = new Bishop(!isWhite, "B_b", 7, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackPawn);
		
		board.initialize(white, black, pieces);
		assertEquals(false, whiteKing.isThreat(2, 2, board, bishop));
		
	}
	
	@Test
	public void testPawnThreatUpperLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Pawn blackPawn = new Pawn(!isWhite, "p_b", 2, 2, null);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackPawn);
		
		board.initialize(white, black, pieces);
		assertEquals(true, whiteKing.pawnThreat(board));
		
	}
	
	@Test
	public void testPawnThreatUpperRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Pawn blackPawn = new Pawn(!isWhite, "p_b", 2, 4, null);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackPawn);
		
		board.initialize(white, black, pieces);
		assertEquals(true, whiteKing.pawnThreat(board));
		
	}
	
	@Test
	public void testPawnNoThreatAbove() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Pawn blackPawn = new Pawn(!isWhite, "p_b", 2, 3, null);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackPawn);
		
		board.initialize(white, black, pieces);
		assertEquals(false, whiteKing.pawnThreat(board));
		
	}
	
	@Test
	public void testPawnNoThreatAlly() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Pawn whitePawn = new Pawn(isWhite, "p_w", 2, 2, null);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whitePawn);
		
		board.initialize(white, black, pieces);
		assertEquals(false, whiteKing.pawnThreat(board));
		
	}
	
	@Test
	public void testRookThreatAbove() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Rook blackRook = new Rook(!isWhite, "R_w", 1, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(true, whiteKing.rookThreat(board));
		
	}
	
	@Test
	public void testRookThreatBelow() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Rook blackRook = new Rook(!isWhite, "R_w", 5, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(true, whiteKing.rookThreat(board));
		
	}
	
	@Test
	public void testRookThreatRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Rook blackRook = new Rook(!isWhite, "R_w", 3, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(true, whiteKing.rookThreat(board));
		
	}
	
	@Test
	public void testRookThreatLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Rook blackRook = new Rook(!isWhite, "R_w", 3, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(true, whiteKing.rookThreat(board));
		
	}
	
	@Test
	public void testRookNoThreat() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Rook blackRook = new Rook(!isWhite, "R_w", 4, 4);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(false, whiteKing.rookThreat(board));
		
	}
	
	@Test
	public void testRookNoThreatAlly() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Rook whiteRook = new Rook(isWhite, "R_w", 1, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteRook);
		
		board.initialize(white, black, pieces);
		assertEquals(false, whiteKing.rookThreat(board));
		
	}
	
	@Test
	public void testBishopThreatUpperLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Bishop blackBishop = new Bishop(!isWhite, "B_w", 1, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(true, whiteKing.bishopThreat(board));
		
	}
	
	@Test
	public void testBishopThreatUpperRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Bishop blackBishop = new Bishop(!isWhite, "B_w", 1, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(true, whiteKing.bishopThreat(board));
		
	}
	
	@Test
	public void testBishopThreatLowerLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Bishop blackBishop = new Bishop(!isWhite, "B_w", 5, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(true, whiteKing.bishopThreat(board));
		
	}
	
	@Test
	public void testBishopThreatLowerRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 5, 5);
		Bishop blackBishop = new Bishop(!isWhite, "B_w", 1, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(true, whiteKing.bishopThreat(board));
		
	}
	
	@Test
	public void testBishopNoThreatAbove() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Bishop blackBishop = new Bishop(!isWhite, "B_w", 1, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, whiteKing.bishopThreat(board));
		
	}
	
	@Test
	public void testBishopNoThreatBelow() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Bishop blackBishop = new Bishop(!isWhite, "B_w", 5, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, whiteKing.bishopThreat(board));
		
	}
	
	@Test
	public void testBishopNoThreatLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Bishop blackBishop = new Bishop(!isWhite, "B_w", 3, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, whiteKing.bishopThreat(board));
		
	}
	
	@Test
	public void testBishopNoThreatRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Bishop blackBishop = new Bishop(!isWhite, "B_w", 3, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, whiteKing.bishopThreat(board));
		
	}
	
	@Test
	public void testKnightThreatUpperLeftVertical() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_w", 1, 2);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(true, whiteKing.knightThreat(board));
		
	}
	
	@Test
	public void testKnightThreatUpperLeftHorizontal() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_w", 2, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(true, whiteKing.knightThreat(board));
		
	}
	
	@Test
	public void testKnightThreatUpperRightVertical() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_w", 1, 4);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(true, whiteKing.knightThreat(board));
		
	}
	
	@Test
	public void testKnightThreatUpperRightHorizontal() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_w", 2, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(true, whiteKing.knightThreat(board));
		
	}
	
	@Test
	public void testKnightThreatLowerLeftVertical() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_w", 5, 2);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(true, whiteKing.knightThreat(board));
		
	}
	
	@Test
	public void testKnightThreatLowerLeftHorizontal() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_w", 4, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(true, whiteKing.knightThreat(board));
		
	}
	
	@Test
	public void testKnightThreatLowerRightVertical() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_w", 5, 4);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(true, whiteKing.knightThreat(board));
		
	}
	
	@Test
	public void testKnightThreatLowerRightHorizontal() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_w", 4, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(true, whiteKing.knightThreat(board));
		
	}
	
	@Test
	public void testKnightNoThreatAbove() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_w", 2, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(false, whiteKing.knightThreat(board));
		
	}
	
	@Test
	public void testKnightNoThreatBelow() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_w", 4, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(false, whiteKing.knightThreat(board));
		
	}
	
	@Test
	public void testKnightNoThreatRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_w", 3, 4);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(false, whiteKing.knightThreat(board));
		
	}
	
	@Test
	public void testKnightNoThreatLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(true, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_w", 3, 2);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(false, whiteKing.knightThreat(board));
		
	}
	
}
