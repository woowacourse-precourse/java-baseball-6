package baseball.domain;

import baseball.utils.message.ErrorMessage;

public class Digit implements Comparable<Digit> {
    private static final Integer MIN_RANGE = 1;
    private static final Integer MAX_RANGE = 9;

    private final int digit;

    public Digit(int digit) {
        if(digit < MIN_RANGE || MAX_RANGE < digit) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_NUMBER);
        }

        this.digit = digit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != Digit.class) return false;
        Digit digit1 = (Digit) o;
        return digit == digit1.digit;
    }

    @Override
    public int compareTo(Digit o) {
        return digit - o.digit;
    }
}
