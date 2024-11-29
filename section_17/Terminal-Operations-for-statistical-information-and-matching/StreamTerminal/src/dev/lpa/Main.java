package dev.lpa;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        var result = IntStream
                .iterate(0, i -> i <= 1000, i -> i = i + 3)
                .summaryStatistics();
        System.out.println("Result = " + result);

        var leapYearData = IntStream
                .iterate(2000, i -> i <= 2025, i -> i = i + 1)
                .filter(i -> i % 4 == 0)
                .peek(System.out::println)
                .summaryStatistics();
        System.out.println("Leap Year Data = " + leapYearData);

        Seat[] seats = new Seat[100];
        Arrays.setAll(seats, i -> new Seat((char) ('A' + i / 10), i % 10 + 1));
//        Arrays.asList(seats).forEach(System.out::println);

        long reservationCount = Arrays
                .stream(seats)
                .filter(Seat::isReserved)
                .count();
        System.out.println("reservationCount = " + reservationCount);

        boolean hasBookings = Arrays
                .stream(seats)
                .anyMatch(Seat::isReserved);
        System.out.println("hasBookings = " + hasBookings);

        boolean fullyBooked = Arrays
                .stream(seats)
                .allMatch(Seat::isReserved);
        System.out.println("fullyBooked = " + fullyBooked);

        boolean eventWashedOut = Arrays
                .stream(seats)
                .noneMatch(Seat::isReserved);
        System.out.println("eventWashedOut = " + eventWashedOut);
    }
}
