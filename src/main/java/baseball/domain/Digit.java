package baseball.domain;

public class Digit implements Comparable<Digit> {
    private final int digit;

    public Digit(int digit) {
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
