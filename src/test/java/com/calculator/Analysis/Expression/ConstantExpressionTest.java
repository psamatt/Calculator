package com.calculator.Analysis.Expression;

import com.calculator.Analysis.Expression.ConstantExpression;
import com.calculator.Analysis.Expression.SubtractionExpression;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class ConstantExpressionTest {

    @Test
    public void it_should_get_value_of_constant() {
        ConstantExpression constant = new ConstantExpression(4);

        assertEquals(4, constant.getValue());
    }

    @Test
    public void it_should_be_equal_to_identical_expression() {
        ConstantExpression expression1 = new ConstantExpression(2);
        ConstantExpression expression2 = new ConstantExpression(2);

        assertTrue(expression1.isEqualTo(expression2));
    }

    @Test
    public void it_should_not_be_equal_to_different_expression() {
        ConstantExpression expression1 = new ConstantExpression(2);
        ConstantExpression expression2 = new ConstantExpression(4);

        assertFalse(expression1.isEqualTo(expression2));
    }

    @Test
    public void it_should_not_be_equal_to_different_type_of_expression() {
        ConstantExpression expression1 = new ConstantExpression(2);
        SubtractionExpression expression2 = new SubtractionExpression(new ConstantExpression(2), new ConstantExpression(4));

        assertFalse(expression1.isEqualTo(expression2));
    }
}
