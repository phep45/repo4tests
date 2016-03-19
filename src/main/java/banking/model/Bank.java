package banking.model;

import com.google.common.base.Preconditions;
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
        Preconditions.checkNotNull(client, "No client specified");
        clientsList.add(client);
    }

    public void printClients() {
        clientsList.forEach(System.out::println);
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
