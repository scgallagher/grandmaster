package com.scg.grandmaster.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.ArgumentMatchers.any;

import com.scg.grandmaster.entity.PieceState;
import com.scg.grandmaster.game.domain.Color;
import com.scg.grandmaster.game.domain.PieceType;
import com.scg.grandmaster.repository.GameStateRepository;

@RunWith(MockitoJUnitRunner.class)
public class GameStateServiceTest {

	@Spy
	@InjectMocks
	GameStateService gameStateService;
	
	@Mock
	GameStateRepository gameStateRepository;
	
	@Test
	public void initializeGameState_GameStateInitialized() {
		doReturn(Collections.emptyList()).when(gameStateService).initializePieceStates();
		
		doReturn(null).when(gameStateRepository).save(any());
		
		gameStateService.initializeGameState();
	}
	
	@Test
	public void inititalizePieceStates_GameIsInitialized() {
		doReturn(Collections.singletonList(new PieceState())).when(gameStateService).initializePieceStatesForColor(Color.WHITE);
		doReturn(Collections.singletonList(new PieceState())).when(gameStateService).initializePieceStatesForColor(Color.BLACK);
		
		List<PieceState> result = gameStateService.initializePieceStates();
		
		assertThat(result.size()).isEqualTo(2);
	}
	
	@Test
	public void initializePieceStatesForColor_InitializedForWhite() {
		List<PieceState> result = gameStateService.initializePieceStatesForColor(Color.WHITE);
		
		PieceState pawn = new PieceState();
		pawn.setColor(Color.WHITE.toString());
		pawn.setPieceType(PieceType.PAWN.toString());
		pawn.setShortName("p_w");
		pawn.setRow(1);
		pawn.setColumn(0);
		
		assertThat(result).contains(pawn);
		
		pawn.setRow(1);
		pawn.setColumn(1);
		assertThat(result).contains(pawn);
		
		pawn.setRow(1);
		pawn.setColumn(2);
		assertThat(result).contains(pawn);
		
		pawn.setRow(1);
		pawn.setColumn(3);
		assertThat(result).contains(pawn);
		
		pawn.setRow(1);
		pawn.setColumn(4);
		assertThat(result).contains(pawn);
		
		pawn.setRow(1);
		pawn.setColumn(5);
		assertThat(result).contains(pawn);
		
		pawn.setRow(1);
		pawn.setColumn(6);
		assertThat(result).contains(pawn);
		
		pawn.setRow(1);
		pawn.setColumn(7);
		assertThat(result).contains(pawn);
		
		PieceState rook = new PieceState();
		rook.setPieceType(PieceType.ROOK.toString());
		rook.setColor(Color.WHITE.toString());
		rook.setShortName("R_w");
		rook.setRow(0);
		rook.setColumn(0);
		
		PieceState knight = new PieceState();
		knight.setPieceType(PieceType.KNIGHT.toString());
		knight.setColor(Color.WHITE.toString());
		knight.setShortName("N_w");
		knight.setRow(0);
		knight.setColumn(1);
		
		PieceState bishop = new PieceState();
		bishop.setPieceType(PieceType.BISHOP.toString());
		bishop.setColor(Color.WHITE.toString());
		bishop.setShortName("B_w");
		bishop.setRow(0);
		bishop.setColumn(2);
	
		PieceState queen = new PieceState();
		queen.setPieceType(PieceType.QUEEN.toString());
		queen.setColor(Color.WHITE.toString());
		queen.setShortName("Q_w");
		queen.setRow(0);
		queen.setColumn(3);
		
		PieceState king = new PieceState();
		king.setPieceType(PieceType.KING.toString());
		king.setColor(Color.WHITE.toString());
		king.setShortName("K_w");
		king.setRow(0);
		king.setColumn(4);
		
		PieceState bishopTwo = new PieceState();
		bishopTwo.setPieceType(PieceType.BISHOP.toString());
		bishopTwo.setColor(Color.WHITE.toString());
		bishopTwo.setShortName("B_w");
		bishopTwo.setRow(0);
		bishopTwo.setColumn(5);
		
		PieceState knightTwo = new PieceState();
		knightTwo.setPieceType(PieceType.KNIGHT.toString());
		knightTwo.setColor(Color.WHITE.toString());
		knightTwo.setShortName("N_w");
		knightTwo.setRow(0);
		knightTwo.setColumn(6);
		
		PieceState rookTwo = new PieceState();
		rookTwo.setPieceType(PieceType.ROOK.toString());
		rookTwo.setColor(Color.WHITE.toString());
		rookTwo.setShortName("R_w");
		rookTwo.setRow(0);
		rookTwo.setColumn(7);
		
		assertThat(result).contains(rook);
		assertThat(result).contains(knight);
		assertThat(result).contains(bishop);
		assertThat(result).contains(queen);
		assertThat(result).contains(king);
		assertThat(result).contains(bishopTwo);
		assertThat(result).contains(knightTwo);
		assertThat(result).contains(rookTwo);
	}
	
