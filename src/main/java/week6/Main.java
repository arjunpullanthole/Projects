package week6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

//        ApplicationContext factory = new AnnotationConfigApplicationContext(Config.class);
//        Person person = factory.getBean(Person.class);
        Person person = new Person();
        person.getAccount().print();
    }
}
