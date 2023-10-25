package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class UserInputValidator {

    private static final String NOT_DIFFERENT_NUMBERS_MSG = "서로 다른 숫자를 입력해주세요.";
    private static final String WRONG_NUMBER_RANGE_MSG = "1 ~ 9까지의 숫자를 입력해주세요.";
    private static final String WRONG_NUMBER_LENGTH_MSG = "3 자리의 숫자를 입력해주세요.";
    private static final String WRONG_RESTART_NUMBER_LENGTH_MSG = "1 자리의 숫자를 입력해주세요.";
    private static final String WRONG_RESTART_NUMBER_RANGE_MSG = "1 또는 2를 입력해주세요.";
    private static final int NUMBER_LENGTH = 3;
    private static final int RESTART_NUMBER_LENGTH = 1;
    private static final char MIN_NUMBER = '1';
    private static final char MAX_NUMBER = '9';
    private String userInputNumbers = "";
    private String userInputRestartNumber = "";
    private static final String RESTART_NUMBER = "1";
    private static final String DO_NOT_RESTART_NUMBER = "2";

    public void validateInputNumbers(String userInput) {
        userInputNumbers = userInput;

        checkDifferentNumbers();
        checkNumberRange();
        checkNumberLength();
    }

    private void checkNumberLength() {
        if (userInputNumbers.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(WRONG_NUMBER_LENGTH_MSG);
        }
    }

    private void checkNumberRange() {
        for (char number : userInputNumbers.toCharArray()) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(WRONG_NUMBER_RANGE_MSG);
            }
        }
    }

    private void checkDifferentNumbers() {
        List<Character> numbers = new ArrayList<>();
        for (char number : userInputNumbers.toCharArray()) {
            if (!numbers.contains(number)) {
                numbers.add(number);
            } else {
                throw new IllegalArgumentException(NOT_DIFFERENT_NUMBERS_MSG);
            }
        }
    }

    public void validateInputRestartNumber(String userInput) {
        userInputRestartNumber = userInput;

        checkRestartNumberLength();
        checkRestartNumberRange();
    }

    private void checkRestartNumberRange() {
        if (!(userInputRestartNumber.equals(RESTART_NUMBER) || userInputRestartNumber.equals(DO_NOT_RESTART_NUMBER))) {
            throw new IllegalArgumentException(WRONG_RESTART_NUMBER_RANGE_MSG);
        }
    }

    private void checkRestartNumberLength() {
        if (userInputRestartNumber.length() != RESTART_NUMBER_LENGTH) {
            throw new IllegalArgumentException(WRONG_RESTART_NUMBER_LENGTH_MSG);
        }
    }
}
