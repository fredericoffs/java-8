package com.learn_java;

import com.learn_java.data.Student;
import com.learn_java.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.minBy;

public class FuncTest {

    public static void calculateLeastGpaStudentInEachGrade() {

        Map<Integer, Optional<Student>> studentMapOptional = StudentDataBase
                .getAllStudents()
                .stream()
                .collect(
                        groupingBy(Student::getGradeLevel,
                                minBy(Comparator.comparingDouble(Student::getGpa))
                        ));

        Stream.of(studentMapOptional).forEach(System.out::println);


        Map<Integer, Student> studentMap = StudentDataBase
                .getAllStudents()
                .stream()
                .collect(Collectors.
                        toMap(Student::getGradeLevel,
                                Function.identity(),
                                BinaryOperator.minBy(Comparator.comparingDouble(Student::getGpa))
                        )
                );

        Stream.of(studentMap).forEach(System.out::println);
    }


    public static void group() {
        List<Student> studentList =
                StudentDataBase
                        .getAllStudentsAndBikes();
        Stream.of(studentList).forEach(System.out::println);

    }

    public static void main(String[] args) {
        group();
    }
}