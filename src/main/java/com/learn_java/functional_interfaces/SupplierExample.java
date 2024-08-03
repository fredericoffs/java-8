package com.learn_java.functional_interfaces;

import com.learn_java.data.Student;
import com.learn_java.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        Supplier<Student> studentSupplier = () ->
                new Student("One student", 1, 1.1, "gender", Arrays.asList("activity 1", "activity 2", "activity 3"));

        System.out.println("Student is: " + studentSupplier.get());

        Supplier<List<Student>> listSupplier = () -> StudentDataBase.getAllStudents();

        System.out.println("Students are: " + listSupplier.get());
    }
}
