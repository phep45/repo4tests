package banking.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Client {

    @Autowired
    private Account account;

    private String name;

    public Client(){

    }

    public void deposit(int amount) {
        getAccount().deposit(amount);
    }

    public void withdraw(int amount) {
        getAccount().withdraw(amount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int balance() {
        return getAccount().balance();
    }

    @Override
    public String toString() {
        return "Client: " + name + ", " + account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
