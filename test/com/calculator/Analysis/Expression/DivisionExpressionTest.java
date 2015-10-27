package com.calculator.Analysis.Expression;

import com.calculator.Analysis.Expression.ConstantExpression;
import com.calculator.Analysis.Expression.DivisionExpression;
import com.calculator.Analysis.Expression.SubtractionExpression;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class DivisionExpressionTest {

    @Test
    public void it_should_divide_simple_expression() {
        DivisionExpression expression = new DivisionExpression(new ConstantExpression(4), new ConstantExpression(2));

        assertEquals(2, expression.getValue());
    }

    @Test
    public void it_should_round_expression_with_remainder() {
        DivisionExpression expression = new DivisionExpression(new ConstantExpression(5), new ConstantExpression(2));

        assertEquals(2, expression.getValue());
    }

    @Test
    public void it_should_be_equal_to_identical_expression() {
        DivisionExpression expression1 = new DivisionExpression(new ConstantExpression(4), new ConstantExpression(2));
        DivisionExpression expression2 = new DivisionExpression(new ConstantExpression(4), new ConstantExpression(2));

        assertTrue(expression1.isEqualTo(expression2));
    }

    @Test
    public void it_should_not_be_equal_to_different_expression() {
        DivisionExpression expression1 = new DivisionExpression(new ConstantExpression(4), new ConstantExpression(2));
        DivisionExpression expression2 = new DivisionExpression(new ConstantExpression(2), new ConstantExpression(4));

        assertFalse(expression1.isEqualTo(expression2));
    }

    @Test
    public void it_should_not_be_equal_to_different_type_of_expression() {
        DivisionExpression expression1 = new DivisionExpression(new ConstantExpression(4), new ConstantExpression(2));
        SubtractionExpression expression2 = new SubtractionExpression(new ConstantExpression(2), new ConstantExpression(4));

        assertFalse(expression1.isEqualTo(expression2));
    }
}