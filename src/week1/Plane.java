package week1;

public class Plane {
    static int wings;
    static int returnWings(){
        int i = 2;
        return i;
    }
    static{
        wings = returnWings();
    }
}
