package com.ganesh.interview.textParserExcercise;

import com.ganesh.interview.textToken.TextToken;
import com.ganesh.interview.tokenType.TokenType;

import junit.framework.TestCase;

public class TextTokenTest extends TestCase{
	
	public void testSubSequenceOutOfBound() {
		TextToken token=new TextToken("abc".toCharArray(), 3, 5);
		try {
			token.subSequence(3, 8);
		}catch (IndexOutOfBoundsException ex){
			assertTrue("Token index out of range 8".equals(ex.getMessage()));
		}
	}
	
	public void testSubSequenceNegativeIndex() {
		TextToken token=new TextToken("abc".toCharArray(), 3, 5);
		try {
			token.subSequence(-3, 1);
		}catch (IndexOutOfBoundsException ex){
			assertTrue("Token index out of range -3".equals(ex.getMessage()));
		}
	}
	
	public void testSubSequenceWhole() {
		TextToken token=new TextToken("abc".toCharArray(), 3, 5);
			token.subSequence(0, 3);
			assertTrue("abc".equals(token.subSequence(0, 3).toString()));
	}
	
	public void testSubSequenceStartIndexGreaterThanEndIndex() {
		TextToken token=new TextToken("abc".toCharArray(), 3, 5);
		try {
			token.subSequence(3, 1);
		}catch (IndexOutOfBoundsException ex){
			assertTrue("Token index out of range -2".equals(ex.getMessage()));
		}
	}
	
	public void testNullToken() {
		try {
			@SuppressWarnings("unused")
			TextToken token=new TextToken(null,2,3);
		}catch(RuntimeException ex) {
			assertTrue("Invalid Token".equals(ex.getMessage()));
		}
		
	}
	
	public void testSpecialCharacterToken() {
		try {
			@SuppressWarnings("unused")
			TextToken token=new TextToken("######   %%%%%   ^^^".toCharArray(),2,3);
		}catch(RuntimeException ex) {
			assertTrue("Invalid Token".equals(ex.getMessage()));
		}
	}
	
	public void testCharAtOutofBound() {
		TextToken token=new TextToken("abc".toCharArray(), 3, 5);
		try {
			token.charAt(4);
		}catch (IndexOutOfBoundsException ex){
			assertTrue("Token index out of range 4".equals(ex.getMessage()));
		}
	}
	
	public void testCharAtNegativeIndex() {
		TextToken token=new TextToken("abc".toCharArray(), 3, 5);
		try {
			token.charAt(-1);
		}catch (IndexOutOfBoundsException ex){
			assertTrue("Token index out of range -1".equals(ex.getMessage()));
		}
	}
	
	public void testEmptyToken() {
		try {
			@SuppressWarnings("unused")
			TextToken token=new TextToken("".toCharArray(), 3, 5);
		}catch (RuntimeException ex){
			assertTrue("Invalid Token".equals(ex.getMessage()));
		}
	}
	
	public void testNumeric() {
		TextToken tt=new TextToken("123".toCharArray(), 0, 2);
		assertEquals(TokenType.NUMERIC_TOKEN, tt.getTokenType());
	}
	
	public void testAllCaps() {
		TextToken tt=new TextToken("ABD".toCharArray(), 0, 2);
		assertEquals(TokenType.ALPHABETIC_TOKEN, tt.getTokenType());
	}
	public void testAllNonCaps() {
		TextToken tt=new TextToken("abc".toCharArray(), 0, 2);
		assertEquals(TokenType.ALPHABETIC_TOKEN, tt.getTokenType());
	}
}
