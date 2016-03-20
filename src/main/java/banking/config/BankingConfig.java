package banking.config;

import banking.model.Bank;
import banking.model.Client;
import com.google.common.collect.ImmutableList;
import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("banking.*")
public class BankingConfig {

    @Bean
    @Scope("prototype")
    public ImmutableList<List<Client>> clientsList() {
        List<Client> list = new ArrayList<>();
        return ImmutableList.of(list);
    }

    @Bean
    public Bank bank() {
        Bank bank = new Bank();
        bank.setName("UBS");
        return bank;
    }
}