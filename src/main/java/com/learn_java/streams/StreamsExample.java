package com.learn_java.streams;

import com.learn_java.data.Student;
import com.learn_java.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args) {

        Predicate<Student> studentPredicate = student -> student.getGradeLevel() >= 3;
        Predicate<Student> studentGpaPredicate = student -> student.getGpa() >= 3.9;
        //student name and their activities in map

        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().stream()
                .peek(student -> System.out.println("Elements  : " + student)) //to debug
                .filter(studentPredicate)
                .peek(student -> System.out.println("1st filter: " + student))
                .filter(studentGpaPredicate)
                .peek(student -> System.out.println("2nd filter: " + student))
                .collect(Collectors.toMap(Student::getName, Student::getActivities));

        System.out.println(studentMap);
    }
}
