package banking.model;

import banking.utils.Interest;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Scope("prototype")
public class Account {
    private static final Logger log = LoggerFactory.getLogger(Account.class);

    private int amount;

    public Account() {
        this(0);
    }

    public Account(int amount) {
        this.amount = amount;
    }

    public void deposit(int amount) {
        Preconditions.checkArgument(amount > 0, "Amount should be greater than 0");
        this.amount += amount;
    }

    public void withdraw(int amount) {
        Preconditions.checkArgument(amount > 0 && amount <= this.amount, "Cannot withdraw: %s", amount);
        this.amount -= amount;
    }

    public int balance() {
        return amount;
    }

    public BigDecimal getInterest() {
        Interest interest = Interest.matcher(amount);
        return interest.calculate(amount);
    }

    @Override
    public String toString() {
        return "Balance: " + amount;
    }
}
