package week4;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        taskMap();
    }
    public static void taskMap() {
        System.out.println("\n============:Task1:===============");
        HashMap<String, Student> map = new HashMap<>();
        Student[] st = new Student[8];
        st[0] = new Student("John", "Smith", 4.0);
        st[1] = new Student("Alice", "Johnson", 3.0);
        st[2] = new Student("Michael", "Brown", 3.5);
        st[3] = new Student("Emily", "Davis", 3.0);
        st[4] = new Student("David", "Wilson", 3.2);
        st[5] = new Student("Jason", "Rulo", 3.2);
        st[6] = new Student("Mike", "Olson", 3.2);
        st[7] = new Student("Henry", "Cavil", 3.2);
        for (Student s : st)             //Insert into hashmap
            map.put(s.getFirstName(), s);
        for (Map.Entry<String, Student> entry : map.entrySet())     //using Entry-set
            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
        System.out.println();
        map.forEach((k, v) -> System.out.printf("%s -> %s\n", k, v.toString()));     //using foreach
        System.out.println();
        for (String s : map.keySet())                                        //using key-set
            System.out.printf("%s -> %s\n", s, map.get(s));
        System.out.println();
        Iterator<String> itr = map.keySet().iterator();                     //Iterator
        while (itr.hasNext())
            System.out.printf("%s\n", map.get(itr.next()));

        System.out.println("\n============:Task2:===============");
        String str = "Test String";
        str = str.toLowerCase();
        HashMap<Integer, Integer> mp = new HashMap<>();
        str.chars().filter(c-> c!=32).forEach(c -> mp.put(c,mp.getOrDefault(c,0)+1));
        mp.forEach((k, v) -> System.out.printf("%c -> %d\n", k, v));

        System.out.println("\n============:Task3:===============");
        HashMap<Integer, Integer> m = new HashMap<>();
        int[] arr = {10, 20, 30, 40, 50, 60};
        int n = 100;
        for (int i = 0; i < arr.length; i++)
        {
            if (m.containsKey(n - arr[i])) {
                System.out.printf("[%d,%d]",m.get(n - arr[i]),i);
                break;
            } else
                m.put(arr[i], i);
        }
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
        String[] sts = ls.toArray(new String[0]); //String[]::new
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
