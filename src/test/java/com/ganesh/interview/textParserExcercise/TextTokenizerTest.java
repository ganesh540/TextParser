package com.ganesh.interview.textParserExcercise;

import java.util.List;

import com.ganesh.interview.textToken.TextToken;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TextTokenizerTest 
    extends TestCase
{
	static List<TextToken> list;
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TextTokenizerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TextTokenizerTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
     	String input="Hello $$ H////ow! a:re? you1 123?";
        TextTokenizer tokenizer=new TextTokenizer();
        list=tokenizer.getAllTokens(input);
        
        
        //Hello H ow a re you1 123
        assertEquals(7, list.size());
    }
}
