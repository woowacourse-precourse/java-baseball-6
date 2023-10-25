package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static final String USER_NUMBER_ERROR_MESSAGE = "1~9사이의 숫자를 이용해서 서로 다른 세 자리 숫자를 입력해주세요.";

    public void validate(String userInput) {
        isNumber(userInput);
        hasZero(userInput);
        isDistinctThreeDightNumber(userInput);
    }

    private void isNumber(String userInput) throws IllegalArgumentException {
        try {
            int userInputToInt = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(USER_NUMBER_ERROR_MESSAGE);
        }
    }

    private void hasZero(String userInput) throws IllegalArgumentException {
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) == '0') {
                throw new IllegalArgumentException(USER_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    private void isDistinctThreeDightNumber(String userInput) throws IllegalArgumentException {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException(USER_NUMBER_ERROR_MESSAGE);
        }
        Set<Character> setForDistinctThreeDigitNumber = new HashSet<>();

        for (char userInputToChar : userInput.toCharArray()) {
            setForDistinctThreeDigitNumber.add(userInputToChar);
        }

        if (setForDistinctThreeDigitNumber.size() != 3) {
            throw new IllegalArgumentException(USER_NUMBER_ERROR_MESSAGE);
        }
    }
}
