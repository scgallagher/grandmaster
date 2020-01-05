package com.grandmaster.cli.entity;

import com.grandmaster.chesspieces.Piece;
import com.grandmaster.chesspieces.Position;

import lombok.Data;

@Data
public class Move {

	private final Position startPosition;
	private final Position endPosition;
	private final Piece piece;
	
}
