package banking.utils;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;

public enum Interest {

    LEVEL_1(0, 1000, 0.01),
    LEVEL_2(1001, 10000, 0.015),
    LEVEL_3(10001, 100000, 0.025),
    LEVEL_4(100001, Integer.MAX_VALUE, 0.05);

    private int floor;
    private int ceil;
    private double rate;

    private static final int SCALE = 2;

    Interest(int floor, int ceil, double rate) {
        this.floor = floor;
        this.ceil = ceil;
        this.rate = rate;
    }

    public static Interest matcher(double amount) {
        checkArgument(amount >= 0, "Negative values not allowed: %s", amount);
        for (Interest interest : values()) {
            if (interest.match(amount))
                return interest;
        }
        throw new IllegalArgumentException("No algorithm for this value: " + amount);
    }

    public BigDecimal calculate(double amount) {
        checkArgument(amount >= 0, "Negative values not allowed: %s", amount);
        return BigDecimal.valueOf(amount).multiply(BigDecimal.valueOf(rate)).setScale(SCALE, BigDecimal.ROUND_HALF_UP);
    }

    private boolean match(double amount) {
        return amount >= this.floor && amount <= this.ceil;
    }

}

