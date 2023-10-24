package baseball;

import java.util.ArrayList;
import java.util.List;

public class Digit extends Number {
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 9;

    public static final List<Integer> numbers = new ArrayList<>();
    private static final List<Digit> instances = new ArrayList<>();

    static {
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            numbers.add(i);
            instances.add(new Digit(i));
        }
    }

    public static Digit from(Integer i) {
        validateValue(i);
        return instances.get(i);
    }

    private static void validateValue(Integer value) throws IllegalArgumentException {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    private final Integer value;

    private Digit(Integer v) throws IllegalArgumentException {
        validateValue(v);
        value = v;
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }
}
