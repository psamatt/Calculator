package com.calculator.Analysis.Token;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class OperatorTest {
    @Test
    public void it_should_accept_plus_sign () {
        new Operator("+");
    }

    @Test
    public void it_should_accept_minus_sign () {
        new Operator("-");
    }

    @Test
    public void it_should_accept_multiply_sign () {
        new Operator("*");
    }

    @Test
    public void it_should_accept_divide_sign () {
        new Operator("/");
    }

    @Test(expected = IllegalArgumentException.class)
    public void it_should_not_accept_letter () {
        new Operator("a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void it_should_not_accept_number () {
        new Operator("1");
    }

    @Test
    public void it_should_recognise_add_to_not_be_high_priority() {
        Operator operator = new Operator("+");
        assertFalse(operator.isHighPriority());
    }

    @Test
    public void it_should_recognise_subtract_to_not_be_high_priority() {
        Operator operator = new Operator("-");
        assertFalse(operator.isHighPriority());
    }

    @Test
    public void it_should_recognise_multiply_to_be_high_priority() {
        Operator operator = new Operator("*");
        assertTrue(operator.isHighPriority());
    }

    @Test
    public void it_should_recognise_divide_to_be_high_priority() {
        Operator operator = new Operator("/");
        assertTrue(operator.isHighPriority());
    }

    @Test
    public void it_should_be_division() {
        Operator operator = new Operator("/");
        assertTrue(operator.isDivision());
    }

    @Test
    public void it_should_be_multipication() {
        Operator operator = new Operator("*");
        assertTrue(operator.isMultiplication());
    }
}