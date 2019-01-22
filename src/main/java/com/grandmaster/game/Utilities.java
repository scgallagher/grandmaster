package com.grandmaster.game;

public class Utilities {

	private static final int padLength = 5;
	
	public static String rightPad(String str) {
		
		StringBuffer sb = new StringBuffer(str);
		
		while (sb.length() < padLength) {
			
			sb.append(" ");
			
		}
		
		return sb.toString();
		
	}
	
	public static boolean isOutOfBounds(int row, int column) {
		
		if (row < 0 || row > 7 || column < 0 || column > 7) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
