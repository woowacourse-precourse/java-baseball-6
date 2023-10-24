package player;

import java.util.Objects;

public class BaseballNumber {

    private static final String ONLY_NUMBER = "숫자만 입력 가능합니다.";
    private final int baseballNumber;

    public BaseballNumber(String baseballNumber) {
        validateNumeric(baseballNumber);
        this.baseballNumber = Integer.parseInt(baseballNumber);
    }

    public BaseballNumber(int baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public int getBaseballNumber() {
        return this.baseballNumber;
    }

    @Override
    public boolean equals(Object otherNumber) {
        if (otherNumber instanceof BaseballNumber otherBaseballNumber) {
            return this.baseballNumber == otherBaseballNumber.baseballNumber;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.baseballNumber);
    }

    private void validateNumeric(String baseballNumber) {
        try {
            Integer.parseInt(baseballNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ONLY_NUMBER);
        }
    }
}
