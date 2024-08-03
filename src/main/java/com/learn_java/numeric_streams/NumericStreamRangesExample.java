package com.learn_java.numeric_streams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamRangesExample {

    public static void main(String[] args) {

        System.out.println("Range Count: " + IntStream.range(1, 50).count());
        IntStream.range(1, 50)
                .forEach(value -> System.out.print(value + ","));

        System.out.println();

        System.out.println("Range Closed count: " + IntStream.rangeClosed(1, 50).count());
        IntStream.rangeClosed(1, 50)
                .forEach(value -> System.out.print(value + ","));

        System.out.println();

        System.out.println("Long Stream Range Closed count: " + LongStream.rangeClosed(1, 50).count());
        LongStream.rangeClosed(1, 50)
                .forEach(value -> System.out.print(value + ","));

        System.out.println();
        System.out.print(
                "IntStream as Double: "
        );

        IntStream.rangeClosed(1, 50)
                .asDoubleStream()
                .forEach(v -> System.out.print(v + ","));
    }

}
