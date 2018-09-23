package com.ganesh.interview.textToken;

import java.util.Arrays;

import com.ganesh.interview.tokenType.TokenType;

public final class TextToken implements CharSequence {

	 /** The value is used for character storage. */
	 private final char value[];
	 
	 /** The count is the number of characters in the String. */
	 private final int length;
	 
	 /** The relativeIndex is first and last index relative to Orginal String */
	 private final int[] relativeIndex;
	
	 public TextToken(char value[],int firstIndex,int lastIndex) { 
		
		
		this.length = value.length;
		this.value = Arrays.copyOf(value, this.length);
		this.relativeIndex=new int[2];
		this.relativeIndex[0]=firstIndex;
		this.relativeIndex[1]=lastIndex;
	 }
	 
	 
	 @Override
	 public int length() {
		return length;
	}

	@Override
	public char charAt(int index) {
		if ((index < 0) || (index >= length)) {
			throw new IndexOutOfBoundsException("Token index out of range "+index);
		}
		return value[index];
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		if (start < 0) {
			 throw new IndexOutOfBoundsException("Token index out of range "+start);
		}
		if (end > length) {
			 throw new IndexOutOfBoundsException("Token index out of range "+end);
		}
		if (start > end) {
			 throw new IndexOutOfBoundsException("Token index out of range "+(end - start));
		}
		return ((start == 0) && (end == length)) ? this :subSequence(value,start,end);
	}
	
	
	// Hello 2 3 ll
	private CharSequence subSequence(char[] value,int start,int end) {
		char[] subCharArray=new char[end-start+1];
		for(int i=start,index=0;i<=end;i++) {
			subCharArray[index++]=value[i];
		}
		return new TextToken(subCharArray,this.relativeIndex[0]+start,this.relativeIndex[0]+end);
	}
	
	
	/* returns String value of the token*/
	public String toString() {
		StringBuffer sb=new StringBuffer();
		for(char c:value) {
			sb.append(c);
		}
		return sb.toString();
	}
	
	
	//returns first and last index
	public int[] getRelativeIndex() {
		return relativeIndex;
	}
	
	
	// returns type of token
	public TokenType getTokenType() {
		String s=toString();

		if(s.matches("[a-zA-Z]+")) return TokenType.ALPHABETIC_TOKEN;
		
		if(s.matches("[0-9]+")) return TokenType.NUMERIC_TOKEN;
		
		return TokenType.ALPHANUMERIC_TOKEN;
	}
	
	
	

}
