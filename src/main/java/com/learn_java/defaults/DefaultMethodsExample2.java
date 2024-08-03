package com.learn_java.defaults;

import com.learn_java.data.Student;
import com.learn_java.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultMethodsExample2 {

    static Consumer<Student> studentConsumer = System.out::println;
    static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
    static Comparator<Student> gradeComparator = Comparator.comparingInt(Student::getGradeLevel);
    static Comparator<Student> gpaComparator = Comparator.comparingDouble(Student::getGpa);

    public static void sortByName(List<Student> studentList) {
        System.out.println("After Sort: ");
        studentList.sort(Comparator.nullsFirst(nameComparator));
        studentList.forEach(studentConsumer);
    }

    public static void sortByGPA(List<Student> studentList) {
        System.out.println("After SortGPA: ");
        studentList.sort(Comparator.nullsFirst(gpaComparator));
        studentList.forEach(studentConsumer);
    }

    public static void comparatorChaining(List<Student> students) {
        System.out.println("After comparatorChaining: ");
        students.sort(Comparator.nullsLast(gradeComparator.thenComparing(nameComparator)));
        students.forEach(studentConsumer);

    }

    public static void main(String[] args) {
        List<Student> students = StudentDataBase.getAllStudents();
        System.out.println("Before Sort: ");
        students.forEach(studentConsumer);

        sortByName(students);
        sortByGPA(students);
        comparatorChaining(students);
    }
}
