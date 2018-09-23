package com.ganesh.interview.textParserExcercise;

import java.util.ArrayList;
import java.util.List;

import com.ganesh.interview.textToken.TextToken;
import com.ganesh.interview.tokenUtility.TokenUtility;

public class TextTokenizer implements ITextTokenizer {

	@Override
	public List<TextToken> getAllTokens(CharSequence cs) {
		
		
		if(!TokenUtility.isValidCS(cs)) return null;
		
		List<TextToken> tokenList=new ArrayList<>();
		
		int start=0;
		
		for(int i=0;i<cs.length();i++) {
			if(!TokenUtility.isAlfhaNumeric(cs.charAt(i))) {
				if(cs.subSequence(start, i).length()>0)
				addTokenToList(tokenList, start,i-1, cs.subSequence(start, i));
				start= i+1;
			}
		}
		
		return tokenList;
	}
	
	private void addTokenToList(List<TextToken> tokenList,int start,int end, CharSequence tokenValue) {
		TextToken token=new TextToken(tokenValue.toString().toCharArray(), start,end);
		tokenList.add(token);
	}
		
}
