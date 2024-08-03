package com.learn_java.functional_interfaces;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionExample {

    public static final String JAVA_8 = "java8";
    static Function<String, String> function = String::toUpperCase;
    static UnaryOperator<String> addSomeString = name -> name.concat(" default");

    public static void main(String[] args) {
        System.out.println("Result is: " + function.apply(JAVA_8));
        System.out.println("Result of andThen is: " + function.andThen(addSomeString).apply(JAVA_8));
        System.out.println("Result of compose is: " + function.compose(addSomeString).apply(JAVA_8));

    }
}
