package com.calculator;

import com.calculator.Analysis.Expression.ExpressionInterface;
import com.calculator.Analysis.Lexer;
import com.calculator.Analysis.Parser;
import com.calculator.Analysis.TokenStream;

/**
 * Calculator
 *
 * @author psamatt
 */
final public class Calculator {

    private Lexer lexer;
    private Parser parser;

    public Calculator() {
        lexer = new Lexer();
        parser = new Parser();
    }

    /**
     * Calculate an expression
     *
     * @param expression
     * @return
     */
    public int calculate(String expression) {
        TokenStream stream = lexer.tokenize(expression);
        ExpressionInterface e = parser.parse(stream);

        return e.getValue();
    }
}

