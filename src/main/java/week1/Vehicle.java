package week1;

public class Vehicle {
    String company;
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public void makeSound(){
        System.out.printf("Sound came from Vehicle \n");
    }
}

