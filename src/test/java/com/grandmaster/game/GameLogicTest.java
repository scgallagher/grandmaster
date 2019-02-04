package com.grandmaster.game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.grandmaster.chesspieces.Bishop;
import com.grandmaster.chesspieces.King;
import com.grandmaster.chesspieces.Knight;
import com.grandmaster.chesspieces.Pawn;
import com.grandmaster.chesspieces.Piece;
import com.grandmaster.chesspieces.Queen;
import com.grandmaster.chesspieces.Rook;

public class GameLogicTest {

	@Test
	public void testIsThreatYes() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Pawn blackPawn = new Pawn(!isWhite, "p_b", 2, 2, null);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackPawn);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.isThreat(2, 2, board, whiteKing, blackPawn));
		
	}
	
	@Test
	public void testIsThreatNo() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Pawn whitePawn = new Pawn(isWhite, "p_w", 2, 2, null);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whitePawn);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.isThreat(2, 2, board, whiteKing, whitePawn));
		
	}
	
	@Test
	public void testIsThreatNoWrongType() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Pawn blackPawn = new Pawn(!isWhite, "p_b", 2, 2, null);
		Bishop bishop = new Bishop(!isWhite, "B_b", 7, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackPawn);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.isThreat(2, 2, board, whiteKing, bishop));
		
	}
	
	@Test
	public void testPawnThreatUpperLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Pawn blackPawn = new Pawn(!isWhite, "p_b", 2, 2, null);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackPawn);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.pawnThreat(board, whiteKing));
		
	}
	
	@Test
	public void testPawnThreatUpperRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Pawn blackPawn = new Pawn(!isWhite, "p_b", 2, 4, null);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackPawn);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.pawnThreat(board, whiteKing));
		
	}
	
	@Test
	public void testPawnNoThreatAbove() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Pawn blackPawn = new Pawn(!isWhite, "p_b", 2, 3, null);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackPawn);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.pawnThreat(board, whiteKing));
		
	}
	
	@Test
	public void testPawnNoThreatAlly() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Pawn whitePawn = new Pawn(isWhite, "p_w", 2, 2, null);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whitePawn);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.pawnThreat(board, whiteKing));
		
	}
	
	@Test
	public void testRookThreatAbove() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook blackRook = new Rook(!isWhite, "R_b", 1, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.rookThreat(board, whiteKing));
		
	}
	
	@Test
	public void testRookThreatBelow() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook blackRook = new Rook(!isWhite, "R_b", 5, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.rookThreat(board, whiteKing));
		
	}
	
	@Test
	public void testRookThreatRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook blackRook = new Rook(!isWhite, "R_b", 3, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.rookThreat(board, whiteKing));
		
	}
	
	@Test
	public void testRookThreatLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook blackRook = new Rook(!isWhite, "R_b", 3, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.rookThreat(board, whiteKing));
		
	}
	
	@Test
	public void testRookNoThreat() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook blackRook = new Rook(!isWhite, "R_b", 4, 4);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.rookThreat(board, whiteKing));
		
	}
	
	@Test
	public void testRookNoThreatAlly() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook whiteRook = new Rook(isWhite, "R_w", 1, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteRook);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.rookThreat(board, whiteKing));
		
	}
	
	@Test
	public void testRookNoThreatBlockedByAllyBishopAbove() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop whiteBishop = new Bishop(isWhite, "B_w", 2, 3);
		Rook blackRook = new Rook(!isWhite, "R_b", 1, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteBishop);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.rookThreat(board, whiteKing));
		
	}
	
	@Test
	public void testRookNoThreatBlockedByAllyRookAbove() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook whiteRook = new Rook(isWhite, "R_w", 2, 3);
		Rook blackRook = new Rook(!isWhite, "R_b", 1, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteRook);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.rookThreat(board, whiteKing));
		
	}
	
	@Test
	public void testRookNoThreatBlockedByEnemyNonRookAbove() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Queen blackQueen = new Queen(!isWhite, "Q_b", 2, 3);
		Rook blackRook = new Rook(!isWhite, "R_b", 1, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackQueen);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.rookThreat(board, whiteKing));
		
	}
	
	@Test
	public void testRookNoThreatBlockedByAllyBishopBelow() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop whiteBishop = new Bishop(isWhite, "B_w", 4, 3);
		Rook blackRook = new Rook(!isWhite, "R_b", 5, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteBishop);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.rookThreat(board, whiteKing));
		
	}
	
	@Test
	public void testRookNoThreatBlockedByAllyRookBelow() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook whiteRook = new Rook(isWhite, "R_w", 4, 3);
		Rook blackRook = new Rook(!isWhite, "R_b", 5, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteRook);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.rookThreat(board, whiteKing));
		
	}
	
	@Test
	public void testRookNoThreatBlockedByEnemyNonRookBelow() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Queen blackQueen = new Queen(!isWhite, "Q_b", 4, 3);
		Rook blackRook = new Rook(!isWhite, "R_b", 5, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackQueen);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.rookThreat(board, whiteKing));
		
	}
	
	@Test
	public void testRookNoThreatBlockedByAllyBishopLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop whiteBishop = new Bishop(isWhite, "B_w", 3, 2);
		Rook blackRook = new Rook(!isWhite, "R_b", 3, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteBishop);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.rookThreat(board, whiteKing));
		
	}
	
	@Test
	public void testRookNoThreatBlockedByAllyRookLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook whiteRook = new Rook(isWhite, "R_w", 3, 2);
		Rook blackRook = new Rook(!isWhite, "R_b", 3, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteRook);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.rookThreat(board, whiteKing));
		
	}
	
	@Test
	public void testRookNoThreatBlockedByEnemyNonRookLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Queen blackQueen = new Queen(!isWhite, "Q_b", 3, 2);
		Rook blackRook = new Rook(!isWhite, "R_b", 3, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackQueen);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.rookThreat(board, whiteKing));
		
	}
	
	@Test
	public void testRookNoThreatBlockedByAllyBishopRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop whiteBishop = new Bishop(isWhite, "B_w", 3, 4);
		Rook blackRook = new Rook(!isWhite, "R_b", 3, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteBishop);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.rookThreat(board, whiteKing));
		
	}
	
	@Test
	public void testRookNoThreatBlockedByAllyRookRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook whiteRook = new Rook(isWhite, "R_w", 3, 4);
		Rook blackRook = new Rook(!isWhite, "R_b", 3, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteRook);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.rookThreat(board, whiteKing));
		
	}
	
	@Test
	public void testRookNoThreatBlockedByEnemyNonRookRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Queen blackQueen = new Queen(!isWhite, "Q_b", 3, 4);
		Rook blackRook = new Rook(!isWhite, "R_b", 3, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackQueen);
		pieces.add(blackRook);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.rookThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopThreatUpperLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 1, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopThreatUpperRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 1, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopThreatLowerLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 5, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopThreatLowerRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 5, 5);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 1, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopNoThreatAbove() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 1, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopNoThreatBelow() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 5, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopNoThreatLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 3, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopNoThreatRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 3, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopNoThreatAlly() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop whiteBishop = new Bishop(isWhite, "B_w", 1, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopNoThreatBlockedByAllyQueenUpperLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Queen whiteQueen = new Queen(isWhite, "Q_w", 2, 2);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 1, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteQueen);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopNoThreatBlockedByAllyBishopUpperLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop whiteBishop = new Bishop(isWhite, "B_w", 2, 2);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 1, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteBishop);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopNoThreatBlockedByEnemyNonBishopUpperLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook blackRook = new Rook(!isWhite, "B_b", 2, 2);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 1, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackRook);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopNoThreatBlockedByAllyQueenUpperRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Queen whiteQueen = new Queen(isWhite, "Q_w", 2, 4);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 1, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteQueen);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopNoThreatBlockedByAllyBishopUpperRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop whiteBishop = new Bishop(isWhite, "B_w", 2, 4);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 1, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteBishop);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopNoThreatBlockedByEnemyNonBishopUpperRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook blackRook = new Rook(!isWhite, "B_b", 2, 4);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 1, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackRook);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopNoThreatBlockedByAllyQueenLowerRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Queen whiteQueen = new Queen(isWhite, "Q_w", 4, 4);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 5, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteQueen);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopNoThreatBlockedByAllyBishopLowerRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop whiteBishop = new Bishop(isWhite, "B_w", 4, 4);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 5, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteBishop);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopNoThreatBlockedByEnemyNonBishopLowerRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook blackRook = new Rook(!isWhite, "B_b", 4, 4);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 5, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackRook);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopNoThreatBlockedByAllyQueenLowerLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Queen whiteQueen = new Queen(isWhite, "Q_w", 4, 2);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 5, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteQueen);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopNoThreatBlockedByAllyBishopLowerLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop whiteBishop = new Bishop(isWhite, "B_w", 4, 2);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 5, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteBishop);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testBishopNoThreatBlockedByEnemyNonBishopLowerLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook blackRook = new Rook(!isWhite, "B_b", 4, 2);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 5, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackRook);
		pieces.add(blackBishop);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.bishopThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKnightThreatUpperLeftVertical() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_b", 1, 2);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.knightThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKnightThreatUpperLeftHorizontal() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_b", 2, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.knightThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKnightThreatUpperRightVertical() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_b", 1, 4);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.knightThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKnightThreatUpperRightHorizontal() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_b", 2, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.knightThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKnightThreatLowerLeftVertical() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_b", 5, 2);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.knightThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKnightThreatLowerLeftHorizontal() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_b", 4, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.knightThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKnightThreatLowerRightVertical() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_b", 5, 4);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.knightThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKnightThreatLowerRightHorizontal() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_b", 4, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.knightThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKnightNoThreatAbove() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_b", 2, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.knightThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKnightNoThreatBelow() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_b", 4, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.knightThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKnightNoThreatRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_b", 3, 4);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.knightThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKnightNoThreatLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Knight blackKnight = new Knight(!isWhite, "N_b", 3, 2);
		ArrayList<Piece> pieces = new ArrayList<>();
		
		pieces.add(whiteKing);
		pieces.add(blackKnight);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.knightThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenThreatUpperLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Queen blackQueen = new Queen(!isWhite, "Q_b", 1, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenThreatAbove() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Queen blackQueen = new Queen(!isWhite, "Q_b", 1, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenThreatUpperRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Queen blackQueen = new Queen(!isWhite, "Q_b", 1, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenThreatRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Queen blackQueen = new Queen(!isWhite, "Q_b", 3, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenThreatLowerRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Queen blackQueen = new Queen(!isWhite, "Q_b", 5, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenThreatBelow() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Queen blackQueen = new Queen(!isWhite, "Q_b", 5, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenThreatLowerLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Queen blackQueen = new Queen(!isWhite, "Q_b", 5, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenThreatLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Queen blackQueen = new Queen(!isWhite, "Q_b", 3, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenNoThreatAlly() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Queen whiteQueen = new Queen(isWhite, "Q_b", 1, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenNoThreatBlockedByAllyRookAbove() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook whiteRook = new Rook(isWhite, "R_w", 2, 3);
		Queen whiteQueen = new Queen(isWhite, "Q_b", 1, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteRook);
		pieces.add(whiteQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenNoThreatBlockedByEnemyAbove() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook blackRook = new Rook(!isWhite, "R_b", 2, 3);
		Queen whiteQueen = new Queen(isWhite, "Q_b", 1, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackRook);
		pieces.add(whiteQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenNoThreatBlockedByAllyRookBelow() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook whiteRook = new Rook(isWhite, "R_w", 4, 3);
		Queen whiteQueen = new Queen(isWhite, "Q_b", 5, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteRook);
		pieces.add(whiteQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenNoThreatBlockedByEnemyBelow() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook blackRook = new Rook(!isWhite, "R_b", 4, 3);
		Queen whiteQueen = new Queen(isWhite, "Q_b", 5, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackRook);
		pieces.add(whiteQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenNoThreatBlockedByAllyRookLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook whiteRook = new Rook(isWhite, "R_w", 3, 2);
		Queen whiteQueen = new Queen(isWhite, "Q_b", 3, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteRook);
		pieces.add(whiteQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenNoThreatBlockedByEnemyLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook blackRook = new Rook(!isWhite, "R_b", 3, 2);
		Queen whiteQueen = new Queen(isWhite, "Q_b", 3, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackRook);
		pieces.add(whiteQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenNoThreatBlockedByAllyRookRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook whiteRook = new Rook(isWhite, "R_w", 3, 4);
		Queen whiteQueen = new Queen(isWhite, "Q_b", 3, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteRook);
		pieces.add(whiteQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenNoThreatBlockedByEnemyRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Rook blackRook = new Rook(!isWhite, "R_b", 3, 4);
		Queen whiteQueen = new Queen(isWhite, "Q_b", 3, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackRook);
		pieces.add(whiteQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenNoThreatBlockedByAllyBishopUpperLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop whiteBishop = new Bishop(isWhite, "B_w", 2, 2);
		Queen whiteQueen = new Queen(isWhite, "Q_b", 1, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteBishop);
		pieces.add(whiteQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenNoThreatBlockedByEnemyUpperLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 2, 2);
		Queen whiteQueen = new Queen(isWhite, "Q_b", 1, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		pieces.add(whiteQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenNoThreatBlockedByAllyBishopUpperRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop whiteBishop = new Bishop(isWhite, "B_w", 2, 4);
		Queen whiteQueen = new Queen(isWhite, "Q_b", 1, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteBishop);
		pieces.add(whiteQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenNoThreatBlockedByEnemyUpperRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 2, 4);
		Queen whiteQueen = new Queen(isWhite, "Q_b", 1, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		pieces.add(whiteQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenNoThreatBlockedByAllyBishopLowerLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop whiteBishop = new Bishop(isWhite, "B_w", 4, 2);
		Queen whiteQueen = new Queen(isWhite, "Q_b", 5, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteBishop);
		pieces.add(whiteQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenNoThreatBlockedByEnemyLowerLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 4, 2);
		Queen whiteQueen = new Queen(isWhite, "Q_b", 5, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		pieces.add(whiteQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenNoThreatBlockedByAllyBishopLowerRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop whiteBishop = new Bishop(isWhite, "B_w", 4, 4);
		Queen whiteQueen = new Queen(isWhite, "Q_b", 5, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(whiteBishop);
		pieces.add(whiteQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testQueenNoThreatBlockedByEnemyLowerRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Bishop blackBishop = new Bishop(!isWhite, "B_b", 4, 4);
		Queen whiteQueen = new Queen(isWhite, "Q_b", 5, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackBishop);
		pieces.add(whiteQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.queenThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKingThreatUpperLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		King blackKing = new King(!isWhite, "K_b", 2, 2);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackKing);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.kingThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKingThreatAbove() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		King blackKing = new King(!isWhite, "K_b", 2, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackKing);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.kingThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKingThreatUpperRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		King blackKing = new King(!isWhite, "K_b", 2, 4);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackKing);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.kingThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKingThreatRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		King blackKing = new King(!isWhite, "K_b", 3, 4);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackKing);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.kingThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKingThreatLowerRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		King blackKing = new King(!isWhite, "K_b", 4, 4);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackKing);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.kingThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKingThreatBelow() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		King blackKing = new King(!isWhite, "K_b", 4, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackKing);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.kingThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKingThreatLowerLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		King blackKing = new King(!isWhite, "K_b", 4, 2);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackKing);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.kingThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKingThreatLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		King blackKing = new King(!isWhite, "K_b", 3, 2);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackKing);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.kingThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKingNoThreatUpperLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		King blackKing = new King(!isWhite, "K_b", 1, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackKing);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.kingThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKingNoThreatAbove() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		King blackKing = new King(!isWhite, "K_b", 1, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackKing);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.kingThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKingNoThreatUpperRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		King blackKing = new King(!isWhite, "K_b", 5, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackKing);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.kingThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKingNoThreatRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		King blackKing = new King(!isWhite, "K_b", 3, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackKing);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.kingThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKingNoThreatLowerRight() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		King blackKing = new King(!isWhite, "K_b", 5, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackKing);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.kingThreat(board, whiteKing));
		
	}
	
	@Test
	public void testNoKingThreatBelow() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		King blackKing = new King(!isWhite, "K_b", 5, 3);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackKing);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.kingThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKingNoThreatLowerLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		King blackKing = new King(!isWhite, "K_b", 5, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackKing);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.kingThreat(board, whiteKing));
		
	}
	
	@Test
	public void testKingNoThreatLeft() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		King blackKing = new King(!isWhite, "K_b", 3, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackKing);
		
		board.initialize(white, black, pieces);
		assertEquals(false, GameLogic.kingThreat(board, whiteKing));
		
	}
	
	@Test
	public void testIsCheckMate() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 3, 3);
		Queen blackQueen = new Queen(!isWhite, "Q_b", 3, 1);
		Rook blackRookOne = new Rook(!isWhite, "R_b", 2, 5);
		Rook blackRookTwo = new Rook(!isWhite, "R_b", 4, 5);
		King blackKing = new King(!isWhite, "K_b", 3, 5);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackQueen);
		pieces.add(blackRookOne);
		pieces.add(blackRookTwo);
		pieces.add(blackKing);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.isCheckmate(board, whiteKing));
		
	}
	
	@Test
	public void testIsCheckMateCorner() throws Exception {
		
		Board board = new Board();
		boolean isWhite = true;
		Player white = new Player(isWhite);
		Player black = new Player(!isWhite);
		
		King whiteKing = new King(isWhite, "K_w", 0, 0);
		Queen blackQueen = new Queen(!isWhite, "Q_b", 2, 1);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(whiteKing);
		pieces.add(blackQueen);
		
		board.initialize(white, black, pieces);
		assertEquals(true, GameLogic.isCheckmate(board, whiteKing));
		
	}
	
}
