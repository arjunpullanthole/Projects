package week3;
import week2.Student;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        taskThread();
    }
    public static void taskThread()
    {
        ThreadPrint tp1 = new ThreadPrint();
        ThreadPrint tp2 = new ThreadPrint();
        tp1.start();
        tp2.start();

        Thread rp1 = new Thread (new RunnablePrint("First"));
        Thread rp2 = new Thread (new RunnablePrint("Second"));
        rp1.start();
        rp2.start();
    }
    public void taskException() throws CustomException{
        StringToInteger stoi = new StringToInteger();
        System.out.println(stoi.convert("23"));
        try {
            System.out.println(stoi.convert("45.67"));
        }
        catch(Exception e){
            System.out.printf("Exception : %s %s\n",e.getClass(),e.getMessage());
        }
        try {
            System.out.println(stoi.convert("test"));
        }
        catch(Exception e){
            System.out.printf("Exception : %s %s\n",e.getClass(),e.getMessage());
        }
        try {
            System.out.println(stoi.convert("123f"));
        }
        catch(Exception e){
            System.out.printf("Exception : %s %s\n",e.getClass(),e.getMessage());
        }
        //Custom exception
        try{
            int result = 100/0;
        }
        catch(Exception e){
            CustomException ce = new CustomException("This is my custom exception");
            throw ce;
        }
    }
    public void taskComparator(){
        Student[] st = new Student[3];
        st[0] = new Student("Alice", "Charlie", 4);
        st[1] = new Student("Bob","Bob" , 3.5F);
        st[2] = new Student("Chalrie","Alice", 3);

        Comparator<Student> gpaComp = new GpaComparator();          //custom comp 1
        Comparator<Student> nameComp= new NameComparator();         //custom comp 2

        Arrays.sort(st,gpaComp);        //sort based on gpa
        for(Student s : st)
            s.display();
        System.out.println();
        Arrays.sort(st,nameComp);       //sort based on firstname
        for(Student s : st)
            s.display();
        System.out.println();
        Arrays.sort(st, new Comparator<Student>() {         //sort based on anonymous inner class
            @Override
            public int compare(Student o1, Student o2) {
                return o1.lastname.compareTo(o2.lastname);
            }
        });
        for(Student s : st)
            s.display();
    }
}

