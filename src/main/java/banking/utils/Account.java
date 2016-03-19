package banking.utils;

import java.math.BigDecimal;

public class Account {

    private int amount;

    public Account(int amount) {
        this.amount = amount;
    }

    public BigDecimal getInterest() {
        Interest interest = Interest.matcher(amount);
        return interest.calculate(amount);
    }

    public static void main(String[] args) {
        Account account = new Account(-15000);
        System.out.println(account.getInterest());

    }

}
