package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTasks {
    public static void doTask()
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
        String[] sts = ls.toArray(new String[0]); //String[]::new
        Arrays.stream(sts).forEach(s->System.out.printf("%s ",s));
    }
}
