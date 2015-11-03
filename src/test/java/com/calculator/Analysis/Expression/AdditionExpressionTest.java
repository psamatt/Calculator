package com.calculator.Analysis.Expression;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class AdditionExpressionTest {

    @Test
    public void it_should_add_two_constants() {
        AdditionExpression expression = new AdditionExpression(new ConstantExpression(4), new ConstantExpression(2));

        assertEquals(6, expression.getValue());
    }

    @Test
    public void it_should_add_constant_with_multiplication_expression() {

        MultiplicationExpression multiplicationExpression = new MultiplicationExpression(new ConstantExpression(4), new ConstantExpression(2));
        AdditionExpression additionExpression = new AdditionExpression(new ConstantExpression(100), multiplicationExpression);

        assertEquals(108, additionExpression.getValue());
    }

    @Test
    public void it_should_add_multi_level_expression() {

        MultiplicationExpression multiplicationExpression = new MultiplicationExpression(new ConstantExpression(4), new ConstantExpression(2));
        AdditionExpression expression1 = new AdditionExpression(new ConstantExpression(4), multiplicationExpression);
        AdditionExpression expression2 = new AdditionExpression(new ConstantExpression(1), expression1);

        assertEquals(13, expression2.getValue());
    }

    @Test
    public void it_should_be_equal_to_identical_expression() {
        AdditionExpression expression1 = new AdditionExpression(new ConstantExpression(4), new ConstantExpression(2));
        AdditionExpression expression2 = new AdditionExpression(new ConstantExpression(4), new ConstantExpression(2));

        assertTrue(expression1.isEqualTo(expression2));
    }

    @Test
    public void it_should_not_be_equal_to_different_expression() {
        AdditionExpression expression1 = new AdditionExpression(new ConstantExpression(4), new ConstantExpression(2));
        AdditionExpression expression2 = new AdditionExpression(new ConstantExpression(2), new ConstantExpression(4));

        assertFalse(expression1.isEqualTo(expression2));
    }

    @Test
    public void it_should_not_be_equal_to_different_type_of_expression() {
        AdditionExpression expression1 = new AdditionExpression(new ConstantExpression(4), new ConstantExpression(2));
        SubtractionExpression expression2 = new SubtractionExpression(new ConstantExpression(2), new ConstantExpression(4));

        assertFalse(expression1.isEqualTo(expression2));
    }
}