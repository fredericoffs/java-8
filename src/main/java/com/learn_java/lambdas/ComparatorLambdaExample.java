package com.learn_java.lambdas;

import java.util.Comparator;

public class ComparatorLambdaExample {

  public static void main(String[] args) {

    Comparator<Integer> comparator = new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    };
    System.out.println("Result of the comparator        is: " + comparator.compare(3,2));

    Comparator<Integer> comparatorLambda = (Integer a, Integer b) -> a.compareTo(b);
    System.out.println("Result of the comparatorLambda  is: " + comparatorLambda.compare(3,2));

    Comparator<Integer> comparatorLambda1 = (a, b) -> a.compareTo(b);
    System.out.println("Result of the comparatorLambda1 is: " + comparatorLambda1.compare(3,2));

    Comparator<Integer> methodReference = Integer::compareTo;
    System.out.println("Result of the methodReference   is: " + methodReference.compare(3,2));
  }

}
