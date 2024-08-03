package com.learn_java.streams_terminal;

import com.learn_java.data.Student;
import com.learn_java.data.StudentDataBase;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class StreamMappingExample {


    public static void main(String[] args) {
        List<String> namesList = StudentDataBase.getAllStudents()
                .stream()
                //.map(Student::getName)
                //.toList();
                .collect(mapping(Student::getName, toList()));
        System.out.println(namesList);

        Set<String> namesSet = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(toSet());
                //.collect(mapping(Student::getName, toSet()));
        System.out.println(namesSet);
    }
}
