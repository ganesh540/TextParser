package com.ganesh.interview.textToken;

import java.util.Arrays;

import com.ganesh.interview.tokenType.TokenType;
import com.ganesh.interview.tokenUtility.TokenUtility;

public final class TextToken implements CharSequence {

	 /** The value is used for character storage. */
	 private final char value[];
	 
	 /** The count is the number of characters in the String. */
	 private final int length;
	 
	 /** The relativeIndex is first and last index relative to Orginal String */
	 private final int[] relativeIndex;
	
	 public TextToken(char value[],int firstIndex,int lastIndex) { 
		 if(value==null || (!TokenUtility.isValidCS(String.valueOf(value)) && String.valueOf(value).replaceAll("[^a-zA-Z0-9]+", "").trim().length()>0) ) 
				throw new RuntimeException("Invalid Token");
		
		this.length = value.length;
		this.value = Arrays.copyOf(value, this.length);
		this.relativeIndex=new int[2];
		this.relativeIndex[0]=firstIndex;
		this.relativeIndex[1]=lastIndex;
	 }
	 
	 /** Returns the length of the token*/
	 @Override
	 public int length() {
		return length;
	}

	 /** Returns the character of the token at given index*/
	@Override
	public char charAt(int index) {
		if ((index < 0) || (index >= length)) {
			throw new IndexOutOfBoundsException("Token index out of range "+index);
		}
		return value[index];
	}

	
	/** Returns a new token that is a subsequence of this token*/
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
	
	
	// Returns new texttoken 
	private CharSequence subSequence(char[] value,int start,int end) {
		char[] subCharArray=new char[end-start+1];
		for(int i=start,index=0;i<=end;i++) {
			subCharArray[index++]=value[i];
		}
		return new TextToken(subCharArray,this.relativeIndex[0]+start,this.relativeIndex[0]+end);
	}
	
	
	/** Returns String value of the token*/
	public String toString() {
		return new String(value);
	}
	
	
	/** Returns first and last index*/
	public int[] getRelativeIndex() {
		return relativeIndex;
	}
	
	
	/** Returns type of token */
	public TokenType getTokenType() {
		String s=toString();

		if(s.matches("[a-zA-Z]+")) return TokenType.ALPHABETIC_TOKEN;
		
		if(s.matches("[0-9]+")) return TokenType.NUMERIC_TOKEN;
		
		return TokenType.ALPHANUMERIC_TOKEN;
	}
	
	
	

}
