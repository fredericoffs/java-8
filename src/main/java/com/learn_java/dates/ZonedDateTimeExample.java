package com.learn_java.dates;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class ZonedDateTimeExample {

    public static void main(String[] args) {

        ZonedDateTime stringParse = ZonedDateTime.parse("2024-02-28T17:28:10.00101Z");
        System.out.println("stringParse: " + stringParse);

        List<String> scheduledList = List.of("13:00", "14:00", "04:00");

        String nextDateTime = String.valueOf(scheduledList.stream()
                .sorted()
                .filter(s -> LocalTime.parse(s).isAfter(LocalTime.now()))
                .findFirst()
                .orElse(String.valueOf(scheduledList.stream().sorted().findFirst().get())));
        System.out.println("nextDateTime: " + nextDateTime);

        String stringLocalDateTime = LocalDate.now().toString()+"T12:00:00.999Z";
        ZonedDateTime resultZoned = ZonedDateTime.parse(stringLocalDateTime);
        System.out.println("result: " + resultZoned);

        String timeZ = "2024-02-08T10:37:52.525Z";
        ZonedDateTime zonedDateTimeZ = ZonedDateTime.parse(timeZ);
        System.out.println("zonedDateTimeZ : " + zonedDateTimeZ);

        ZonedDateTime zonedDateTime = ZonedDateTime.now(); //gets you this machines TimeZone
        System.out.println("zonedDateTime : " + zonedDateTime);

        ZoneOffset zoneOffset = zonedDateTime.getOffset();
        System.out.println("zoneOffset : " + zoneOffset);

        ZoneId zoneId = zonedDateTime.getZone();
        System.out.println("zoneId : " + zoneId.getId());

//         System.out.println("getAvailableZoneIds : " + ZoneId.getAvailableZoneIds());

        ZoneId.getAvailableZoneIds()
                .forEach(zone -> {
                    System.out.println("zone : " + zone);
                });
        System.out.println("no Of Zones : " + ZoneId.getAvailableZoneIds().size());


        //America/Chicago
        //America/Detroit
        //America/Los_Angeles
        //America/Phoenix

        /**
         * Times in each zone
         */
        System.out.println("Chicago CST: " + ZonedDateTime.now(ZoneId.of("America/Chicago")));
        System.out.println("Detroit EST: " + ZonedDateTime.now(ZoneId.of("America/Detroit")));
        System.out.println("LA PST     : " + ZonedDateTime.now(ZoneId.of("America/Los_Angeles")));
        System.out.println("Denver MST : " + ZonedDateTime.now(ZoneId.of("America/Denver")));

        System.out.println("Sao Paulo  : " + ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")));

        /**
         *
         */
        System.out.println("ZonedDate Time using Clock : "
                + ZonedDateTime.now(Clock.system(ZoneId.of("America/Sao_Paulo"))));


        /**
         * Local Date time using Zone Id.
         */
        System.out.println("Current Time of the Machine CST: " + LocalDateTime.now());

        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        System.out.println("Sao Paulo : " + localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.now(Clock.system(ZoneId.of("America/Detroit")));
        System.out.println("Detroit : " + localDateTime1);

        /**
         * LocalDateTime using Instant
         */
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.println("Instant LocalDate time :" + localDateTime2);


        /**
         * Convert LocalDateTime to ZonedDateTime
         */
        ZonedDateTime zonedDateTime1 = localDateTime.atZone(ZoneId.of("America/Chicago"));
        System.out.println("LocalDateTime to Zoned : " + zonedDateTime1);

        ZonedDateTime zonedDateTime2 = Instant.now().atZone(ZoneId.of("America/Sao_Paulo"));
        System.out.println("Instant to Zoned : " + zonedDateTime2);

        /**
         * Convert LocalDateTime to OffsetDateTime
         */
        OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.ofHours(-6));
        System.out.println("offsetDateTime : " + offsetDateTime);


    }
}
