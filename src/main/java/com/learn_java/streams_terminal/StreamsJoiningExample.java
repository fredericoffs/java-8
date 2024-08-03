package com.learn_java.streams_terminal;

import com.learn_java.data.Student;
import com.learn_java.data.StudentDataBase;

import static java.util.stream.Collectors.joining;

public class StreamsJoiningExample {

    public static String joining1() {
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(joining());
    }

    public static String joining2() {
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(joining(" - "));
    }

    public static String joining3() {
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(joining(" - ","(",")"));
    }

    public static void main(String[] args) {
        System.out.println("joining 1: " + joining1());
        System.out.println("joining 2: " + joining2());
        System.out.println("joining 3: " + joining3());
    }
}
