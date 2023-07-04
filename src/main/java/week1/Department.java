package week1;

public abstract class Department {
    public int departmentSize;
    public void setDepartmentSize(int departmentSize) {
        this.departmentSize = departmentSize;
    }
    public abstract int getDepartmentSize();
}