package com.calculator.Analysis.Expression;

/**
 * Addition Expression
 *
 * @author psamatt
 */
public class AdditionExpression implements ExpressionInterface {

    private ExpressionInterface node1;
    private ExpressionInterface node2;

    public AdditionExpression(ExpressionInterface node1, ExpressionInterface node2) {
        this.node1 = node1;
        this.node2 = node2;
    }

    @Override
    public int getValue() {
        return this.node1.getValue() + this.node2.getValue();
    }

    @Override
    public boolean isEqualTo(ExpressionInterface node) {

        if (!(node instanceof AdditionExpression)) {
            return false;
        }

        AdditionExpression other = (AdditionExpression) node;

        return node1.isEqualTo(other.node1) && node2.isEqualTo(other.node2);
    }
}
