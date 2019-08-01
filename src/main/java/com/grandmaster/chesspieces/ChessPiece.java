package com.grandmaster.chesspieces;

import lombok.Data;

@Data
public class ChessPiece {

	private String id;
	private PlayerColor playerColor;
	private PieceType pieceType;
	private String name;
	
}
