package com.calculator.Analysis.Token;

/**
 * Number Token
 *
 * @author psamatt
 */
final public class Number implements TokenInterface {

    private String regex = "[0-9]+";
    private String amount;

    public Number(String amount) {

        if (!amount.matches(regex)) {
            throw new IllegalArgumentException(String.format("Character %s is not an number", amount));
        }
        this.amount = amount;
    }

    @Override
    public boolean equals(TokenInterface other) {
        return this.getValue().equals(other.getValue());
    }

    @Override
    public String getValue() {
        return this.amount;
    }

    /**
     * Get the value as an integer
     *
     * @return
     */
    public int getValueAsInt() {
        return Integer.parseInt(this.amount);
    }
}
