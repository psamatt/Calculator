package com.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class CalculatorTest {

    @Test
    public void it_should_calculate_single_digit() {
        Calculator c = new Calculator();

        assertEquals(3, c.calculate("3"));
    }

    @Test
    public void it_should_calculate_simple_addition() {
        Calculator c = new Calculator();

        assertEquals(6, c.calculate("3+3"));
    }

    @Test
    public void it_should_calculate_double_added_mutliplication() {
        Calculator c = new Calculator();

        assertEquals(18, c.calculate("3*3+3*3"));
    }

    @Test
    public void it_should_calculate_multiplication_with_two_additions() {
        Calculator c = new Calculator();

        assertEquals(15, c.calculate("3+3*3+3"));
    }

    @Test
    public void it_should_calculate_multiplication_with_two_subtractions() {
        Calculator c = new Calculator();

        assertEquals(6, c.calculate("10-1*2-2"));
    }

    @Test
    public void it_should_calculate_multiplication_with_division() {
        Calculator c = new Calculator();

        assertEquals(10, c.calculate("10*10/10"));
    }

}