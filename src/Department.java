public abstract class Department {
    public int departmentSize;
    public void setDepartmentSize(int departmentSize) {
        this.departmentSize = departmentSize;
    }
    public abstract int getDepartmentSize();
}

class ComputerScience extends Department{
    @Override
    public int getDepartmentSize(){
        return departmentSize;
    }
        }