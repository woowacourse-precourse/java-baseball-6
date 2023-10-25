package baseball.number;

import java.util.Objects;

public class BaseBallNumber {

    private static final Integer MINIMUM = 1;
    private static final Integer MAXIMUM = 9;
    private final int baseballNumber;

    public BaseBallNumber(Character number) {
        this(Character.getNumericValue(number));
    }

    public BaseBallNumber(String number) {
        this(Integer.parseInt(number));
    }

    public BaseBallNumber(Integer number) {
        validateNumber(number);
        this.baseballNumber = number;
    }

    private void validateNumber(Integer number) {
        if (MINIMUM > number || MAXIMUM < number) {
            throw new InvalidBaseBallNumberRangeException();
        }
    }

    public int getBaseballNumber() {
        return baseballNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseBallNumber that = (BaseBallNumber) o;
        return baseballNumber == that.baseballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballNumber);
    }
}