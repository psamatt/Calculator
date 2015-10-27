package com.calculator.Analysis.Token;

/**
 *
 */
public interface TokenInterface {

    /**
     * Get the value of the token
     *
     * @return String
     */
    String getValue();


    boolean equals(TokenInterface other);
}
