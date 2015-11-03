package com.calculator.Analysis;

import com.calculator.Analysis.Token.Number;
import com.calculator.Analysis.Token.Operator;
import com.calculator.Analysis.Token.TokenInterface;

import java.util.LinkedList;

/**
 * A stream of tokens
 *
 * @author psamatt
 */
final public class TokenStream {

    private LinkedList tokens;

    public TokenStream() {
        this.tokens = new LinkedList<>();
    }

    /**
     * Add Token
     *
     * @param token
     */
    public void addToken(TokenInterface token) {
        this.tokens.add(token);
    }

    /**
     * Pop an item off the queue FIFO style
     *
     * @return TokenInterface
     */
    public TokenInterface pop() {
        return (TokenInterface)this.tokens.pop();
    }

    /**
     * Is the next item an operator
     *
     * @return
     */
    public boolean isNextItemAnOperator() {
        return this.tokens.peek() instanceof Operator;
    }

    /**
     * Is the next item a number
     *
     * @return
     */
    public boolean isNextItemANumber() {
        return this.tokens.peek() instanceof Number;
    }

    /**
     * Peek at the next token
     *
     * @return TokenInterface
     */
    public TokenInterface peek() {
        return (TokenInterface)this.tokens.peek();
    }

    /**
     * Does the token stream have a next item
     *
     * @return
     */
    public boolean hasNextItem() {
        return this.tokens.peek() != null;
    }

    @Override
    public boolean equals(Object obj) {

        TokenStream other = (TokenStream) obj;

        if (tokens.size() != other.tokens.size()) {
            return false;
        }

        for (int i = 0; i < tokens.size(); i++) {
            if (!((TokenInterface)tokens.get(i)).equals((TokenInterface) other.tokens.get(i))) {
                return false;
            }
        }

        return true;
    }
}
