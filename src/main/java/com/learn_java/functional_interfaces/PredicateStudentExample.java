package com.learn_java.functional_interfaces;

import com.learn_java.data.Student;
import com.learn_java.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {

    static Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
    static Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;
    //static Predicate<Student> max = (s) -> s.getGpa()

    public static void filterStudentsByGradeLevel() {
        System.out.println("filterStudentsByGradeLevel ===========================");
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach((student -> {
            if (p1.test(student)) {
                System.out.println(student);
            }
        }));
    }

    public static void filterStudentsByGpa() {
        System.out.println("filterStudentsByGpa ===========================");
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach((student -> {
            if (p2.test(student)) {
                System.out.println(student);
            }
        }));
    }

    public static void filterStudents() {
        System.out.println("filterStudents ===========================");
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach((student -> {
            if (p1.or(p2).negate().test(student)) {
                System.out.println(student);
            } else {
                System.out.println(student);
            }
        }));
    }

    public static void main(String[] args) {
        //filterStudentsByGradeLevel();
        //filterStudentsByGpa();
        filterStudents();
    }
}
