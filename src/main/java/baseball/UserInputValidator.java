package baseball;

import java.util.ArrayList;
import java.util.List;

public class UserInputValidator {

    private static final String NOT_DIFFERENT_NUMBERS_MSG = "서로 다른 숫자를 입력해주세요.";
    private static final String WRONG_NUMBER_RANGE_MSG = "1 ~ 9까지의 숫자를 입력해주세요.";
    private static final String WRONG_NUMBER_LENGTH_MSG = "3 자리의 숫자를 입력해주세요.";
    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static String userInputNumbers = "";

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
}
