package com.learn_java.dates;

//import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class NextAvailableDateTime {

    private static final String ZONED_TIME_FORMATTER = "yyyy-MM-dd'T'HH:mm:ss:SSSXXXXX";

    public static void main(String[] args) {
        ZoneId userTimeZone = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime now = ZonedDateTime.now(userTimeZone);

        List<String> scheduledList = List.of("22:00", "06:00", "17:30", "23:50", "15:35");

        List<ZonedDateTime> scheduledTimesInUtc = scheduledList
                .stream()
                .map(time -> {
                    String[] parts = time.split("@");
                    System.out.println("parts: " + parts[0]);
                    LocalTime localTime = LocalTime.parse(parts[0]);
                    ZoneId timeZone = parts.length > 1 ? ZoneId.of(parts[1]) : userTimeZone;
                    return ZonedDateTime.of(now.toLocalDate(), localTime, timeZone).withZoneSameInstant(ZoneId.of("UTC"));
                })
                .sorted()
                .collect(Collectors.toList());

        ZonedDateTime nextAvailableTimeInUtc = scheduledTimesInUtc
                .stream()
                .filter(time -> time.isAfter(now.withZoneSameInstant(ZoneId.of("UTC"))))
                .findFirst()
                .orElseGet(() -> scheduledTimesInUtc.stream()
                        .findFirst()
                        .map(time -> time.plusDays(1))
                        .orElseThrow());

        System.out.println(nextAvailableTimeInUtc
                .withSecond(0)
                .withNano(0)
                .format(DateTimeFormatter.ofPattern(ZONED_TIME_FORMATTER)));
    }
}


//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class NextAvailableDateTime {
//
//    private static final String ZONED_TIME_FORMATTER = "yyyy-MM-dd'T'HH:mm:ss:SSSXXXXX";
//
//    public static void main(String[] args) {
//        ZoneId userTimeZone = ZoneId.of("America/Sao_Paulo");
//        ZonedDateTime now = ZonedDateTime.now(userTimeZone);
//
//        List<String> scheduledList = List.of("22:00", "17:30", "23:50");
//
//        List<ZonedDateTime> scheduledTimesInUtc = scheduledList.stream()
//                .map(time -> {
//                    String[] parts = time.split("@");
//                    LocalTime localTime = LocalTime.parse(parts[0]);
//                    ZoneId timeZone = parts.length > 1 ? ZoneId.of(parts[1]) : userTimeZone;
//                    return ZonedDateTime.of(now.toLocalDate(), localTime, timeZone).withZoneSameInstant(ZoneId.of("UTC"));
//                })
//                .sorted()
//                .collect(Collectors.toList());
//
//        ZonedDateTime nextAvailableTimeInUtc = scheduledTimesInUtc.stream()
//                .filter(time -> time.isAfter(now.withZoneSameInstant(ZoneId.of("UTC"))))
//                .findFirst()
//                .orElseGet(() -> scheduledTimesInUtc.stream()
//                        .findFirst()
//                        .map(time -> time.plusDays(1))
//                        .orElseThrow());
//
//        ZonedDateTime dateTimeAvailable = nextAvailableTimeInUtc.withZoneSameInstant(userTimeZone);
//
//        System.out.println(dateTimeAvailable
//                .withSecond(0)
//                .withNano(0)
////                .toLocalDateTime()
//                .format(DateTimeFormatter.ofPattern(ZONED_TIME_FORMATTER))
//        );
//    }
//}


//package com.learn_java.dates;
//
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.ZoneId;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class NextAvailableDateTime {
//
//    private static final String ZONED_TIME_FORMATTER = "yyyy-MM-dd'T'HH:mm:ss:SSSXXXXX";
//
//    public static void main(String[] args) {
//
//        List<String> scheduledList = List.of("22:00", "17:30", "23:50");
//        List<LocalTime> sortedList = scheduledList
//                .stream()
//                .map(LocalTime::parse)
//                .sorted()
//                .map(l -> LocalTime.of(l.getHour(), l.getMinute()))
//                .collect(Collectors.toList());
//        LocalDateTime dateTimeAvailable = sortedList
//                .stream()
//                .filter(time -> time.isAfter(LocalTime.now()))
//                .findFirst()
//                .map(s -> LocalDateTime.now().withHour(s.getHour()).withMinute(s.getMinute()))
//                .orElseGet(() -> tomorrow(sortedList.get(0)));
//
////        hour.ifPresentOrElse(NextAvailableDateTime::today,
////                () -> tomorrow(sortedList.stream().findFirst()));
//
//        System.out.println(dateTimeAvailable
//                .withSecond(0)
//                .withNano(0)
//                .atZone(ZoneId.of("America/Sao_Paulo"))
//                .format(DateTimeFormatter.ofPattern(ZONED_TIME_FORMATTER)));
//    }
//
//    private static void today(LocalTime time){
//        System.out.println(LocalDateTime.now().withHour(time.getHour()).withMinute(time.getMinute()));
//    }
//
//    private static LocalDateTime tomorrow(LocalTime time){
//        return LocalDateTime
//                .now()
//                .plusDays(1)
//                .withHour(time.getHour())
//                .withMinute(time.getMinute());
//    }
//}
