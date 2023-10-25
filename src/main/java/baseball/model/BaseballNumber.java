package baseball.model;

import baseball.validator.BaseballNumberValidator;

public class BaseballNumber {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;

    private final int number;

    public BaseballNumber(int number) {
        BaseballNumberValidator.validate(number, MIN_VALUE, MAX_VALUE);

        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BaseballNumber that = (BaseballNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
