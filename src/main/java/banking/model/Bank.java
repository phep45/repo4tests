package banking.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Bank {

    private String name;
    private List<Client> clientsList = new ArrayList<>();

    public void addClient(Client client) {
        clientsList.add(client);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bank: " + name;
    }
}
