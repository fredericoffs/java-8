package com.learn_java.streams_terminal;

import com.learn_java.data.StudentDataBase;

public class StreamsCountingExample {

    public static long count() {
        return StudentDataBase.getAllStudents()
                .stream()
                .filter(s -> s.getGpa() >= 3.9)
                //.collect(counting())
                .count();
    }

    public static void main(String[] args) {
        System.out.println(
                "count: " + count()
        );
    }
}
