package banking.app;

import banking.config.BankingConfig;
import banking.model.Client;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BankApp {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(BankingConfig.class);
        context.refresh();

        Client client = (Client) context.getBean("client");
        Client client2 = (Client) context.getBean("client");
        client.setName("Bill");
        client2.setName("Jill");
        System.out.println(client);
        System.out.println(client2);

        context.close();
    }
}
