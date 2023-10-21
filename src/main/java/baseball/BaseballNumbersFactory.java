package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbersFactory {
    private static final int BASEBALL_NUMBERS_LENGTH = 3;

    private BaseballNumbersFactory() {
    }

    public static List<BaseballNumber> getRandomBaseballNumbers() {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        while (baseballNumbers.size() != BASEBALL_NUMBERS_LENGTH) {
            BaseballNumber randomBaseballNumber = BaseballNumber.getRandomBaseballNumber();
            if (!baseballNumbers.contains(randomBaseballNumber)) {
                baseballNumbers.add(randomBaseballNumber);
            }
        }
        return baseballNumbers;
    }

    public static List<BaseballNumber> getBaseballNumbers(String baseballNumbersString) {
        validateBaseballNumbers(baseballNumbersString);
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        for (String baseballNumberString : baseballNumbersString.split("")) {
            int baseballNumberInt = Integer.parseInt(baseballNumberString);
            BaseballNumber baseballNumber = new BaseballNumber(baseballNumberInt);
            baseballNumbers.add(baseballNumber);
        }
        return baseballNumbers;
    }

    public static void validateBaseballNumbers(String baseballNumbersString) {
        Validation.validateInputEmptyOrNull(baseballNumbersString);
        Validation.validateInputLength(baseballNumbersString, BASEBALL_NUMBERS_LENGTH);
        Validation.validateInputDistinct(baseballNumbersString);
        Validation.validateInputDigit(baseballNumbersString);
    }
}
