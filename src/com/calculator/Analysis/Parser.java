package com.calculator.Analysis;

import com.calculator.Analysis.Expression.ConstantExpression;
import com.calculator.Analysis.Expression.ExpressionInterface;
import com.calculator.Analysis.Expression.ExpressionFactory;
import com.calculator.Analysis.Token.Operator;
import com.calculator.Analysis.Token.TokenInterface;
import com.calculator.Analysis.Token.Number;

/**
 * Parse a TokenStream into a Abstract Syntax Tree (AST)
 *
 * @author psamatt
 */
final public class Parser {

    private TokenStream stream;

    public Parser() {}

    /**
     * Parse a token stream
     *
     * @param stream
     * @return ExpressionInterface
     */
    public ExpressionInterface parse(TokenStream stream) {

        this.stream = stream;

        return parseExpression();
    }

    /**
     * Parse the expression
     *
     * @return
     */
    private ExpressionInterface parseExpression() {
        TokenInterface token = this.stream.pop();

        if (!(token instanceof Number)) {
            throw new ExpressionSyntaxViolation(token.getValue());
        }

        return this.parseOperator(ConstantExpression.fromNumberToken((Number) token));
    }

    /**
     * Parse an upcoming operator
     *
     * @param expression
     * @return ExpressionInterface
     */
    private ExpressionInterface parseOperator(ExpressionInterface expression) {

        if (!this.stream.hasNextItem()) {
            return expression;
        }

        Operator operator = getNextOperator();
        ConstantExpression nextConstant = getNextConstant();

        if (operator.isHighPriority()) {
            return parseOperator(ExpressionFactory.get(operator, expression, nextConstant));
        }

        if (this.stream.hasNextItem() && this.stream.isNextItemAnOperator()) {
            // if 1+1*
            if (((Operator) this.stream.peek()).isHighPriority()) {

                Operator followingOperator = getNextOperator();
                ConstantExpression innerConstant = getNextConstant();
                ExpressionInterface innerExpression = ExpressionFactory.get(followingOperator, nextConstant, innerConstant);

                return parseOperator(ExpressionFactory.get(operator, expression, innerExpression));
            }
        }

        return parseOperator(ExpressionFactory.get(operator, expression, nextConstant));
    }

    /**
     * Get the next operator
     *
     * @return Operator
     */
    private Operator getNextOperator() {
        if (!this.stream.isNextItemAnOperator()) {
            throw new ExpressionSyntaxViolation("Operator expected");
        }

        Operator operator = (Operator) this.stream.pop();

        if (!this.stream.isNextItemANumber()) {
            throw new ExpressionSyntaxViolation("Number expected");
        }

        return operator;
    }

    /**
     * Get next constant
     *
     * @return ConstantExpression
     */
    private ConstantExpression getNextConstant() {
        Number number = (Number) this.stream.pop();
        return ConstantExpression.fromNumberToken(number);
    }
}
