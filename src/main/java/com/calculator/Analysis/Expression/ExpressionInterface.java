package com.calculator.Analysis.Expression;

/**
 *
 */
public interface ExpressionInterface {

    /**
     * Get the value of the expression npde
     *
     * @return
     */
    int getValue();

    /**
     * Is equal to
     * (own interpretation of equals method)
     * @param node The node to compare
     * @return boolean
     */
    boolean isEqualTo(ExpressionInterface node);
}
