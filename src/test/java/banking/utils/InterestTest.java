package banking.utils;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class InterestTest {

    private double amount;
    private Interest interest;

    @Test
    public void shouldReturnLevel1() {
        amount = 100;
        interest = Interest.matcher(amount);
        assertSame(Interest.LEVEL_1, interest);
    }

    @Test
    public void shouldReturnLevel2() {
        amount = 1500;
        interest = Interest.matcher(amount);
        assertSame(Interest.LEVEL_2, interest);
    }

    @Test
    public void shouldReturnLevel3() {
        amount = 15000;
        interest = Interest.matcher(amount);
        assertSame(Interest.LEVEL_3, interest);
    }

    @Test
    public void shouldReturnLevel4() {
        amount = 150000;
        interest = Interest.matcher(amount);
        assertSame(Interest.LEVEL_4, interest);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException() {
        amount = -100;
        interest = Interest.matcher(amount);
    }

}
