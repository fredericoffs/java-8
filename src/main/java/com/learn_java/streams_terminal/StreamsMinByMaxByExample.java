package com.learn_java.streams_terminal;

import com.learn_java.data.Student;
import com.learn_java.data.StudentDataBase;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsMinByMaxByExample {

    public static Optional<String> minByExample(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)))
                .map(Student::getName);
    }

    public static Optional<String> maxByExample(){
        return StudentDataBase.getAllStudents()
                .stream()
                .max(Comparator.comparing(Student::getGpa))
                .map(Student::getName);
    }

    public static void main(String[] args) {
        System.out.println(minByExample().isPresent() ? minByExample().get() : "Num tem");
        System.out.println(maxByExample().isPresent() ? maxByExample().get() : "Num tem");
    }
}
