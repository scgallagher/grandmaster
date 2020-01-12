package com.scg.grandmaster.game.logic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.scg.grandmaster.game.entity.Color;
import com.scg.grandmaster.game.entity.Piece;

@RunWith(MockitoJUnitRunner.class)
public class CommonLogicTest {

	@Test
	public void areOpponenets_PiecesAreNotOpponentsReturnsFalse() {
		Piece pieceOne = new Piece();
		pieceOne.setColor(Color.WHITE);
		
		Piece pieceTwo = new Piece();
		pieceTwo.setColor(Color.WHITE);
		
		Boolean result = CommonLogic.areOpponents(pieceOne, pieceTwo);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void areOpponenets_PiecesAreOpponentsReturnsTrue() {
		Piece pieceOne = new Piece();
		pieceOne.setColor(Color.WHITE);
		
		Piece pieceTwo = new Piece();
		pieceTwo.setColor(Color.BLACK);
		
		Boolean result = CommonLogic.areOpponents(pieceOne, pieceTwo);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
}
