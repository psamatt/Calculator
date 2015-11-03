package com.calculator.Analysis.Expression;

import com.calculator.Analysis.Expression.ConstantExpression;
import com.calculator.Analysis.Expression.MultiplicationExpression;
import com.calculator.Analysis.Expression.SubtractionExpression;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class MultiplicationExpressionTest {

    @Test
    public void it_should_muiltiple_expression() {
        MultiplicationExpression expression = new MultiplicationExpression(
                new ConstantExpression(2),
                new ConstantExpression(3)
            );

        assertEquals(6, expression.getValue());
    }

    @Test
    public void it_should_be_equal_to_identical_expression() {
        MultiplicationExpression expression1 = new MultiplicationExpression(new ConstantExpression(4), new ConstantExpression(2));
        MultiplicationExpression expression2 = new MultiplicationExpression(new ConstantExpression(4), new ConstantExpression(2));

        assertTrue(expression1.isEqualTo(expression2));
    }

    @Test
    public void it_should_not_be_equal_to_different_expression() {
        MultiplicationExpression expression1 = new MultiplicationExpression(new ConstantExpression(4), new ConstantExpression(2));
        MultiplicationExpression expression2 = new MultiplicationExpression(new ConstantExpression(2), new ConstantExpression(4));

        assertFalse(expression1.isEqualTo(expression2));
    }

    @Test
    public void it_should_not_be_equal_to_different_type_of_expression() {
        MultiplicationExpression expression1 = new MultiplicationExpression(new ConstantExpression(4), new ConstantExpression(2));
        SubtractionExpression expression2 = new SubtractionExpression(new ConstantExpression(2), new ConstantExpression(4));

        assertFalse(expression1.isEqualTo(expression2));
    }
}