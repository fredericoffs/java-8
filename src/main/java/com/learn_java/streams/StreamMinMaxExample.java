package com.learn_java.streams;

import java.util.List;
import java.util.Optional;

public class StreamMinMaxExample {

    public static Optional<Integer> findMinValueOptional(List<Integer> integerList) {
        return integerList.stream()
                .reduce((x, y) -> x < y ? x : y);
    }

    public static Optional<Integer> findMaxValueOptional(List<Integer> integerList) {
        return integerList.stream()
                .reduce((x, y) -> x > y ? x : y);
    }

    public static void main(String[] args) {
        List<Integer> integerList = List.of(6, 7, 8, 9, 10);
//        List<Integer> integerList = new ArrayList<>();

        Optional<Integer> maxValueOptional = findMaxValueOptional(integerList);

        if (maxValueOptional.isPresent()) {
            System.out.println("MaxValueOptional is: " + maxValueOptional.get());
        } else {
            System.out.println("Max Value not found! " + maxValueOptional);
        }

        Optional<Integer> minValueOptional = findMinValueOptional(integerList);

        if (minValueOptional.isPresent()) {
            System.out.println("MinValueOptional is: " + minValueOptional.get());
        } else {
            System.out.println("Minimum Value not found! " + minValueOptional);
        }

    }
}
