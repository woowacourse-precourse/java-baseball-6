package baseball.Exception;

import java.util.HashSet;
import java.util.Set;

public class UserInputException {

    private final int NUMBER_LENGTH = 3;

    /**
     * 플레이어의 입력값이 3자리인지 검증한다.
     *
     * @param userInput 문자열 형태의 입력값
     */
    private void validateLength(String userInput) {
        if (userInput.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIsNumber(String userInput) {
        if (!userInput.matches("^[0-9]*$")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(String userInput) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            set.add(userInput.charAt(i));
        }

        if (set.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void validateUserInput(String userInput) {
        validateLength(userInput);
        validateIsNumber(userInput);
        validateDuplication(userInput);
    }
}
