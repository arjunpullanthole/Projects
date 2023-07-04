package week2;

public class Student implements Comparable{
    public String firstname;
    public String lastname;
    public float gpa;
    public Student(String firstname, String lastname, float gpa) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Object o) {
        Student st = (Student) o;
        return this.lastname.compareTo(st.lastname);
    }

    public void display(){
        System.out.printf("%s %s %.1f\n",this.firstname,this.lastname,this.gpa);
    }
}
