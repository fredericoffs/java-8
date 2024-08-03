package com.learn_java.optional;

import com.learn_java.data.Student;
import com.learn_java.data.StudentDataBase;

import java.util.Optional;

public class OptionalOrElseExample {

    //    OrElse
    public static String optionalOrElse() {
//        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> studentOptional = Optional.ofNullable(null);
        return studentOptional.map(Student::getName).orElse("Default");
    }

    //    OrElseGet
    public static String optionalOrElseGet() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
//        Optional<Student> studentOptional = Optional.ofNullable(null);
        return studentOptional.map(Student::getName).orElseGet(() -> "Default");
    }

//    OrElseThrow
public static String optionalOrElseThrow() {
//    Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> studentOptional = Optional.ofNullable(null);
    return studentOptional.map(Student::getName).orElseThrow(() -> new RuntimeException("No data available."));
}


    public static void main(String[] args) {
        System.out.println("orElse     : " + optionalOrElse());
        System.out.println("orElseGet  : " + optionalOrElseGet());
        System.out.println("orElseThrow: " + optionalOrElseThrow());
    }
}
