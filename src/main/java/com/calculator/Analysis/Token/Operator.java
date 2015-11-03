package com.calculator.Analysis.Token;

/**
 * Operator Token
 *
 * @author psamatt
 */
final public class Operator implements TokenInterface {

    private String regex = "[+\\-\\*/]";
    private String operator;

    public Operator(String operator) {

        if (!operator.matches(regex)) {
            throw new IllegalArgumentException(String.format("Character %s is not an operator", operator));
        }
        this.operator = operator;
    }

    public boolean isHighPriority() {
        return operator.matches("[\\*/]");
    }

    @Override
    public boolean equals(TokenInterface other) {
        return this.getValue().equals(other.getValue());
    }

    @Override
    public String getValue() {
        return this.operator;
    }

    public boolean isMultiplication() {
        return this.operator.matches("\\*");
    }

    public boolean isDivision() {
        return this.operator.matches("/");
    }
}
