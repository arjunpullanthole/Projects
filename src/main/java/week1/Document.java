package week1;

public class Document implements Printable, Savable{
    @Override
    public void print() {
        System.out.printf("This document is printable\n");
    }

    @Override
    public void save() {
        System.out.printf("This document is Savable\n");
    }
}
