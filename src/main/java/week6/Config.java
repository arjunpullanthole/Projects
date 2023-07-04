package week6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Person getObject()
    {
        Person p = new Person();
        p.setAccount(new Account());
        p.setAddress(new Address());
        return p;
    }
}
