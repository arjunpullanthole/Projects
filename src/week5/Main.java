package week5;

import week4.HashSetTasks;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=====================Task1=====================");
        System.out.println(task1("discombobulated").orElse(0));
        System.out.println(task1(null).orElse(0));

        System.out.println("=====================Task2=====================");
        System.out.println(task2("discombobulated").orElse("Empty"));
        System.out.println(task2(null).orElse("Empty"));

        System.out.println("=====================Task3=====================");
        System.out.println(task3(LocalDate.of(1997, 12, 28)));      //return age

        System.out.println("=====================Task4=====================");
        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2023, 2, 15),
                LocalDate.of(2022, 10, 1),
                LocalDate.of(2024, 6, 30),
                LocalDate.of(2023, 7, 20)
        );
        task4(dates);

        System.out.println("=====================Task5=====================");
        task5(LocalDate.of(2023, 6, 1));

    }

    public static Optional<Integer> task1(String st)
    {
        if(st == null)
            return Optional.empty();
        return Optional.of(st.length());
    }
    public static Optional<String> task2(String st)
    {
        if(st == null)
            return Optional.empty();
        return Optional.of(st.toUpperCase());
    }
    public static Integer task3(LocalDate dob)
    {
        return Period.between(dob, LocalDate.now()).getYears();
    }
    public static void task4(List<LocalDate> al)
    {
        System.out.println( al.stream().min(LocalDate::compareTo).orElse(null));
        System.out.println( al.stream().max(LocalDate::compareTo).orElse(null));
    }
    public static void task5(LocalDate date)
    {
        int workingDays = 0;
        int monthLength = date.lengthOfMonth();
        int day = date.getDayOfMonth();
        for (int i = 0; i<= monthLength - day; i++)
        {
            if(date.plusDays(i).getDayOfWeek() != DayOfWeek.SUNDAY && date.plusDays(i).getDayOfWeek() != DayOfWeek.SATURDAY )
                workingDays++;
        }
        System.out.println(workingDays);
    }
}
