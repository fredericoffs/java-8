package com.learn_java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {

    public static Optional<Integer> limit(List<Integer> integers) {
        return integers.stream()
                .limit(2)
                .reduce(Integer::sum);
    }

    public static Optional<Integer> skip(List<Integer> integers) {
        return integers.stream()
                .skip(3)
                .reduce(Integer::sum);
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(6, 7, 8, 9, 10);

        Optional<Integer> limitResult = limit(integers);
        if (limitResult.isPresent()){
            System.out.println("limit 2: " + limitResult.get());
        } else {
            System.out.println(" no value limit.");
        }

        Optional<Integer> skipResult = skip(integers);
        if (skipResult.isPresent()){
            System.out.println("skip 3: " + skipResult.get());
        } else {
            System.out.println(" no value skip.");
        }
    }
}
