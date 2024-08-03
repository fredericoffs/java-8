package com.learn_java;

import com.learn_java.data.Student;
import com.learn_java.data.StudentDataBase;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Objects.nonNull;

public class Knowledge {

    public static void main(String[] args) {

        Student student = StudentDataBase.studentSupplier.get();

        List<String> activities = student.getActivities();

        List<String> arraylist = new ArrayList<>(activities);
        arraylist.add("nova");

        student.setActivities(arraylist);

        System.out.println(student);

    }
}
