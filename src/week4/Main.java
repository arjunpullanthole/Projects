package week4;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        taskList();
    }
    public static void taskList()
    {
        String[] st = {"plano","allen","mckinney","irving","richardson"};
        List<String> ls = new ArrayList<>(Arrays.asList(st));

        System.out.println("\n============:Task1:===============");
        for(int i =0; i<ls.size(); i++)             //For loop
            System.out.printf("%s ",ls.get(i));
        System.out.println();

        for(String ele : ls)                        //enhanced for loop
            System.out.printf("%s ",ele);
        System.out.println();

        Iterator<String> itr = ls.iterator();       //Iterator
        while(itr.hasNext())
            System.out.printf("%s ",itr.next());
        System.out.println();

        ls.forEach(el-> System.out.printf("%s ",el));       //for each
        System.out.println();

        ls.parallelStream().forEach(el-> System.out.printf("%s ",el));      //streams
        System.out.println();

        System.out.println("\n============:Task2:===============");
        System.out.println(ls);
        ls.remove(ls.size()-1);
        System.out.println(ls);

        System.out.println("\n============:Task3:===============");

        List<Student> stu = new ArrayList<>();
        stu.add(new Student("John","Smith",4.0));
        stu.add(new Student("Alice","Johnson",3.0));
        stu.add(new Student("Michael","Brown",3.5));
        stu.add(new Student("Emily","Davis",3.0));
        stu.add(new Student("David","Wilson",3.2));
        stu.stream().forEach(s -> System.out.println(s.toString()));

        Double avg = stu.parallelStream().mapToDouble(Student::getGpa).average().orElse(0);
        System.out.printf("====Average gpa :%.2f====\n",avg);
        stu.removeIf(s ->s.getGpa()<avg);
        stu.stream().forEach(s -> System.out.println(s.toString()));

        System.out.println("\n============:Task4:===============");
        System.out.println(ls);
        String[] sts = ls.toArray(new String[0]);
        Arrays.stream(sts).forEach(s->System.out.printf("%s ",s));
    }
    public static void taskStreams()
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
