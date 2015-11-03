package com.calculator.Analysis;

import com.calculator.Analysis.Token.*;
import com.calculator.Analysis.Token.Number;
import org.junit.*;

import static org.junit.Assert.*;

/**
 *
 */
public class TokenStreamTest {

    private TokenStream stream;

    @Before
    public void setUp() {
        this.stream = new TokenStream();
    }

    @Test
    public void it_should_add_token() {
        this.stream.addToken(new Number("4"));
    }

    @Test
    public void it_should_add_different_tokens() {
        this.stream.addToken(new Number("4"));
        this.stream.addToken(new Operator("+"));
        this.stream.addToken(new Number("5"));
    }

    @Test
    public void it_should_pop_items_off_in_fifo() {
        this.stream.addToken(new Number("4"));
        this.stream.addToken(new Operator("+"));
        this.stream.addToken(new Number("5"));

        assertTrue(this.stream.pop().equals(new Number("4")));
        assertTrue(this.stream.pop().equals(new Operator("+")));
        assertTrue(this.stream.pop().equals(new Number("5")));
    }

    @Test
    public void first_item_should_be_a_number() {
        this.stream.addToken(new Number("2"));

        assertTrue(this.stream.isNextItemANumber());
    }

    @Test
    public void first_item_is_not_a_number() {
        this.stream.addToken(new Operator("+"));

        assertFalse(this.stream.isNextItemANumber());
    }

    @Test
    public void first_item_should_be_an_operator() {
        this.stream.addToken(new Operator("+"));

        assertTrue(this.stream.isNextItemAnOperator());
    }

    @Test
    public void first_item_is_not_an_operator() {
        this.stream.addToken(new Number("4"));

        assertFalse(this.stream.isNextItemAnOperator());
    }

    @Test
    public void it_should_show_next_item_is_operator() {
        this.stream.addToken(new Number("4"));
        this.stream.addToken(new Operator("+"));
        this.stream.addToken(new Number("5"));

        assertTrue(this.stream.pop().equals(new Number("4")));
        assertTrue(this.stream.isNextItemAnOperator());
    }

    @Test
    public void it_should_show_next_item_is_number() {
        this.stream.addToken(new Number("4"));
        this.stream.addToken(new Operator("+"));
        this.stream.addToken(new Number("5"));

        this.stream.pop();
        this.stream.pop();

        assertTrue(this.stream.isNextItemANumber());
    }

    @Test
    public void it_should_not_have_another_item() {
        this.stream.addToken(new Number("4"));

        this.stream.pop();
        assertFalse(this.stream.hasNextItem());
    }

    @Test
    public void it_should_have_another_item() {
        this.stream.addToken(new Number("4"));
        this.stream.addToken(new Number("3"));

        this.stream.pop();
        assertTrue(this.stream.hasNextItem());
    }

    @Test
    public void it_should_equal_identical_token_stream() {
        this.stream.addToken(new Number("4"));
        this.stream.addToken(new Operator("+"));
        this.stream.addToken(new Number("5"));

        TokenStream other = new TokenStream();
        other.addToken(new Number("4"));
        other.addToken(new Operator("+"));
        other.addToken(new Number("5"));

        assertTrue(this.stream.equals(other));
    }

    @Test
    public void it_should_not_equal_different_token_stream() {
        this.stream.addToken(new Number("4"));
        this.stream.addToken(new Operator("+"));
        this.stream.addToken(new Number("5"));

        TokenStream other = new TokenStream();
        other.addToken(new Number("8"));
        other.addToken(new Operator("+"));
        other.addToken(new Number("2"));

        assertFalse(this.stream.equals(other));
    }

    @Test
    public void it_should_not_equal_different_sized_token_stream() {
        this.stream.addToken(new Number("4"));
        this.stream.addToken(new Operator("+"));
        this.stream.addToken(new Number("5"));

        TokenStream other = new TokenStream();
        other.addToken(new Number("4"));

        assertFalse(this.stream.equals(other));
    }
}