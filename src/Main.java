import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        System.out.printf("Hello and welcome!\n");
        Student st = new Student();
        //System.out.printf("Enter a name for the student\n");
        //Scanner Obj = new Scanner(System.in);
        //String name = Obj.nextLine();
        //String name = System.console().readLine();
        st.setName("Arjun");
        System.out.printf("The Student name is :%s\n", st.getName());

        ComputerScience cs = new ComputerScience();
        cs.setDepartmentSize(5);
        System.out.printf("The Department size is :%s\n", cs.getDepartmentSize());

        Product pd = new Product();
        pd.setPrice(5);
        System.out.printf("The Price of one item is :%s\n", pd.getPrice());
        System.out.printf("The Price of five items are :%s\n", pd.getPrice(5));

        Vehicle vh1 = new Vehicle();
        Vehicle vh2 = new Car();    // runtime polymorphism
        vh1.makeSound();
        vh2.makeSound();
    }
}