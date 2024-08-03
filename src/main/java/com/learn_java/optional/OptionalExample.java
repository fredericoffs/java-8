package com.learn_java.optional;

import com.learn_java.data.Student;

import java.util.Optional;

public class OptionalExample {

    public static Optional<String> getStudentNameOptional() {

//        Optional<Student> student = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> student = Optional.ofNullable(null);

        if (student.isPresent()) {
            return student.map(Student::getName);
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        Optional<String> stringOptional = getStudentNameOptional();
        if (stringOptional.isPresent()) {
            System.out.println("Length of the student name: " + stringOptional.get().length());
        } else {
            System.out.println("Name not found!");
        }
    }
}
