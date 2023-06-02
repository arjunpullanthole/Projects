public class Vehicle {
    int company;
    public int getCompany() {
        return company;
    }
    public void setCompany(int company) {
        this.company = company;
    }
    public void makeSound(){
        System.out.printf("Sound came from Vehicle \n");
    }
}

class Car extends Vehicle{
    @Override
    public void makeSound(){
        System.out.printf("Sound came from car\n");
    }
}
