package baseball;

import static baseball.BaseballConstants.*;

public class InputValueValidator {

    public void validateInputValue(String userNumber) {
        validateNumber(userNumber);
    }

    private static void validateNumber(String userNumber) {
        if (userNumber.length() != VALID_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }

        for (char userNum : userNumber.toCharArray()) {
            if (userNum < MIN_DIGIT || userNum > MAX_DIGIT) {
                throw new IllegalArgumentException();
            }
        }
    }
}
