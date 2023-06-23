package week4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HashSetTasks {
    public static void doTask()
    {
        System.out.println("\n============:Task1:===============");
        HashSet<String> hs = new HashSet<>();
        List<String> ls = new ArrayList<>();
        ls.add("John");
        ls.add("Alice");
        ls.add("Michael");
        ls.add("Emily");
        ls.add("David");
        ls.add("Jason");
        ls.add("Mike");
        ls.add("Henry");
        ls.add("Smith");
        ls.add("Johnson");
        hs.addAll(ls);
        hs.forEach(s->System.out.printf("%s ",s));      //Foreach
        System.out.println();
        hs.stream().forEach(s->System.out.printf("%s ",s));     //Streams foreach
        System.out.println();
        Iterator<String> itr = hs.iterator();
        while(itr.hasNext())
            System.out.printf("%s ",itr.next());                //Iterator

        System.out.println("\n============:Task2:===============");
        String st = "aaaabbbbccccddddeeeefff";
        StringBuilder sb = new StringBuilder();
        HashSet<Character> h = new HashSet<>();
        System.out.printf("String : %s\n",st);
        for(int i =0;i<st.length();i++)
            h.add(st.charAt(i));
        h.forEach(c -> sb.append(c) );
        System.out.printf("Unique String : %s",sb.toString());
    }
}
