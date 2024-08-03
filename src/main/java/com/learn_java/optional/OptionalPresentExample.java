package com.learn_java.optional;

import java.util.Optional;

public class OptionalPresentExample {


    public static void main(String[] args) {
        //isPresent
        Optional<String> optional = Optional.ofNullable("nn");
//        System.out.println("optional.isPresent() " + optional.isPresent());
//        if (optional.isPresent()) {
//            System.out.println("isPresent" + optional.get());
//        }

        //ifPresent
        optional.ifPresent(System.out::println);
    }
}
