package com.learn_java.functional_interfaces;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    static UnaryOperator<String> unaryOperator = name -> name.concat(" default");

    public static void main(String[] args) {
        System.out.println("Result is: " + unaryOperator.apply("java8"));
    }
}
