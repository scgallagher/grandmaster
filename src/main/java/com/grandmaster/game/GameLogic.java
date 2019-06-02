package com.grandmaster.game;

import java.util.ArrayList;

import com.grandmaster.chesspieces.Bishop;
import com.grandmaster.chesspieces.King;
import com.grandmaster.chesspieces.Knight;
import com.grandmaster.chesspieces.Pawn;
import com.grandmaster.chesspieces.Piece;
import com.grandmaster.chesspieces.Position;
import com.grandmaster.chesspieces.Queen;
import com.grandmaster.chesspieces.Rook;

public class GameLogic {

	public static boolean isOutOfBounds(int row, int column) {
		
		if (row < 0 || row > 7 || column < 0 || column > 7) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public static boolean isOutOfBounds(Position position) {
		
		return isOutOfBounds(position.getRow(), position.getColumn());
		
	}
	
	public static boolean isThreat(int row, int column, Board board, Piece defender, Piece comparator) {
		
		if (isOutOfBounds(row, column)) {
			return false;
		}
		
		Piece piece = board.getPieceAt(row, column);
		if (piece != null && piece.getClass().isInstance(comparator) && !defender.isAlly(piece)) {
			return true;
		}
		
		return false;
		
	}
	
	public static boolean isPathBlocked(int row, int column, Board board, Piece defender, Piece comparator) {
		
		Piece piece = board.getPieceAt(row, column);
		if (piece != null && 
				(!piece.getClass().isInstance(comparator) || (piece.getClass().isInstance(comparator) && piece.isAlly(defender))))
			return true;
		
		return false;
		
	}
	
	public static boolean pawnThreat(Board board, Piece defender) {
		
		int rowDifference = 1;
		if (!defender.isWhite())
			rowDifference = -1;
		
		Pawn comparator = new Pawn(true, "", 0, 0, null);
		return GameLogic.isThreat(defender.getRow() - rowDifference, defender.getColumn() - 1, board, defender, comparator) ||
				GameLogic.isThreat(defender.getRow() - rowDifference, defender.getColumn() + 1, board, defender, comparator);
		
	}
	
	public static boolean rookThreat(Board board, Piece defender) {
		
		return horizontalThreat(board, defender, new Rook(true, "", 0, 0));
		
	}
	
	public static boolean horizontalThreat(Board board, Piece defender, Piece comparator) {

		int row = defender.getRow();
		int column = defender.getColumn();
		
		while (--row >= 0) {
			
			if (isPathBlocked(row, column, board, defender, comparator))
				break;
			else if (GameLogic.isThreat(row, column, board, defender, comparator))
				return true;
			
		}
		
		row = defender.getRow();
		while (++row <= 7) {
			
			if (isPathBlocked(row, column, board, defender, comparator))
				break;
			else if (GameLogic.isThreat(row, column, board, defender, comparator))
				return true;
			
		}
		
		row = defender.getRow();
		column = defender.getColumn();
		while (--column >= 0) {

			if (isPathBlocked(row, column, board, defender, comparator))
				break;
			else if (GameLogic.isThreat(row, column, board, defender, comparator))
				return true;
			
		}
		
		row = defender.getRow();
		column = defender.getColumn();
		while (++column <= 7) {

			if (isPathBlocked(row, column, board, defender, comparator))
				break;
			else if (GameLogic.isThreat(row, column, board, defender, comparator))
				return true;
			
		}
		
		return false;
		
	}
	
	public static boolean bishopThreat(Board board, Piece defender) {
		
		return diagonalThreat(board, defender, new Bishop(true, "", 0, 0));
		
	}
	
	public static boolean diagonalThreat(Board board, Piece defender, Piece comparator) {
		
		int row = defender.getRow();
		int column = defender.getColumn();
		while (--row >= 0 && --column >= 0) {
			
			if (isPathBlocked(row, column, board, defender, comparator))
				break;
			else if (GameLogic.isThreat(row, column, board, defender, comparator))
				return true;
			
		}
		
		row = defender.getRow();
		column = defender.getColumn();
		while (--row >= 0 && ++column <= 7) {
			
			if (isPathBlocked(row, column, board, defender, comparator))
				break;
			else if (GameLogic.isThreat(row, column, board, defender, comparator))
				return true;
			
		}
		
		row = defender.getRow();
		column = defender.getColumn();
		while (++row <= 7 && --column >= 0) {
			
			if (isPathBlocked(row, column, board, defender, comparator))
				break;
			else if (GameLogic.isThreat(row, column, board, defender, comparator))
				return true;
			
		}
		
		row = defender.getRow();
		column = defender.getColumn();
		while (++row <= 7 && ++column <= 7) {
			
			if (isPathBlocked(row, column, board, defender, comparator))
				break;
			else if (GameLogic.isThreat(row, column, board, defender, comparator))
				return true;
			
		}
		
		return false;
		
	}
	
	public static boolean knightThreat(Board board, Piece defender) {
		
		Knight knight = new Knight(true, "", 0, 0);
		
		return GameLogic.isThreat(defender.getRow() - 2, defender.getColumn() - 1, board, defender, knight) ||
				GameLogic.isThreat(defender.getRow() - 2, defender.getColumn() + 1, board, defender, knight) ||
				GameLogic.isThreat(defender.getRow() + 2, defender.getColumn() - 1, board, defender, knight) ||
				GameLogic.isThreat(defender.getRow() + 2, defender.getColumn() + 1, board, defender, knight) ||
				GameLogic.isThreat(defender.getRow() - 1, defender.getColumn() - 2, board, defender, knight) ||
				GameLogic.isThreat(defender.getRow() - 1, defender.getColumn() + 2, board, defender, knight) ||
				GameLogic.isThreat(defender.getRow() + 1, defender.getColumn() - 2, board, defender, knight) ||
				GameLogic.isThreat(defender.getRow() + 1, defender.getColumn() + 2, board, defender, knight);
		
	}
	
	public static boolean queenThreatOld(Board board, Piece defender) {
		
		Queen queen = new Queen(true, "", 0, 0);
		
		for (int i = 1; i < 8; i++) {
			
			if (GameLogic.isThreat(defender.getRow() - i, defender.getColumn() - i, board, defender, queen) ||
					GameLogic.isThreat(defender.getRow() - i, defender.getColumn(), board, defender, queen) ||
					GameLogic.isThreat(defender.getRow() - i, defender.getColumn() + i, board, defender, queen) ||
					GameLogic.isThreat(defender.getRow(), defender.getColumn() + i, board, defender, queen) ||
					GameLogic.isThreat(defender.getRow() + i, defender.getColumn() + i, board, defender, queen) ||
					GameLogic.isThreat(defender.getRow() + i, defender.getColumn(), board, defender, queen) ||
					GameLogic.isThreat(defender.getRow() + i, defender.getColumn() - i, board, defender, queen) ||
					GameLogic.isThreat(defender.getRow(), defender.getColumn() - i, board, defender, queen)) {
				return true;
			}
			
		}
		
		return false;
		
	}
	
	public static boolean queenThreat(Board board, Piece defender) {
		
		Queen comparator = new Queen(true, "", 0, 0);
		return diagonalThreat(board, defender, comparator) || horizontalThreat(board, defender, comparator);
		
	}
	
	public static boolean kingThreat(Board board, Piece defender) {
		
		King king = new King(true, "", 0, 0);
		
		return GameLogic.isThreat(defender.getRow() - 1, defender.getColumn() - 1, board, defender, king) ||
				GameLogic.isThreat(defender.getRow() - 1, defender.getColumn(), board, defender, king) ||
				GameLogic.isThreat(defender.getRow() - 1, defender.getColumn() + 1, board, defender, king) ||
				GameLogic.isThreat(defender.getRow(), defender.getColumn() + 1, board, defender, king) ||
				GameLogic.isThreat(defender.getRow() + 1, defender.getColumn() + 1, board, defender, king) ||
				GameLogic.isThreat(defender.getRow() + 1, defender.getColumn(), board, defender, king) ||
				GameLogic.isThreat(defender.getRow() + 1, defender.getColumn() - 1, board, defender, king) ||
				GameLogic.isThreat(defender.getRow(), defender.getColumn() - 1, board, defender, king);
		
	}
	
	public static boolean isCheck(Board board, Piece defendingKing) {
		
		return pawnThreat(board, defendingKing) || rookThreat(board, defendingKing) || bishopThreat(board, defendingKing) || 
				knightThreat(board, defendingKing) || queenThreat(board, defendingKing) || kingThreat(board, defendingKing);
		
	}
	
	public static boolean isCheckmate(Board board, King defendingKing) {
		
		if (!(defendingKing instanceof King))
			return false;
		
		ArrayList<Position> moves = defendingKing.getAvailableMoves();
		for (Position move : moves) {
			
			if (!isCheck(board, new King(defendingKing.isWhite(), "", move.getRow(), move.getColumn())))
				return false;
			
		}

		return true;
		
	}
	
	public ArrayList<Position> getAvailableMoves(Piece piece, Board board) {
		
		if (piece instanceof Pawn) {
			return getAvailableMovesPawn(piece, board);
		}
		else {
			return null;
		}
		
	}
	
	public ArrayList<Position> getAvailableMovesPawn(Piece piece, Board board) {
		
		Pawn pawn = (Pawn) piece;
		ArrayList<Position> moves = new ArrayList<>();
		
		int direction = 1;
		if (!pawn.isWhite()) {
			direction = -1;
		}
		
		moves.add(new Position(pawn.getRow() - 1 * direction, pawn.getColumn()));
		if (pawn.isFirstMove()) {
			moves.add(new Position(pawn.getRow() - 2 * direction, pawn.getColumn()));
		}
		
		// Attack moves
		Piece enemy = board.getPieceAt(pawn.getRow() - 1 * direction, pawn.getColumn() - 1);
		if (enemy != null && !enemy.isAlly(piece)) {
			moves.add(new Position(pawn.getRow() - 1 * direction, pawn.getColumn() - 1));
		}
		
		enemy = board.getPieceAt(pawn.getRow() - 1 * direction, pawn.getColumn() + 1);
		if (enemy != null && !enemy.isAlly(piece)) {
			moves.add(new Position(pawn.getRow() - 1 * direction, pawn.getColumn() + 1));
		}
		
		moves.removeIf(move -> isOutOfBounds(move));
		
		return moves;
		
	}
	
}
