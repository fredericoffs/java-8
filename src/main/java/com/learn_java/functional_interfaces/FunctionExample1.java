package com.learn_java.functional_interfaces;

import static com.learn_java.functional_interfaces.FunctionExample.addSomeString;

public class FunctionExample1 {

    public static String performConcat(String str) {
        return addSomeString.apply(str);
    }

    public static void main(String[] args) {
        String result = performConcat("Hello");
        System.out.println(result);
    }
}
