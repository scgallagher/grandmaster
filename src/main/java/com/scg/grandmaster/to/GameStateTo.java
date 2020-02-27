package com.scg.grandmaster.to;

import com.scg.grandmaster.game.domain.Piece;

import lombok.Data;

@Data
public class GameStateTo {
	private Piece[][] board;
}
