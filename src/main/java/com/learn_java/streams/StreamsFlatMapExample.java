package com.learn_java.streams;

import com.learn_java.data.Student;
import com.learn_java.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsFlatMapExample {

    public static List<String> printStudentActivities() {
        List<String> studentActivities = StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        return studentActivities;
    }

    public static Set<String> printStudentActivitiesSet() {
        Set<String> studentActivitiesSet = StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(Collectors.toSet());
        return studentActivitiesSet;
    }

    public static List<String> printStudentActivitiesDistinct() {
        List<String> studentActivities = StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        return studentActivities;
    }

    public static long getStudentActivitiesCount() {
        long noOfstudentActivities = StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();
        return noOfstudentActivities;
    }

    public static List<String> printStudentActivitiesDistinctSorted() {
        List<String> studentActivities = StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        return studentActivities;
    }

    public static void main(String[] args) {
        System.out.println("printStudentActivities               : " + printStudentActivities());
        System.out.println("printStudentActivitiesSet            : " + printStudentActivitiesSet());
        System.out.println("printStudentActivitiesDistinct       : " + printStudentActivitiesDistinct());
        System.out.println("getStudentActivitiesCount            : " + getStudentActivitiesCount());
        System.out.println("printStudentActivitiesDistinctSorted : " + printStudentActivitiesDistinctSorted());

    }
}
