package baseball;

import java.util.HashSet;
import java.util.Set;

public class BaseBalGameValidator {
    private static final int BASEBALL_SIZE = 3;
    private static final int END_COMMAND = 2;
    private static final int RE_GAME_COMMAND = 1;

    private static final String NOT_NUMBER_ERROR_MESSAGE = "%s는 숫자가 아닙니다.";
    private static final String DUPLICATE_OR_SIZE_ERROR_MESSAGE = "%s는 세자리 숫자가 아니거나, 값은 값이 존재합니다.";
    private static final String NEGATIVE_VALUE_ERROR_MESSAGE = "%d는 세자리가 각각다른 음수입니다.";
    private static final String NOT_END_COMMAND_ERROR_MESSAGE = "%S는 1이거나 2가 아닙니다.";
    private static final String CONTAIN_ZERO_ERROR_MESSAGE = "%S는 0이 포함되어있다.";

    public void validBaseBallValue(int baseballValue) {
        checkIsNumber(Integer.toString(baseballValue), NOT_NUMBER_ERROR_MESSAGE);
        checkContainZero(Integer.toString(baseballValue), CONTAIN_ZERO_ERROR_MESSAGE);
        checkDuplicateAndSize(baseballValue);
        checkIsPositive(baseballValue);
    }

    public void validBaseBallValue(String baseballValue) {
        checkIsNumber(baseballValue, NOT_NUMBER_ERROR_MESSAGE);
        checkContainZero(baseballValue, CONTAIN_ZERO_ERROR_MESSAGE);
        checkDuplicateAndSize(baseballValue);
        checkIsPositive(Integer.parseInt(baseballValue));
    }

    private void checkIsPositive(int value) {
        if (value < 0)
            throw new IllegalArgumentException(String.format(NEGATIVE_VALUE_ERROR_MESSAGE, value));
    }

    private void checkIsNumber(String baseballValue, String errorMessage) {
        try {
            Integer.parseInt(baseballValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(errorMessage, baseballValue));
        }
    }

    private void checkDuplicateAndSize(String baseballValue) {
        Set<Integer> duplicateChecker = generateDuplicateChecker(Integer.parseInt(baseballValue));
        if (duplicateChecker.size() != BASEBALL_SIZE)
            throw new IllegalArgumentException(String.format(DUPLICATE_OR_SIZE_ERROR_MESSAGE, baseballValue));
    }

    private void checkContainZero(String baseballValue, String errorMessage) {
        final char ZERO = '0';
        for (char data : baseballValue.toCharArray()) {
            if (data == ZERO)
                throw new IllegalArgumentException(String.format(errorMessage, baseballValue));
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

    public void validEndCommand(String command) {
        checkIsNumber(command, NOT_END_COMMAND_ERROR_MESSAGE);
        checkContainZero(command, NOT_END_COMMAND_ERROR_MESSAGE);
        if (notEndOrReCommand(command))
            throw new IllegalArgumentException(String.format(NOT_END_COMMAND_ERROR_MESSAGE, command));
    }

    private boolean notEndOrReCommand(String command) {
        return !(Integer.parseInt(command) == END_COMMAND || Integer.parseInt(command) == RE_GAME_COMMAND);
    }
}
