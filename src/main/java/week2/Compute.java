package week2;

public class Compute {
    public int reverse(int input){
        int temp = 0;
        while(input>0)
        {
            temp *=10;
            temp += input%10;
            input /= 10;
        }
        return temp;
    }

    public String checkAge(int age){
        if(age <0){
            return "Invalid Age";
        }
        else if(age > 19){
            return "Adult";
        }
        else if (age > 12){
            return "Teen";
        }
        else return "Kid";
    }

    public void fibonacci(int n){
        int first = 0;
        int second = 1;
        int temp;
        if (n==0){
            return;
        }
        if (n > 0){
            System.out.print(first + " ");
        }
        if (n > 1){
            System.out.print(second + " ");
        }
        n -= 2;
        while(n > 0){
            temp = first + second;
            first = second;
            second = temp;
            System.out.print(second + " ");
            n--;
        }
        System.out.println();
    }

    public boolean divisible(int n, int d){
        return n%d==0 ? true : false;

    }

    public void fizzBuzz(){
        for(int i=1 ; i <= 100 ; i++){
            if(divisible(i,15)){
                System.out.print("FizzBuzz ");
            }
            else if(divisible(i,5)){
                System.out.print("Buzz ");
            }
            else if(divisible(i,3)){
                System.out.print("Fizz ");
            }
            else
                System.out.print(i+ " ");
            if(i%10 == 0){
                System.out.println();
            }
        }
    }

}
