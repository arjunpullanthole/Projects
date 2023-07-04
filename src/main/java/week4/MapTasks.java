package week4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTasks {
    public static void doTask() {
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
}
