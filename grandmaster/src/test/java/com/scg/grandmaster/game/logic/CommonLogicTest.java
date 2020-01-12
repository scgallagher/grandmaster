package com.scg.grandmaster.game.logic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.scg.grandmaster.game.entity.Color;
import com.scg.grandmaster.game.entity.Piece;

@RunWith(MockitoJUnitRunner.class)
public class CommonLogicTest {
	
	private Piece whitePiece;
	private Piece blackPiece;
	
	@Before
	public void setup() {
		whitePiece = new Piece();
		whitePiece.setColor(Color.WHITE);
		
		blackPiece = new Piece();
		blackPiece.setColor(Color.BLACK);
	}

	@Test
	public void isAlly_PiecesAreAlliesReturnsTrue() {
		Boolean result = CommonLogic.isAlly(whitePiece, whitePiece);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isAlly_PiecesAreNotAlliesReturnsFalse() {
		Boolean result = CommonLogic.isAlly(whitePiece, blackPiece);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
	@Test
	public void isOpponent_PiecesAreOpponenentsReturnsTrue(){
		Boolean result = CommonLogic.isOpponent(whitePiece, blackPiece);
		
		assertThat(result).isEqualTo(Boolean.TRUE);
	}
	
	@Test
	public void isOpponent_PiecesAreNotOpponenentsReturnsFalse(){
		Boolean result = CommonLogic.isOpponent(whitePiece, whitePiece);
		
		assertThat(result).isEqualTo(Boolean.FALSE);
	}
	
}
