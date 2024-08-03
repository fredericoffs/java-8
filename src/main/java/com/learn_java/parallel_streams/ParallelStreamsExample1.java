package com.learn_java.parallel_streams;

import com.learn_java.data.Student;
import com.learn_java.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamsExample1 {

    public static List<String> sequentialPrintStudentActivitiesDistinctSorted() {

        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Duration to execute the pipeline in sequential: " + (endTime - startTime));
        return studentActivities;

    }

    public static List<String> parallelPrintStudentActivitiesDistinctSorted() {

        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDataBase.getAllStudents()
                .parallelStream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Duration to execute the pipeline in parallel: " + (endTime - startTime));
        return studentActivities;

    }

    public static void main(String[] args) {
        sequentialPrintStudentActivitiesDistinctSorted();
        parallelPrintStudentActivitiesDistinctSorted();

    }
}
