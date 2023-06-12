package week2;


import java.util.Arrays;
import java.io.*;

public class Main {
    public static void main(String[] args)
    {
        /*
        Compute cp = new Compute();
        System.out.println(cp.reverse(12345));
        System.out.println(cp.reverse(100));
        System.out.println(cp.reverse(0));
        System.out.println(cp.checkAge(9));
        System.out.println(cp.checkAge(13));
        System.out.println(cp.checkAge(19));
        System.out.println(cp.checkAge(30));
        cp.fibonacci(10);
        cp.fibonacci(20);
        cp.fizzBuzz();

        int arr1[] = new int[]{5,10,56,78,68,-90,100,4,20};
        int arr2[] = new int[]{34,76,56,90,72,39,-25};
        int arr3[] = new int[]{89,69,59,49,39,27,60,71};
        ArrayOperations ap = new ArrayOperations();
        ap.minMax(arr1);
        ap.minMax(arr2);
        ap.minMax(arr3);

        System.out.print("\nArrays:\n");
        ap.display(arr1);
        ap.display(arr2);
        ap.display(arr3);
        System.out.print("\nReversed Arrays:\n");
        ap.display(ap.reverse(arr1));
        ap.display(ap.reverse(arr2));
        ap.display(ap.reverse(arr3));

        //Rotating the reversed arrays
        System.out.print("\nRotate Array 1 by 5:\n");
        ap.display(ap.rotate(arr1,5));
        System.out.print("Rotate Array 2 by 20:\n");
        ap.display(ap.rotate(arr2,20));
        System.out.print("Rotate Array 3 by 8:\n");
        ap.display(ap.rotate(arr3,8));
        */

        StringOperations so = new StringOperations();
        System.out.printf("%s has vowel count : %d\n","aeiou",so.vowelCount("aeiou"));
        System.out.printf("%s has vowel count : %d\n","Arjun",so.vowelCount("Arjun"));
        System.out.printf("%s has vowel count : %d\n\n","AeIoU_Hello",so.vowelCount("AeIoU_Hello"));

        String s1 = "Listen";
        String s2 = "Silent";
        System.out.printf("%s is an anagram of %s: %b\n",s1,s2,so.checkAnagram(s1,s2));
        s1 = "Apple";
        s2 = "Orange";
        System.out.printf("%s is an anagram of %s: %b\n\n",s1,s2,so.checkAnagram(s1,s2));

        s1 = "Java J2EE Reverse Me";
        System.out.printf("Input : %s\n",s1);
        System.out.printf("Output : %s\n",so.reverseSentence(s1));
        s1 = "Malayalam";
        System.out.printf("Input : %s\n",s1);
        System.out.printf("Output : %s\n",so.reverseSentence(s1));
        s1 = "";
        System.out.printf("Input : %s\n",s1);
        System.out.printf("Output : %s\n\n",so.reverseSentence(s1));

        s1 = "JavaJ2eeStrutsHibernate";
        s2 = "StrutsHibernateJavaJ2ee";
        System.out.printf("String1 is a rotation of String2: %b\n",so.checkRotation(s1,s2));
        s1 = "Hello";
        s2 = "elloHH";
        System.out.printf("String1 is a rotation of String2: %b\n\n",so.checkRotation(s1,s2));


        Student[] st = new Student[10];
        String csvFile = "/Users/arjun/Documents/CIS-Tech/Java/Projects/src/week2/student.csv";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csvFile));
            String line;
            int i = 0;
            line = br.readLine();       //Skip the first line
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                st[i] = new Student(fields[0],fields[1],Float.parseFloat(fields[2]));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Arrays.sort(st);
        for(Student s : st)
            s.display();
    }
}
