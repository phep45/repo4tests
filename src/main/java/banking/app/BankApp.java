package banking.app;

import banking.config.BankingConfig;
import banking.model.Bank;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BankApp {

    private BankApp() {
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(BankingConfig.class);
        context.refresh();

        Bank bank = (Bank) context.getBean("bank");
        bank.loadClientsFromFile("UBS-clients.xml", true);

        bank.getBankClientsAsList().forEach(System.out::println);

        context.close();
    }
}
