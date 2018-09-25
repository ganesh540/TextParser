package com.ganesh.interview.textParserExcercise;

import java.util.List;

import com.ganesh.interview.textToken.TextToken;
import com.ganesh.interview.tokenType.TokenType;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for TextParser App.
 */
public class TextTokenizerTest extends TestCase {
	static List<TextToken> list;

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public TextTokenizerTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		TestSuite suite = new TestSuite(TextTokenizerTest.class);
		TestSetup setup = new TestSetup(suite) {
			protected void setUp() throws Exception {
				// do your one-time setup here!
				String input = "Hello $$ H////ow! a:re? you1 123? 123abc";
				TextTokenizer tokenizer = new TextTokenizer();
				list = tokenizer.getAllTokens(input);
			}
		};
		return setup;
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {

		// Hello H ow a re you1 123
		assertEquals(8, list.size());
		assertEquals(list.get(0).getTokenType(), TokenType.ALPHABETIC_TOKEN);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testSize() {
		assertEquals(8, list.size());
	}

	public void testNoTokenString() {
		String input = "$$$$ **** )))(((";
		assertEquals(0,new TextTokenizer().getAllTokens(input).size());
	}

	public void testnullString() {
		String input = null;
		assertNull(new TextTokenizer().getAllTokens(input));
	}

	public void testTokenValue() {
		TextToken token1 = list.get(0);
		assertTrue("Hello".equals(token1.toString()));
	}

	public void testNumbericTokenType() {
		TextToken token6 = list.get(6);
		assertEquals(TokenType.NUMERIC_TOKEN, token6.getTokenType());
	}

	public void testAlphaNumbericTokenType() {
		TextToken token5 = list.get(5);
		assertEquals(TokenType.ALPHANUMERIC_TOKEN, token5.getTokenType());
	}

	public void testAlphabetTokenType() {
		TextToken token1 = list.get(0);
		assertEquals(TokenType.ALPHABETIC_TOKEN, token1.getTokenType());
	}

	public void testTokenChatAt() {
		TextToken token1 = list.get(0);
		assertEquals('o', token1.charAt(4));
	}

	public void testTokenSubsequenceAndItsRelativeIndices() {
		TextToken token1 = list.get(0);
		TextToken subToken = (TextToken) token1.subSequence(2, 3);
		assertEquals(2, subToken.length());

		int[] indices = subToken.getRelativeIndex();
		assertEquals(2, indices[0]);
		assertEquals(3, indices[1]);
	}

	public void testIfStringIsNullList() {
		assertNull(new TextTokenizer().getAllTokens(null));
	}

	public void testStringEmpty() {
		assertNull(new TextTokenizer().getAllTokens(""));
	}

	public void testSpecialString() {
		assertEquals(0,new TextTokenizer().getAllTokens("/// //").size());
	}

	// Bonus testcase
	public void testTokenPattern() {
		for (TextToken t : list) {
			boolean matchedExp = java.util.regex.Pattern.matches("[a-zA-Z0-9]+", t);
			assertTrue(matchedExp);
		}
	}
}
