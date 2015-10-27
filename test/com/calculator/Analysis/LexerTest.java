package com.calculator.Analysis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import com.calculator.Analysis.Token.Number;
import com.calculator.Analysis.Token.Operator;

/**
 *
 */
public class LexerTest {

    private Lexer lexer;

    @Before
    public void setUp() {
        lexer = new Lexer();
    }

    @Test
    public void it_should_tokenize_invalid_starting_expression() {
        TokenStream stream = lexer.tokenize("/2+4");

        TokenStream generatedStream = new TokenStream();
        generatedStream.addToken(new Operator("/"));
        generatedStream.addToken(new Number("2"));
        generatedStream.addToken(new Operator("+"));
        generatedStream.addToken(new Number("4"));

        assertTrue(stream.equals(generatedStream));
    }

    @Test
    public void it_should_tokenize_expression() {
        TokenStream stream = lexer.tokenize("2+4");

        TokenStream generatedStream = new TokenStream();
        generatedStream.addToken(new Number("2"));
        generatedStream.addToken(new Operator("+"));
        generatedStream.addToken(new Number("4"));

        assertTrue(stream.equals(generatedStream));
    }

    @Test
    public void it_should_tokenize_invalid_ending_expression() {
        TokenStream stream = lexer.tokenize("2+4+");

        TokenStream generatedStream = new TokenStream();
        generatedStream.addToken(new Number("2"));
        generatedStream.addToken(new Operator("+"));
        generatedStream.addToken(new Number("4"));
        generatedStream.addToken(new Operator("+"));

        assertTrue(stream.equals(generatedStream));
    }
}