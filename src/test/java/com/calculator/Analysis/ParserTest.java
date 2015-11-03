package com.calculator.Analysis;

import com.calculator.Analysis.Expression.AdditionExpression;
import com.calculator.Analysis.Expression.ConstantExpression;
import com.calculator.Analysis.Expression.ExpressionInterface;
import com.calculator.Analysis.Expression.MultiplicationExpression;
import com.calculator.Analysis.Token.Number;
import com.calculator.Analysis.Token.Operator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class ParserTest {
    @Test // 3
    public void it_should_parse_single_number() {
        TokenStream stream = new TokenStream();
        stream.addToken(new Number("3"));

        Parser parser = new Parser();
        ExpressionInterface tree = parser.parse(stream);

        ConstantExpression expression = new ConstantExpression(3);

        assertTrue(tree.isEqualTo(expression));
    }

    @Test // 3 + 3
    public void it_should_parse_three_plus_three() {
        TokenStream stream = new TokenStream();
        stream.addToken(new Number("3"));
        stream.addToken(new Operator("+"));
        stream.addToken(new Number("3"));

        Parser parser = new Parser();
        ExpressionInterface tree = parser.parse(stream);

        AdditionExpression expression = new AdditionExpression(new ConstantExpression(3), new ConstantExpression(3));

        assertTrue(tree.isEqualTo(expression));
    }

    @Test // 3 + 3 * 3
    public void it_should_parse_three_plus_three_multiply_three() {
        TokenStream stream = new TokenStream();
        stream.addToken(new Number("3"));
        stream.addToken(new Operator("+"));
        stream.addToken(new Number("3"));
        stream.addToken(new Operator("*"));
        stream.addToken(new Number("3"));

        Parser parser = new Parser();
        ExpressionInterface tree = parser.parse(stream);

        MultiplicationExpression innerExpression = new MultiplicationExpression(new ConstantExpression(3), new ConstantExpression(3));
        AdditionExpression expression = new AdditionExpression(new ConstantExpression(3), innerExpression);

        assertTrue(tree.isEqualTo(expression));
    }

    @Test // 3 + 3 * 3 + 3
    public void it_should_parse_three_plus_three_multiply_three_plus_three() {
        TokenStream stream = new TokenStream();
        stream.addToken(new Number("3"));
        stream.addToken(new Operator("+"));
        stream.addToken(new Number("3"));
        stream.addToken(new Operator("*"));
        stream.addToken(new Number("3"));
        stream.addToken(new Operator("+"));
        stream.addToken(new Number("3"));

        Parser parser = new Parser();
        ExpressionInterface tree = parser.parse(stream);

        MultiplicationExpression multiplication = new MultiplicationExpression(new ConstantExpression(3), new ConstantExpression(3));
        AdditionExpression addition1 = new AdditionExpression(new ConstantExpression(3), multiplication);
        AdditionExpression addition2 = new AdditionExpression(addition1, new ConstantExpression(3));

        assertTrue(tree.isEqualTo(addition2));
    }

    @Test // 3 * 3
    public void it_should_parse_three_multiply_three() {
        TokenStream stream = new TokenStream();
        stream.addToken(new Number("3"));
        stream.addToken(new Operator("*"));
        stream.addToken(new Number("3"));

        Parser parser = new Parser();
        ExpressionInterface tree = parser.parse(stream);

        MultiplicationExpression expression = new MultiplicationExpression(new ConstantExpression(3), new ConstantExpression(3));

        assertTrue(tree.isEqualTo(expression));
    }

    @Test // 3 * 3 * 3
    public void it_should_parse_three_multiply_three_multiply_three() {
        TokenStream stream = new TokenStream();
        stream.addToken(new Number("3"));
        stream.addToken(new Operator("*"));
        stream.addToken(new Number("3"));
        stream.addToken(new Operator("*"));
        stream.addToken(new Number("3"));

        Parser parser = new Parser();
        ExpressionInterface tree = parser.parse(stream);

        MultiplicationExpression innerExpression = new MultiplicationExpression(new ConstantExpression(3), new ConstantExpression(3));
        MultiplicationExpression expression = new MultiplicationExpression(innerExpression, new ConstantExpression(3));

        assertTrue(tree.isEqualTo(expression));
    }

    @Test // 3 * 3 + 3
    public void it_should_parse_three_multiply_three_add_three() {
        TokenStream stream = new TokenStream();
        stream.addToken(new Number("3"));
        stream.addToken(new Operator("*"));
        stream.addToken(new Number("3"));
        stream.addToken(new Operator("+"));
        stream.addToken(new Number("3"));

        Parser parser = new Parser();
        ExpressionInterface tree = parser.parse(stream);

        MultiplicationExpression innerExpression = new MultiplicationExpression(new ConstantExpression(3), new ConstantExpression(3));
        AdditionExpression expression = new AdditionExpression(innerExpression, new ConstantExpression(3));

        assertTrue(tree.isEqualTo(expression));
    }

    @Test // 3 * 3 + 3 * 3
    public void it_should_add_two_multiplications() {
        TokenStream stream = new TokenStream();
        stream.addToken(new Number("3"));
        stream.addToken(new Operator("*"));
        stream.addToken(new Number("3"));
        stream.addToken(new Operator("+"));
        stream.addToken(new Number("3"));
        stream.addToken(new Operator("*"));
        stream.addToken(new Number("3"));

        Parser parser = new Parser();
        ExpressionInterface tree = parser.parse(stream);

        MultiplicationExpression innerExpression1 = new MultiplicationExpression(new ConstantExpression(3), new ConstantExpression(3));
        MultiplicationExpression innerExpression2 = new MultiplicationExpression(new ConstantExpression(3), new ConstantExpression(3));

        AdditionExpression expression = new AdditionExpression(innerExpression1, innerExpression2);

        assertTrue(tree.isEqualTo(expression));
    }

    @Test(expected = ExpressionSyntaxViolation.class)
    public void it_cannot_parse_double_operator() {
        TokenStream stream = new TokenStream();
        stream.addToken(new Number("3"));
        stream.addToken(new Operator("+"));
        stream.addToken(new Operator("+"));

        Parser parser = new Parser();
        parser.parse(stream);
    }

    @Test(expected = ExpressionSyntaxViolation.class)
    public void it_cannot_parse_operator_as_last_token() {
        TokenStream stream = new TokenStream();
        stream.addToken(new Number("3"));
        stream.addToken(new Operator("+"));

        Parser parser = new Parser();
        parser.parse(stream);
    }
}