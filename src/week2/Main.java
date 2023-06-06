package week2;

public class Main {
    public static void main(String[] args)
    {
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

    }
}
