package com.scg.grandmaster.game.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Piece {
	private Color color;
	private PieceType pieceType;
	private String name;
	private String shortName;
}
