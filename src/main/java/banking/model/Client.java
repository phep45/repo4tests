package banking.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Component
@Scope("prototype")
@XmlRootElement
public class Client {

    @Autowired
    private Account account;

    private String name;
    private Integer id;

    private static int idGenerator;

    public Client(){
        id = idGenerator++;
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

    @XmlElement
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

    @XmlElement
    public void setAccount(Account account) {
        this.account = account;
    }

    @XmlAttribute
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
