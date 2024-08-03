package com.learn_java.numeric_streams;

import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamMapExample {

//    public static List<Integer> mapToObject() {
//        return IntStream.rangeClosed(1, 5)
//                //can be replace by boxed()
//                .mapToObj(i -> {
//                    return Integer.valueOf(i);
//                })
//                .toList();
//    }

    public static long mapToLong(){
        return IntStream.rangeClosed(1,5)
                //convert intStream to longStream
                .mapToLong(i->i)
                .sum();
    }

    public static double mapToDouble(){
        return IntStream.rangeClosed(1,5)
                //convert intStream to doubleStream
                .mapToDouble(i->i)
                .sum();
    }

    public static void main(String[] args) {
//        System.out.println("   mapToObj: " + mapToObject());
        System.out.println("  mapToLong: " + mapToLong());
        System.out.println("mapToDouble: " + mapToDouble());
    }
}
