package com.scg.grandmaster.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scg.grandmaster.game.entity.Color;
import com.scg.grandmaster.game.entity.Piece;
import com.scg.grandmaster.game.entity.PieceType;
import com.scg.grandmaster.game.logic.Board;
import com.scg.grandmaster.game.logic.MoveValidationService;
import com.scg.grandmaster.to.GameStateTo;

import lombok.Getter;

@Getter
@Service
public class Game {
	
	private final Integer MAX_COLUMN = 8;
	
	private final Integer ROOK_COLUMN_LEFT = 0;
	private final Integer KNIGHT_COLUMN_LEFT = 1;
	private final Integer BISHOP_COLUMN_LEFT = 2;
	private final Integer QUEEN_COLUMN = 3;
	private final Integer KING_COLUMN = 4;
	private final Integer BISHOP_COLUMN_RIGHT = 5;
	private final Integer KNIGHT_COLUMN_RIGHT = 6;
	private final Integer ROOK_COLUMN_RIGHT = 7;

	@Autowired
	private Board board;
	
	@Autowired
	private MoveValidationService moveValidationService;
	
	public void initialize() {
		initializeForColor(Color.WHITE);
		initializeForColor(Color.BLACK);
	}

	public void initializeForColor(Color color) {
		
		Integer rearLineRow = 0;
		Integer frontLineRow = 1;
		
		if (color == Color.BLACK) {
			rearLineRow = 7;
			frontLineRow = 6;
		}
		
		Piece rook = new Piece();
		rook.setPieceType(PieceType.ROOK);
		rook.setColor(color);
		setPieceName(rook);
		board.putPiece(rook, rearLineRow, ROOK_COLUMN_LEFT);
		
		Piece knight = new Piece();
		knight.setPieceType(PieceType.KNIGHT);
		knight.setColor(color);
		setPieceName(knight);
		board.putPiece(knight, rearLineRow, KNIGHT_COLUMN_LEFT);
		
		Piece bishop = new Piece();
		bishop.setPieceType(PieceType.BISHOP);
		bishop.setColor(color);
		setPieceName(bishop);
		board.putPiece(bishop, rearLineRow, BISHOP_COLUMN_LEFT);
		
		Piece queen = new Piece();
		queen.setPieceType(PieceType.QUEEN);
		queen.setColor(color);
		setPieceName(queen);
		board.putPiece(queen, rearLineRow, QUEEN_COLUMN);
		
		Piece king = new Piece();
		king.setPieceType(PieceType.KING);
		king.setColor(color);
		setPieceName(king);
		board.putPiece(king, rearLineRow, KING_COLUMN);
		
		bishop = new Piece();
		bishop.setPieceType(PieceType.BISHOP);
		bishop.setColor(color);
		setPieceName(bishop);
		board.putPiece(bishop, rearLineRow, BISHOP_COLUMN_RIGHT);
		
		knight = new Piece();
		knight.setPieceType(PieceType.KNIGHT);
		knight.setColor(color);
		setPieceName(knight);
		board.putPiece(knight, rearLineRow, KNIGHT_COLUMN_RIGHT);
		
		rook = new Piece();
		rook.setPieceType(PieceType.ROOK);
		rook.setColor(color);
		setPieceName(rook);
		board.putPiece(rook, rearLineRow, ROOK_COLUMN_RIGHT);
		
		for (int i = 0; i < MAX_COLUMN; i++) {
			Piece pawn = new Piece();
			pawn.setPieceType(PieceType.PAWN);
			pawn.setColor(color);
			setPieceName(pawn);
			board.putPiece(pawn, frontLineRow, i);
		}
	}
	
	public void setPieceName(Piece piece) {
		String color = "w";
		if (piece.getColor() == Color.BLACK) {
			color = "b";
		}
		switch(piece.getPieceType()) {
		case PAWN:
			piece.setShortName("p_" + color);
			break;
		case ROOK:
			piece.setShortName("R_" + color);
			break;
		case KNIGHT:
			piece.setShortName("N_" + color);
			break;
		case BISHOP:
			piece.setShortName("B_" + color);
			break;
		case QUEEN:
			piece.setShortName("Q_" + color);
			break;
		case KING:
			piece.setShortName("K_" + color);
			break;
	}
	}
	
	public void movePiece(Move move) {
		movePiece(move.getSourceRow(), move.getSourceColumn(), move.getDestinationRow(), move.getDestinationColumn());
	}

	public void movePiece(Integer sourceRow, Integer sourceColumn, Integer destinationRow, Integer destinationColumn) {
		moveValidationService.validateMove(sourceRow, sourceColumn, destinationRow, destinationColumn);
		board.putPiece(board.getPieceAt(sourceRow, sourceColumn), destinationRow, destinationColumn);
		board.removePiece(sourceRow, sourceColumn);
	}
	
	public GameStateTo getState() {
		GameStateTo gameState = new GameStateTo();
		gameState.setBoard(board.get());
		return gameState;
	}
	
}
