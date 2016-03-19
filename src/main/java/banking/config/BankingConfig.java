package banking.config;

import banking.model.Client;
import banking.utils.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("banking.*")
public class BankingConfig {

    @Bean
    public Client client() {
        return new Client();
    }

    @Bean
    public Account account() {
        return new Account();
    }
}
