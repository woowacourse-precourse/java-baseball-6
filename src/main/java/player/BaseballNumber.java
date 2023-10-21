package player;

import static constant.StringConstant.ONLY_NUMBER_MESSAGE;

public class BaseballNumber {
    Integer baseballNumber;

    public BaseballNumber(String baseballNumber) {
        validateNumericInput(baseballNumber);
        this.baseballNumber = Integer.parseInt(baseballNumber);
    }

    public BaseballNumber(Integer baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    private void validateNumericInput(String baseballNumber) {
        try {
            Integer.parseInt(baseballNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE);
        }
    }
}
