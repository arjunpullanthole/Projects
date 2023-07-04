package week6;

import org.springframework.stereotype.Component;

@Component
public class Account {
    private String accountNumber;
    private String accountType;

    public void print()
    {
        System.out.println("This is your account");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
