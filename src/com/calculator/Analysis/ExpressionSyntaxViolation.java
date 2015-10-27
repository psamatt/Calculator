package com.calculator.Analysis;

/**
 * Expression syntax violation
 *
 * @author psamatt
 */
public class ExpressionSyntaxViolation extends IllegalArgumentException {

    public ExpressionSyntaxViolation(String element) {
        super(String.format("Unexpected Syntax Found: %s", element));
    }
}