	@Test
	public void initializePieceStatesForColor_InitializedForBlack() {
		List<PieceState> result = gameStateService.initializePieceStatesForColor(Color.BLACK);
		
		PieceState pawn = new PieceState();
		pawn.setColor(Color.BLACK.toString());
		pawn.setPieceType(PieceType.PAWN.toString());
		pawn.setShortName("p_b");
		pawn.setRow(6);
		pawn.setColumn(0);
		
		assertThat(result).contains(pawn);
		
		pawn.setRow(6);
		pawn.setColumn(1);
		assertThat(result).contains(pawn);
		
		pawn.setRow(6);
		pawn.setColumn(2);
		assertThat(result).contains(pawn);
		
		pawn.setRow(6);
		pawn.setColumn(3);
		assertThat(result).contains(pawn);
		
		pawn.setRow(6);
		pawn.setColumn(4);
		assertThat(result).contains(pawn);
		
		pawn.setRow(6);
		pawn.setColumn(5);
		assertThat(result).contains(pawn);
		
		pawn.setRow(6);
		pawn.setColumn(6);
		assertThat(result).contains(pawn);
		
		pawn.setRow(6);
		pawn.setColumn(7);
		assertThat(result).contains(pawn);
		
		PieceState rook = new PieceState();
		rook.setPieceType(PieceType.ROOK.toString());
		rook.setColor(Color.BLACK.toString());
		rook.setShortName("R_b");
		rook.setRow(7);
		rook.setColumn(0);
		
		PieceState knight = new PieceState();
		knight.setPieceType(PieceType.KNIGHT.toString());
		knight.setColor(Color.BLACK.toString());
		knight.setShortName("N_b");
		knight.setRow(7);
		knight.setColumn(1);
		
		PieceState bishop = new PieceState();
		bishop.setPieceType(PieceType.BISHOP.toString());
		bishop.setColor(Color.BLACK.toString());
		bishop.setShortName("B_b");
		bishop.setRow(7);
		bishop.setColumn(2);
	
		PieceState queen = new PieceState();
		queen.setPieceType(PieceType.QUEEN.toString());
		queen.setColor(Color.BLACK.toString());
		queen.setShortName("Q_b");
		queen.setRow(7);
		queen.setColumn(3);
		
		PieceState king = new PieceState();
		king.setPieceType(PieceType.KING.toString());
		king.setColor(Color.BLACK.toString());
		king.setShortName("K_b");
		king.setRow(7);
		king.setColumn(4);
		
		PieceState bishopTwo = new PieceState();
		bishopTwo.setPieceType(PieceType.BISHOP.toString());
		bishopTwo.setColor(Color.BLACK.toString());
		bishopTwo.setShortName("B_b");
		bishopTwo.setRow(7);
		bishopTwo.setColumn(5);
		
		PieceState knightTwo = new PieceState();
		knightTwo.setPieceType(PieceType.KNIGHT.toString());
		knightTwo.setColor(Color.BLACK.toString());
		knightTwo.setShortName("N_b");
		knightTwo.setRow(7);
		knightTwo.setColumn(6);
		
		PieceState rookTwo = new PieceState();
		rookTwo.setPieceType(PieceType.ROOK.toString());
		rookTwo.setColor(Color.BLACK.toString());
		rookTwo.setShortName("R_b");
		rookTwo.setRow(7);
		rookTwo.setColumn(7);
		
		assertThat(result).contains(rook);
		assertThat(result).contains(knight);
		assertThat(result).contains(bishop);
		assertThat(result).contains(queen);
		assertThat(result).contains(king);
		assertThat(result).contains(bishopTwo);
		assertThat(result).contains(knightTwo);
		assertThat(result).contains(rookTwo);
	}
	
}
