package com.learn_java.streams;

import com.learn_java.data.Student;
import com.learn_java.data.StudentDataBase;

public class StreamMapReduceExample {

    private static int noOfNotebooks() {
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> "female".equals(student.getGender()))
                .filter(student -> student.getGradeLevel() >= 3)
                .map(Student::getNotebooks)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println("noOfNotebooks: " + noOfNotebooks());
    }
}
