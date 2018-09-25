package com.ganesh.interview.tokenUtility;

public class TokenUtility {
	
	public static boolean isValidCS(CharSequence cs) {
		if(cs!=null
			&& cs.length()>0 /* && cs.toString().replaceAll("[^a-zA-Z0-9]+", "").trim().length()>0*/) return true;
		
		return false;
	}
	
	
	public static boolean isAlfhaNumeric(char c) {
		if((c >= '0' && c <= '9') ||(c >= 'a' && c <= 'z') ||(c >= 'A' && c<= 'Z')) {
			return true;
		}
		
		return false;
	}
}
