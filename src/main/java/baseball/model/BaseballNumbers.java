package baseball.model;

import baseball.utils.BaseballStringUtils;
import baseball.utils.Validator;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    private static final int BASEBALL_NUMBERS_LENGTH = 3;
    private final List<BaseballNumber> baseballNumbers = new ArrayList<>();

    public void setRandomBaseballNumberList() {
        while (baseballNumbers.size() != BASEBALL_NUMBERS_LENGTH) {
            BaseballNumber randomBaseballNumber = BaseballNumber.getRandomBaseballNumber();
            if (!baseballNumbers.contains(randomBaseballNumber)) {
                baseballNumbers.add(randomBaseballNumber);
            }
        }
    }

    public void setBaseballNumbers(String baseballNumbersString) {
        validateBaseballNumberListString(baseballNumbersString);
        for (String baseballNumberString : baseballNumbersString.split(BaseballStringUtils.EMPTY_STRING)) {
            int baseballNumber = Integer.parseInt(baseballNumberString);
            baseballNumbers.add(new BaseballNumber(baseballNumber));
        }
    }

    public static void validateBaseballNumberListString(String baseballNumbersString) {
        Validator.validateInputEmptyOrNull(baseballNumbersString);
        Validator.validateInputLength(baseballNumbersString, BASEBALL_NUMBERS_LENGTH);
        Validator.validateInputDistinct(baseballNumbersString);
        Validator.validateInputDigit(baseballNumbersString);
    }

    public BaseballNumber getBaseballNumber(int index) {
        return baseballNumbers.get(index);
    }

    public int getBallCount(BaseballNumbers otherBaseballNumbers) {
        int ballCount = 0;
        for (int index = 0; index < BASEBALL_NUMBERS_LENGTH; index++) {
            BaseballNumber baseballNumber = baseballNumbers.get(index);
            BaseballNumber otherBaseballNumber = otherBaseballNumbers.getBaseballNumber(index);
            if (!baseballNumber.equals(otherBaseballNumber) &&
                    baseballNumbers.contains(otherBaseballNumber)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public int getStrikeCount(BaseballNumbers otherBaseballNumbers) {
        int strikeCount = 0;
        for (int index = 0; index < BASEBALL_NUMBERS_LENGTH; index++) {
            BaseballNumber baseballNumber = baseballNumbers.get(index);
            BaseballNumber otherBaseballNumber = otherBaseballNumbers.getBaseballNumber(index);
            if (baseballNumber.equals(otherBaseballNumber)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}
