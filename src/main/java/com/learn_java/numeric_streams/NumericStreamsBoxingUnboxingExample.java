package com.learn_java.numeric_streams;

import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamsBoxingUnboxingExample {

//    public static List<Integer> boxing() {
//        return IntStream.rangeClosed(1, 10)
//                //int
//                .boxed()
//                //toInteger
//                .toList();
//    }

    public static int unboxing(List<Integer> integerList) {
        //ToIntFunction<Integer> toIntValue = i -> i.intValue();
        //Wrapper to primitive
        return integerList.stream()
                .mapToInt(Integer::intValue)
//                .mapToInt(toIntValue)
                .sum();
    }

    public static void main(String[] args) {
//        List<Integer> integerList = boxing();
//
//        System.out.println("  Boxing: " + boxing());
//        System.out.println("Unboxing: " + unboxing(integerList));
    }
}
