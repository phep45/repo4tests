package banking.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;


public class Account {
    private static final Logger log = LoggerFactory.getLogger(Account.class);

    private int amount;

    public Account(int amount) {
        this.amount = amount;
    }

    public BigDecimal getInterest() {
        Interest interest = Interest.matcher(amount);
        return interest.calculate(amount);
    }

    public static void main(String[] args) {
        Account account = new Account(15000);
        log.info(account.getInterest().toString());

    }

}
