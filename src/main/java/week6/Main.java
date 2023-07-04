package week6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Person person = context.getBean(Person.class);
        person.getAccount().print();
        person.getAddress().print();
        System.out.println(person.getAccount().getAccountNumber());
        System.out.println(person.getAddress().getStreet());
    }
}
