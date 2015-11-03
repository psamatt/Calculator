package com.calculator;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> expressions = new ArrayList<String>();
        expressions.add("1+6");
        expressions.add("2*4");
        expressions.add("2+9*4");
        expressions.add("10/5+5");
        expressions.add("50-30/6");
        expressions.add("2*3+4*7");

        Calculator calculator = new Calculator();

        for (String expression : expressions) {
            System.out.println(expression + " = " + calculator.calculate(expression));
        }
    }
}
