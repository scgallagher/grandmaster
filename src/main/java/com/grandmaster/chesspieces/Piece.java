package com.grandmaster.chesspieces;

import com.grandmaster.game.IllegalMoveException;
import com.grandmaster.game.Utilities;

public abstract class Piece {

	private int row;
	private int column;
	private String id;
	private boolean isWhite;
	private String name;
	
	public Piece(String name, boolean isWhite, String id, int row, int column) {
		
		this.setName(name);
		this.setIsWhite(isWhite);
		this.setId(id);
		this.setRow(row);
		this.setColumn(column);
		
	}
	
	public abstract boolean isLegalMove(int newRow, int newColumn);
	
	public void move(int newRow, int newColumn) throws IllegalMoveException {

		if (this.isLegalMove(newRow, newColumn)) {
			
			this.setRow(newRow);
			this.setColumn(newColumn);
			
		}
		else {
			throw new IllegalMoveException();
		}
		
	}
	
	public void setRow(int row) {
		
		this.row = row;
		
	}
	
	public int getRow() {
		
		return this.row;
		
	}
	
	public void setColumn(int column) {
		
		this.column = column;
		
	}
	
	public int getColumn() {
		
		return this.column;
		
	}
	
	public void setPosition(Position newPosition) {
		
		this.setRow(newPosition.getRow());
		this.setColumn(newPosition.getColumn());
		
	}
	
	public Position getPosition() {
		
		return new Position(this.getRow(), this.getColumn());
		
	}
	
	public void setId(String id) {
		
		this.id = id;
		
	}
	
	public String getId() {
		
		return this.id;
		
	}
	
	public String toString() {
		
		return Utilities.rightPad(this.getId());
		
	}
	
	public void move(Position newPosition) throws IllegalMoveException {
		
		this.move(newPosition.getRow(), newPosition.getColumn());
		
	}
	
	public boolean isWhite() {
		
		return this.isWhite;
		
	}
	
	public void setIsWhite(boolean isWhite) {
		
		this.isWhite = isWhite;
		
	}
	
	public boolean isAlly(Piece piece) {
		
		return this.isWhite() == piece.isWhite();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
