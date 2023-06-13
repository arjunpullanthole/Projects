package week3;
import week2.Student;
import java.util.Comparator;

public class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.firstname.compareTo(o2.firstname);
    }
}