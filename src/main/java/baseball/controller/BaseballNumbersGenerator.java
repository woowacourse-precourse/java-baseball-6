package baseball.controller;

import baseball.model.BaseballNumber;
import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballNumbersGenerator {
    private static final int BASEBALL_NUMBERS_LENGTH = 3;
    private static final int MIN_BASEBALL_NUMBER = 1;
    private static final int MAX_BASEBALL_NUMBER = 9;
    private static final String EMPTY_STRING = "";

    public static List<BaseballNumber> getComputerBaseballNumbers() {
        List<BaseballNumber> computerBaseballNumbers = new ArrayList<>();
        while (computerBaseballNumbers.size() != BASEBALL_NUMBERS_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_BASEBALL_NUMBER, MAX_BASEBALL_NUMBER);
            BaseballNumber randomBaseballNumber = new BaseballNumber(randomNumber);
            if (!computerBaseballNumbers.contains(randomBaseballNumber)) {
                computerBaseballNumbers.add(randomBaseballNumber);
            }
        }
        return computerBaseballNumbers;
    }

    public static List<BaseballNumber> getUserBaseballNumbers(String baseballNumbersString) {
        validateBaseballNumbersString(baseballNumbersString);
        return Arrays.stream(baseballNumbersString.split(EMPTY_STRING))
                .map(Integer::parseInt)
                .map(BaseballNumber::new)
                .collect(Collectors.toList());
    }

    private static void validateBaseballNumbersString(String baseballNumbersString) {
        Validator.validateInputEmptyOrNull(baseballNumbersString);
        Validator.validateInputLength(baseballNumbersString, BASEBALL_NUMBERS_LENGTH);
        Validator.validateInputDigit(baseballNumbersString);
        Validator.validateInputDistinct(baseballNumbersString);
    }
}
