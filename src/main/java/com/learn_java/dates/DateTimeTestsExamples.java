package com.learn_java.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DateTimeTestsExamples {

    public static void main(String[] args) {


        var zoned = "2024-03-16T00:00-03:00";
        var zonedParsed = ZonedDateTime.parse(zoned).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXXXX"));
        System.out.println(zonedParsed);



        var localDateTime = LocalDateTime.parse("2024-03-11T16:00");
        System.out.println(localDateTime);

        var zonedDateTime2 = localDateTime.atZone(ZoneId.of("America/Sao_Paulo"));
        System.out.println(zonedDateTime2);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXXXX");
        System.out.println( LocalDateTime.parse("2024-03-15T14:00:00.001",DateTimeFormatter.ISO_DATE_TIME));

//        var ProgrammedDateTime = "2024-03-15T14:52:47.870";
//
//        ;
//        var zparse = ZonedDateTime.parse(ProgrammedDateTime).format(formatter);
//
//        System.out.println(zparse);

        ZonedDateTime stringParse = ZonedDateTime.parse("2024-02-28T17:28:10.00101Z");
        System.out.println("stringParse: " + stringParse);

        List<String> scheduledList = List.of("13:00", "15:30", "19:00");

        var firstHour = scheduledList.stream().sorted().findFirst();
        LocalTime nextDayDateTimeAvailable = LocalTime.now();

        if (firstHour.isPresent())
            nextDayDateTimeAvailable = LocalTime.parse(firstHour.get());

        var dateResult = scheduledList.stream()
                .sorted()
                .filter(s -> LocalTime.parse(s).isAfter(LocalTime.now()))
                .findFirst()
                .map(a -> ZonedDateTime.now()
                        .toLocalDate()
                        .atTime(LocalTime.parse(a))
                        .atZone(ZoneId.of("America/Sao_Paulo")))
                .orElse(ZonedDateTime.now()
                        .plusDays(1)
                        .toLocalDate()
                        .atTime(nextDayDateTimeAvailable)
                        .atZone(ZoneId.of("America/Sao_Paulo")));
        System.out.println("dateResult: " + dateResult);

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
    }
}
