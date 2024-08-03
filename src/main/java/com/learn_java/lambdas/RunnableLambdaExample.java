package com.learn_java.lambdas;

public class RunnableLambdaExample {

  public static void main(String[] args) {

    /*
    prior Java 8
     */

    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        System.out.println("inside runnable 1");
      }
    };

    new Thread(runnable).start();

    /*
    Java 8 lambda
     */

    Runnable runnableLambda = () -> System.out.println("inside runnable lambda");

    new Thread(runnableLambda).start();
  }
}
