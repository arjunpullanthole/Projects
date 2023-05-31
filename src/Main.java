import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        System.out.printf("Hello and welcome!\n");
        Student st = new Student();
        System.out.printf("Enter a name for the student\n");
        Scanner Obj = new Scanner(System.in);
        String name = Obj.nextLine();
        //String name = System.console().readLine();
        st.setName(name);
        System.out.printf("The Student name is :%s\n", st.getName());
    }
}