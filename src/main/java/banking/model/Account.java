package banking.model;

import banking.utils.Interest;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Component
@Scope("prototype")
@XmlRootElement
public class Account {
    private static final Logger log = LoggerFactory.getLogger(Account.class);

    private int amount;

    public Account() {
        this(0);
    }

    public Account(int amount) {
        this.setAmount(amount);
    }

    public void deposit(int amount) {
        Preconditions.checkArgument(amount > 0, "Amount should be greater than 0");
        this.setAmount(this.getAmount() + amount);
    }

    public void withdraw(int amount) {
        Preconditions.checkArgument(amount > 0 && amount <= this.getAmount(), "Cannot withdraw: %s", amount);
        this.setAmount(this.getAmount() - amount);
    }

    public int balance() {
        return getAmount();
    }

    public BigDecimal getInterest() {
        Interest interest = Interest.matcher(getAmount());
        return interest.calculate(getAmount());
    }

    @Override
    public String toString() {
        return "Balance: " + getAmount();
    }

    public int getAmount() {
        return amount;
    }

    @XmlElement
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
