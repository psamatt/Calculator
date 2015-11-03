package com.calculator.Analysis.Expression;

import com.calculator.Analysis.Token.Operator;

/**
 * Factory for expressions
 *
 * @author psamatt
 */
public class ExpressionFactory {

    private ExpressionFactory() {}

    /**
     * Get an expression
     *
     * @param operator
     * @param node1
     * @param node2
     * @return
     */
    public static ExpressionInterface get(Operator operator, ExpressionInterface node1, ExpressionInterface node2) {
        switch (operator.getValue()) {
            case "+":
                return new AdditionExpression(node1, node2);
            case "-":
                return new SubtractionExpression(node1, node2);
            case "*":
                return new MultiplicationExpression(node1, node2);
            case "/":
                return new DivisionExpression(node1, node2);
            default:
                throw new IllegalArgumentException("operator not valid");
        }
    }
}
