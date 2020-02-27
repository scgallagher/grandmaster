package com.scg.grandmaster.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.scg.grandmaster.entity.GameState;
import com.scg.grandmaster.entity.PieceState;
import com.scg.grandmaster.game.entity.Color;
import com.scg.grandmaster.game.entity.PieceType;
import com.scg.grandmaster.repository.GameStateRepository;

@Service
public class GameStateService {
	
	private final Integer MAX_COLUMN = 8;
	
	private final Integer ROOK_COLUMN_LEFT = 0;
	private final Integer KNIGHT_COLUMN_LEFT = 1;
	private final Integer BISHOP_COLUMN_LEFT = 2;
	private final Integer QUEEN_COLUMN = 3;
	private final Integer KING_COLUMN = 4;
	private final Integer BISHOP_COLUMN_RIGHT = 5;
	private final Integer KNIGHT_COLUMN_RIGHT = 6;
	private final Integer ROOK_COLUMN_RIGHT = 7;
	
	private static final Logger log = LoggerFactory.getLogger(GameStateService.class);

	@Autowired
	private GameStateRepository gameStateRepository;
	
	public GameState getGameStateById(Integer id) {
		Optional<GameState> response = gameStateRepository.findById(id);
		
		return response.orElseThrow(ResourceNotFoundException::new);
	}
	
	public Integer initializeGameState() {
		List<PieceState> pieceStates = initializePieceStates();
		GameState gameState = new GameState();
		pieceStates.stream().forEach(pieceState -> pieceState.setGameState(gameState));
		gameState.setPieceStateList(pieceStates);
		
		gameStateRepository.save(gameState);
		
		Integer createdId = gameState.getId();
		log.info("Created game state with Id: {}", createdId);
		return createdId;
	}
	
	public List<PieceState> initializePieceStates() {
		List<PieceState> pieceStates = new ArrayList<>();
		
		pieceStates.addAll(initializePieceStatesForColor(Color.WHITE));
		pieceStates.addAll(initializePieceStatesForColor(Color.BLACK));
		
		return pieceStates;
	}
	
	public List<PieceState> initializePieceStatesForColor(Color color) {
		
		List<PieceState> pieceStates = new ArrayList<>();
		
		Integer rearLineRow = 0;
		Integer frontLineRow = 1;
		
		if (color == Color.BLACK) {
			rearLineRow = 7;
			frontLineRow = 6;
		}
		
		PieceState rook = new PieceState();
		rook.setPieceType(PieceType.ROOK.toString());
		rook.setColor(color.toString());
		rook.setRow(rearLineRow);
		rook.setColumn(ROOK_COLUMN_LEFT);
		setPieceName(rook);
		pieceStates.add(rook);
		
		PieceState knight = new PieceState();
		knight.setPieceType(PieceType.KNIGHT.toString());
		knight.setColor(color.toString());
		knight.setRow(rearLineRow);
		knight.setColumn(KNIGHT_COLUMN_LEFT);
		setPieceName(knight);
		pieceStates.add(knight);
		
		PieceState bishop = new PieceState();
		bishop.setPieceType(PieceType.BISHOP.toString());
		bishop.setColor(color.toString());
		bishop.setRow(rearLineRow);
		bishop.setColumn(BISHOP_COLUMN_LEFT);
		setPieceName(bishop);
		pieceStates.add(bishop);
		
		PieceState queen = new PieceState();
		queen.setPieceType(PieceType.QUEEN.toString());
		queen.setColor(color.toString());
		queen.setRow(rearLineRow);
		queen.setColumn(QUEEN_COLUMN);
		setPieceName(queen);
		pieceStates.add(queen);
		
		PieceState king = new PieceState();
		king.setPieceType(PieceType.KING.toString());
		king.setColor(color.toString());
		king.setRow(rearLineRow);
		king.setColumn(KING_COLUMN);
		setPieceName(king);
		pieceStates.add(king);
		
		bishop = new PieceState();
		bishop.setPieceType(PieceType.BISHOP.toString());
		bishop.setColor(color.toString());
		bishop.setRow(rearLineRow);
		bishop.setColumn(BISHOP_COLUMN_RIGHT);
		setPieceName(bishop);
		pieceStates.add(bishop);
		
		knight = new PieceState();
		knight.setPieceType(PieceType.KNIGHT.toString());
		knight.setColor(color.toString());
		knight.setRow(rearLineRow);
		knight.setColumn(KNIGHT_COLUMN_RIGHT);
		setPieceName(knight);
		pieceStates.add(knight);
		
		rook = new PieceState();
		rook.setPieceType(PieceType.ROOK.toString());
		rook.setColor(color.toString());
		rook.setRow(rearLineRow);
		rook.setColumn(ROOK_COLUMN_RIGHT);
		setPieceName(rook);
		pieceStates.add(rook);
		
		for (int i = 0; i < MAX_COLUMN; i++) {
			PieceState pawn = new PieceState();
			pawn.setPieceType(PieceType.PAWN.toString());
			pawn.setColor(color.toString());
			pawn.setRow(frontLineRow);
			pawn.setColumn(i);
			setPieceName(pawn);
			pieceStates.add(pawn);
		}
		
		return pieceStates;
	}
	
	public void setPieceName(PieceState piece) {
		String color = "w";
		if (Color.valueOf(piece.getColor()) == Color.BLACK) {
			color = "b";
		}
		switch(PieceType.valueOf(piece.getPieceType())) {
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
	
}
