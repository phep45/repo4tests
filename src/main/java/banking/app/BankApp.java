package banking.app;

import banking.config.BankingConfig;
import banking.model.Bank;
import banking.model.Client;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BankApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(BankingConfig.class);
        context.refresh();


        Bank bank = (Bank) context.getBean("bank");
        bank.setName("UBS");

        Bank ing = (Bank) context.getBean("bank");
        ing.setName("ING");

        Client client = (Client) context.getBean("client");
        Client client2 = (Client) context.getBean("client");
        System.out.println(bank);
        System.out.println(ing);

        context.close();
    }
}
