package week2;

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
         */
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
    }
}
