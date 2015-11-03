package com.calculator.Analysis.Token;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class NumberTest {
    @Test
    public void it_should_accept_zero () {
        new Number("0");
    }

    @Test
    public void it_should_accept_single_digit () {
        new Number("1");
    }

    @Test
    public void it_should_accept_multiple_digits () {
        new Number("12345");
    }

    @Test(expected = IllegalArgumentException.class)
    public void it_should_not_accept_letter () {
        new Number("a");
    }
}