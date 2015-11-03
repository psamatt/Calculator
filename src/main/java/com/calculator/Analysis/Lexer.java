package com.calculator.Analysis;

import com.calculator.Analysis.Token.Number;
import com.calculator.Analysis.Token.Operator;

/**
 * Tokenize an expression into tokens
 *
 * @author psamatt
 */
final public class Lexer {

    private String expression;
    private TokenStream stream;
    private int position;

    public Lexer() {}

    public TokenStream tokenize(String expression) {
        this.expression = expression;
        position = 0;
        stream = new TokenStream();

        while (!hasEndBeenReached()) {

            if (isNumeric()) {
                lexNumber();
            } else {
                lexOperator();
            }
        }

        return stream;
    }

    /**
     * Walk over the expression finding the complete number
     *
     */
    private void lexNumber() {
        String number = "";

        while (!hasEndBeenReached() && isNumeric()) {

            number += expression.charAt(position);
            position++;
        }

        stream.addToken(new Number(number));
    }

    /**
     * Lex operator
     *
     */
    private void lexOperator() {
        stream.addToken(new Operator(expression.substring(position, position+1)));

        position++;
    }

    /**
     * Has the end been reached
     *
     * @return boolean
     */
    private boolean hasEndBeenReached() {
        return position >= expression.length();
    }

    /**
     * Is the expression at position numeric
     *
     * @return boolean
     */
    private boolean isNumeric() {
        char c = expression.charAt(position);

        return (c >= '0' && c <= '9');
    }
}
