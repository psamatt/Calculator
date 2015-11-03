package com.calculator.Analysis.Expression;

import com.calculator.Analysis.Token.Operator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class ExpressionFactoryTest {
    @Test
    public void it_should_return_addition_node() {
        ExpressionInterface node = ExpressionFactory.get(new Operator("+"), new ConstantExpression(2), new ConstantExpression(4));

        assertEquals(node.getClass(), AdditionExpression.class);
    }

    @Test
    public void it_should_return_subtraction_node() {
        ExpressionInterface node = ExpressionFactory.get(new Operator("-"), new ConstantExpression(2), new ConstantExpression(4));

        assertEquals(node.getClass(), SubtractionExpression.class);
    }

    @Test
    public void it_should_return_division_node() {
        ExpressionInterface node = ExpressionFactory.get(new Operator("/"), new ConstantExpression(2), new ConstantExpression(4));

        assertEquals(node.getClass(), DivisionExpression.class);
    }

    @Test
    public void it_should_return_multiplication_node() {
        ExpressionInterface node = ExpressionFactory.get(new Operator("*"), new ConstantExpression(2), new ConstantExpression(4));

        assertEquals(node.getClass(), MultiplicationExpression.class);
    }
}