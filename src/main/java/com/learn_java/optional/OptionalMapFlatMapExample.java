package com.learn_java.optional;

import com.learn_java.data.Bike;
import com.learn_java.data.Student;
import com.learn_java.data.StudentDataBase;

import java.util.Optional;

public class OptionalMapFlatMapExample {

    //    filter
    public static void optionalFilter() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        studentOptional
                .filter(student -> student.getGpa() >= 3.5)
                .ifPresent(s -> System.out.println(s));
    }

    //    flatMap
    public static void optionalFlatMap() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<String> name = studentOptional.filter(s -> s.getGpa() >= 3.5)
                .flatMap(Student::getBike)
                .map(Bike::getName);
        name.ifPresent(s -> System.out.println("name: " + s));
    }

    //    map
    public static void optionalMap() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        if (studentOptional.isPresent()) {
            Optional<String> s = studentOptional.filter(student -> student.getGpa() >= 3.5)
                    .map(Student::getName);
            System.out.println(s.get());
        }
    }

    public static void main(String[] args) {
        optionalFilter();
        optionalMap();
        optionalFlatMap();
    }
}
