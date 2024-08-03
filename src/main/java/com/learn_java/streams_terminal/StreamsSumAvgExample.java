package com.learn_java.streams_terminal;

import com.learn_java.data.Student;
import com.learn_java.data.StudentDataBase;

import static java.util.stream.Collectors.averagingInt;

public class StreamsSumAvgExample {

    public static int sum() {
        return StudentDataBase.getAllStudents()
                .stream()
                .mapToInt(Student::getNotebooks)
                .sum();
//                .collect(summingInt(Student::getNotebooks));
    }

    public static double avg(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(averagingInt(Student::getNotebooks));
    }

    public static void main(String[] args) {
        System.out.println("Total No of notebooks: " + sum());
        System.out.println("Average of notebooks: " + avg());
    }
}
