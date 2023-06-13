package week3;
import week2.Student;
import java.util.Comparator;

public class GpaComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.gpa > o2.gpa)
            return 1;
        else if (o1.gpa < o2.gpa)
            return -1;
        return 0;
    }
}
