package week3;
import week2.Student;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        try {
            threadSum();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        taskBooking();
        taskDeadlock();
    }
    public static void taskDeadlock()
    {
        SharedResource sr = new SharedResource();
        Thread t1 = new Thread (new Consumer(sr,1));
        Thread t2 = new Thread (new Consumer(sr,2));
        t1.start();
        t2.start();
    }
    public static void taskBooking()
    {
        TicketBooking tb = new TicketBooking(10);
        ExecutorService ex = Executors.newFixedThreadPool(10);
        ThreadBooking[] th = new ThreadBooking[10];
        for(int i=0 ; i<10 ; i++)
        {
            th[i] = new ThreadBooking(tb,i+1);
            ex.execute(th[i]);
        }
        ex.shutdown();
    }
    public static void threadSum() throws InterruptedException {
        int sum =0;
        int[] arr = new int[100];
        for(int i = 0;i<100;i++)
            arr[i] = i*2;
        ExecutorService ex = Executors.newFixedThreadPool(5);
        ThreadSum[] th = new ThreadSum[5];
        for(int i=0 ; i<5 ; i++)
        {
            th[i] = new ThreadSum(i*20,(i+1)*20, arr);
            ex.execute(th[i]);
        }
        ex.shutdown();
        ex.awaitTermination(1, TimeUnit.SECONDS);
        for(int i=0 ; i<5 ; i++)
            sum += th[i].getSum();
        System.out.println(sum);
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
    public static void taskException() throws CustomException{
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
    public static void taskComparator(){
        Student[] st = new Student[3];
        st[0] = new Student("Alice", "Charlie", 4);
        st[1] = new Student("Bob","Bob" , 3.5F);
        st[2] = new Student("Charlie","Alice", 3);

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

