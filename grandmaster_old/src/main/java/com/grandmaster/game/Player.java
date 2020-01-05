package com.grandmaster.game;

import java.util.ArrayList;

import com.grandmaster.chesspieces.Piece;

public class Player {
	
	private ArrayList<Piece> pieces;
	private ArrayList<Piece> capturedPieces;
	private boolean isWhite;
	
	public Player (boolean isWhite) {
		
		this.isWhite = isWhite;
		pieces = new ArrayList<>();
		capturedPieces = new ArrayList<>();
		
	}
	
	public void addPiece(Piece piece) {
		
		this.pieces.add(piece);
		
	}
	
	public ArrayList<Piece> getPieces() {
		
		return this.pieces;
		
	}
	
	public void capturePiece(Piece piece) {
		
		this.capturedPieces.add(piece);
		
	}
	
	public ArrayList<Piece> getCapturedPieces() {
		
		return this.capturedPieces;
		
	}
	
	public boolean isWhite() {
		
		return this.isWhite;
		
	}
	
	public boolean isAuthorized(Piece piece) {
		
		return this.isWhite() == piece.isWhite();
		
	}
	
	public void printPieces() {
		
		System.out.println("Pieces: ");
		
		for (Piece piece : this.pieces) {
			
			System.out.println(piece + " " + piece.getRow() + " " + piece.getColumn());
			
		}
		
	}
	
	public void printCapturePieces() {
		
		System.out.println("Captured Pieces: ");
		
		for (Piece piece : this.capturedPieces) {
			
			System.out.println(piece);
			
		}
		
	}
	

}
