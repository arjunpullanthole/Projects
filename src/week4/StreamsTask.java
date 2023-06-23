package week4;

import java.util.Arrays;
import java.util.Comparator;

public class StreamsTask {
    public static void doTask()
    {
        String[] st = {"plano","allen","mckinney","irving","richardson","Dymmy"};
        Arrays.stream(st).forEach(s -> System.out.printf("%s ",s));

        System.out.println("\n============:Task1:===============");
        Arrays.stream(st).map(s ->s.substring(0, 1).toUpperCase() + s.substring(1))
                .sorted().forEach(s -> System.out.printf("%s\n",s));

        System.out.println("\n============:Task2:===============");
        Arrays.stream(st).filter(s -> {
                    String vowels = "aeiouAEIOU";
                    return s.chars().anyMatch(c -> vowels.indexOf(c) != -1);})
                .forEach(s -> {
                    String vowels = "aeiouAEIOU";
                    int count = (int) s.chars().filter(c -> vowels.indexOf(c) != -1).count();
                    System.out.printf("%s has %d vowels\n",s,count);
                });

        System.out.println("\n============:Task3:===============");
        Integer[] in = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.stream(in).filter(i -> i%2!=0).mapToInt(i -> i*i).average().orElse(0));

        System.out.println("\n============:Task4:===============");
        Arrays.stream(st).sorted(Comparator.comparingInt(String::length)
                        .thenComparing(st2 -> (new StringBuilder(st2)).reverse(),Comparator.reverseOrder()))
                .forEach(s -> System.out.printf("%s ",s));
    }
}