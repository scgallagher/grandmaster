package com.scg.grandmaster.game.logic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.scg.grandmaster.game.entity.Piece;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BoardTest {
	
	@InjectMocks
	private Board board;
	
	@Test
	public void getPieceAt_ReturnsNullIfNoPieceAtGivenLocation(){
		Piece result = board.getPieceAt(0, 0);
		assertThat(result).isNull();
	}
	
	@Test
	public void putPiece_PieceIsPlaced() {
		board.putPiece(new Piece(), 0, 0);
	}
	
	@Test
	public void removePiece_PieceIsRemoved() {
		board.removePiece(0, 0);
	}
	
	@Test
	public void get_ReturnsBoard() {
		Piece[][] boardArray = board.get();
		assertThat(boardArray).isNotNull();
	}
}
