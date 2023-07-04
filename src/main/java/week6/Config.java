package week6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("week6")
public class Config {
    @Bean
    public Account account()
    {
        return new Account("1234567","Checking");
    }
//    @Bean
//    public Address address()
//    {
//        return new Address("State Street","McKinney","TX","1234");
//    }
}
