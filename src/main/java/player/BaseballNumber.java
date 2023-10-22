package player;

import static constant.StringConstant.INVALID_NUMBER_RANGE;
import static constant.StringConstant.ONLY_NUMBER;

public class BaseballNumber {

    private final Integer baseballNumber;

    public BaseballNumber(String baseballNumber) {
        validateNumericInput(baseballNumber);
        validateNumberInRange(Integer.parseInt(baseballNumber));
        this.baseballNumber = Integer.parseInt(baseballNumber);
    }

    public BaseballNumber(Integer baseballNumber) {
        validateNumberInRange(baseballNumber);
        this.baseballNumber = baseballNumber;
    }

    private void validateNumericInput(String baseballNumber) {
        try {
            Integer.parseInt(baseballNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ONLY_NUMBER);
        }
    }

    private void validateNumberInRange(Integer baseballNumber) {
        if (baseballNumber <= 0 || baseballNumber > 9) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }

    @Override
    public boolean equals(Object baseballNumber) {
        if (baseballNumber instanceof BaseballNumber convertBaseballNumber) {
            return this.baseballNumber.equals(convertBaseballNumber.baseballNumber);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return baseballNumber.hashCode();
    }
}
