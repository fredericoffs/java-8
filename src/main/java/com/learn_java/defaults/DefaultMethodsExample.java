package com.learn_java.defaults;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodsExample {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Fred", "Adam", "Ann", "Mike", "Zebra", "Eric", "Peter");

//        System.out.println(strings.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
//        System.out.println(strings.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()));

        strings.sort(Comparator.naturalOrder());
        System.out.println("Sorted list using List.Sort(): " + strings);

        strings.sort(Comparator.reverseOrder());
        System.out.println("Sorted list using List.Sort() reverse: " + strings);
    }
}
