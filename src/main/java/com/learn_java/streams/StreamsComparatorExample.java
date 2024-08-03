package com.learn_java.streams;

import com.learn_java.data.Student;
import com.learn_java.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsComparatorExample {

    static Function<Student, String> functionNameCompare = Student::getName;
    static Function<Student, Double> functionGpaCompare = Student::getGpa;

    public static List<Student> sortStudentsByName() {
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(functionNameCompare))
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentsByGpa() {
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(functionGpaCompare))
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentsByGpaDesc() {
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(functionGpaCompare).reversed())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("Students sorted by name: ");
        sortStudentsByName().forEach(System.out::println);

        System.out.println("Students sorted by gpa: ");
        sortStudentsByGpa().forEach(System.out::println);

        System.out.println("Students sorted by gpa desc: ");
        sortStudentsByGpaDesc().forEach(System.out::println);

    }
}
