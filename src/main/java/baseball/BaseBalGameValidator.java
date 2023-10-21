package baseball;

import java.util.HashSet;
import java.util.Set;

public class BaseBalGameValidator {
    private static final int BASEBALL_SIZE = 3;

    private static final String NOT_NUMBER_ERROR_MESSAGE = "%s는 숫자가 아닙니다.";
    private static final String DUPLICATE_OR_SIZE_ERROR_MESSAGE = "%d는 세자리 숫자가 아니거나, 값은 값이 존재합니다.";
    private static final String NEGATIVE_VALUE_ERROR_MESSAGE = "%d는 세자리가 각각다른 음수입니다.";

    public void validBaseBallValue(String baseballValue) {
        checkIsNumber(baseballValue);
        checkDuplicateAndSize(Integer.parseInt(baseballValue));
        checkIsPositive(Integer.parseInt(baseballValue));
    }

    private void checkIsPositive(int value) {
        if (value < 0)
            throw new IllegalArgumentException(String.format(NEGATIVE_VALUE_ERROR_MESSAGE, value));
    }

    private void checkIsNumber(String baseballValue) {
        try {
            Integer.parseInt(baseballValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(NOT_NUMBER_ERROR_MESSAGE, baseballValue));
        }
    }

    private void checkDuplicateAndSize(int baseballValue) {
        Set<Integer> duplicateChecker = generateDuplicateChecker(baseballValue);
        if (duplicateChecker.size() != BASEBALL_SIZE)
            throw new IllegalArgumentException(String.format(DUPLICATE_OR_SIZE_ERROR_MESSAGE, baseballValue));
    }

    private Set<Integer> generateDuplicateChecker(int baseballValue) {
        Set<Integer> duplicateChecker = new HashSet<>();
        while (baseballValue != 0) {
            duplicateChecker.add(baseballValue % 10);
            baseballValue /= 10;
        }
        return duplicateChecker;
    }
}
