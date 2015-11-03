package com.calculator.Analysis.Expression;

import com.calculator.Analysis.Token.Number;

/**
 * Constant Expression
 *
 * @author psamatt
 */
public class ConstantExpression implements ExpressionInterface {

    private int constant;

    public ConstantExpression(int constant) {
        this.constant = constant;
    }

    public static ConstantExpression fromNumberToken(Number number) {
        return new ConstantExpression(number.getValueAsInt());
    }

    @Override
    public int getValue() {
        return this.constant;
    }

    @Override
    public boolean isEqualTo(ExpressionInterface node) {

        if (!(node instanceof ConstantExpression)) {
            return false;
        }

        ConstantExpression other = (ConstantExpression) node;

        return constant == other.constant;
    }
}
