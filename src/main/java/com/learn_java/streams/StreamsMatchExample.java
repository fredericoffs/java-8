package com.learn_java.streams;

import com.learn_java.data.Student;
import com.learn_java.data.StudentDataBase;

import java.util.function.Predicate;

public class StreamsMatchExample {

    static Predicate<Student> predicateAllMatch = student -> student.getGpa() >= 3.5;
    static Predicate<Student> predicateAnyMatch = student -> student.getGpa() >= 4.0;
    static Predicate<Student> predicateNoneMatch = student -> student.getGpa() >= 4.1;

    public static boolean allMatch() {
        return StudentDataBase.getAllStudents()
                .stream()
                .allMatch(predicateAllMatch);
    }

    public static boolean anyMatch() {
        return StudentDataBase.getAllStudents()
                .stream()
                .anyMatch(predicateAnyMatch);
    }
    public static boolean noneMatch() {
        return StudentDataBase.getAllStudents()
                .stream()
                .noneMatch(predicateNoneMatch);
    }

    public static void main(String[] args) {
        System.out.println("Result of All match: " + allMatch());
        System.out.println("Result of Any match: " + anyMatch());
        System.out.println("Result of None match: " + noneMatch());

    }
}
