package com.calculator.Analysis.Expression;

import com.calculator.Analysis.Expression.AdditionExpression;
import com.calculator.Analysis.Expression.ConstantExpression;
import com.calculator.Analysis.Expression.MultiplicationExpression;
import com.calculator.Analysis.Expression.SubtractionExpression;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class SubtractionExpressionTest {

    @Test
    public void it_should_subtract_two_constants() {
        SubtractionExpression expression = new SubtractionExpression(new ConstantExpression(4), new ConstantExpression(2));

        assertEquals(2, expression.getValue());
    }

    @Test
    public void it_should_subtract_constant_with_multiplication_expression() {

        MultiplicationExpression multiplicationExpression = new MultiplicationExpression(new ConstantExpression(4), new ConstantExpression(2));
        SubtractionExpression subtractionExpression = new SubtractionExpression(new ConstantExpression(100), multiplicationExpression);

        assertEquals(92, subtractionExpression.getValue());
    }

    @Test
    public void it_should_be_equal_to_identical_expression() {
        SubtractionExpression expression1 = new SubtractionExpression(new ConstantExpression(4), new ConstantExpression(2));
        SubtractionExpression expression2 = new SubtractionExpression(new ConstantExpression(4), new ConstantExpression(2));

        assertTrue(expression1.isEqualTo(expression2));
    }

    @Test
    public void it_should_not_be_equal_to_different_expression() {
        SubtractionExpression expression1 = new SubtractionExpression(new ConstantExpression(4), new ConstantExpression(2));
        SubtractionExpression expression2 = new SubtractionExpression(new ConstantExpression(2), new ConstantExpression(4));

        assertFalse(expression1.isEqualTo(expression2));
    }

    @Test
    public void it_should_not_be_equal_to_different_type_of_expression() {
        SubtractionExpression expression1 = new SubtractionExpression(new ConstantExpression(4), new ConstantExpression(2));
        AdditionExpression expression2 = new AdditionExpression(new ConstantExpression(2), new ConstantExpression(4));

        assertFalse(expression1.isEqualTo(expression2));
    }
}