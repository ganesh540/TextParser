package com.ganesh.interview.textParserExcercise;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ganesh.interview.textToken.TextToken;
import com.ganesh.interview.tokenUtility.TokenUtility;


/**
*
* @author  Ganesh Kumar Pericherla
* @version 1.0
*/
public class TextTokenizer implements ITextTokenizer {

	static Logger logger = Logger.getLogger(TextTokenizer.class.getSimpleName());

	
	/**
	 * Generates all sequential TextTokens from CharSequence
	 *
	 * @param  CharSequence
	 * @return List of TextTokens
	 */
	@Override
	public List<TextToken> getAllTokens(CharSequence cs) {

		logger.log(Level.INFO, "Inside GetAllTokens");

		if (!TokenUtility.isValidCS(cs)) {
			logger.log(Level.INFO, "Exiting GetAllTokens, No tokens generated");
			return null;
		}

		List<TextToken> tokenList = new ArrayList<>();

		int start = 0;

		for (int i = 0; i < cs.length(); i++) {
			if (!TokenUtility.isAlfhaNumeric(cs.charAt(i)) || i == cs.length() - 1) {
				if (cs.subSequence(start, i).length() > 0)
					addTokenToList(tokenList, start, i - 1, cs.subSequence(start, i));
				start = i + 1;
			}
		}
		logger.log(Level.INFO, "Exiting GetAllTokens and " + "generated ::" + tokenList.size() + " tokens");
		return tokenList;
	}

	
	// Adds new token to tokenList
	private void addTokenToList(List<TextToken> tokenList, int start, int end, CharSequence tokenValue) {
		TextToken token = new TextToken(tokenValue.toString().toCharArray(), start, end);
		tokenList.add(token);
	}

}
