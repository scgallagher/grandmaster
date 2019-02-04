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
	
}
