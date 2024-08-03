package com.learn_java.dates;

import java.time.Duration;
import java.time.Instant;

public class InstantExample {

    public static void main(String[] args) {

        // Represents the date and time in unix timestamp
        // in a machine readable format.
        Instant instant = Instant.now();

        System.out.println("Instant.now(): " + instant);

        // Interface1 day has 86400 seconds.
        // What is EPOCH ? -> equal to Jan. 1st 1970
        System.out.println("getEpochSecond: " + instant.getEpochSecond()); //Jan. 1st 1970 -> 0 seconds
        //it does not support any of the methods which represents the time in human-readable format.

        Instant instant1 = Instant.ofEpochMilli(1);
        Instant instant3 = Instant.ofEpochSecond(700000000);
        System.out.println("instant1: " + instant1);
        System.out.println("instant3: " + instant3);

        Instant instant2 = Instant.now();

        Duration duration = Duration.between(instant, instant2);
        System.out.println("getNano: " + duration.getNano());

        Duration duration2 = Duration.between(instant, instant3);
        System.out.println("getSeconds: " + duration2.getSeconds());
    }
}