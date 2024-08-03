package com.learn_java.dates;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ComparingTimesDurationExample {

    public static void main(String[] args) {

        LocalTime localTime = LocalTime.of(7,20);

        LocalTime localTime1 = LocalTime.of(8,20);

        long minutesDiff= localTime.until(localTime1,ChronoUnit.SECONDS); // the end time is always exclusive
        System.out.println("until Minutes Diff : " + minutesDiff);

        Duration duration = Duration.between(localTime,localTime1);
        System.out.println("duration  : " +  duration.toMinutes());

        Duration duration1 = Duration.ofHours(3);
        System.out.println("toMinutes  : " +  duration1.toMinutes());

        Duration duration2 = Duration.ofMinutes(3);
        System.out.println("toMinutes  : " +  duration2.toMinutes());


        /**
         * LocalDateTime
         */
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2018,8,13,23,59);

        Duration duration3 = Duration.between(localDateTime,localDateTime1);

        System.out.println(duration3.toDays());

        /**
         * LocalDate - not supported
         */

        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2018, 8,13);

        Duration duration4 = Duration.between(localDate,localDate1);
        System.out.println(duration4.toDays());


    }
}
