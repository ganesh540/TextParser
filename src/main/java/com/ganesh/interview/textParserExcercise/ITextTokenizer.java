package com.ganesh.interview.textParserExcercise;

import java.util.List;

import com.ganesh.interview.textToken.TextToken;

public interface ITextTokenizer {
	
	//returns all valid tokens from charSequence
	
	
	List<TextToken> getAllTokens(CharSequence cs);
}
