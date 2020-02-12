package com.scg.grandmaster.to;

import com.scg.grandmaster.game.entity.Piece;

import lombok.Data;

@Data
public class GameState {
	private Piece[][] board;
}
