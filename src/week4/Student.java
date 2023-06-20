package week4;

public class Student {
    private String firstName;
    private String lastName;
    private double gpa;
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public double getGpa() {
        return gpa;
    }
    public Student(String firstName, String lastName, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return firstName + " "+ lastName + " "+gpa;
    }
}
