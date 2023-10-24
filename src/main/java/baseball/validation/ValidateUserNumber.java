package baseball.validation;

import static baseball.constants.CompareConstant.VALID_NUMBER_SIZE;
import static baseball.constants.CompareConstant.ZERO;
import static baseball.constants.ErrorMessage.HAS_DUPLICATE;
import static baseball.constants.ErrorMessage.HAS_ZERO;
import static baseball.constants.ErrorMessage.NOT_NUMBER;
import static baseball.constants.ErrorMessage.NOT_TRIPLE_SIZE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ValidateUserNumber {

    public static void validateUserNumber(String userInput, ArrayList<Integer> userNumber) {
        isNumber(userInput, userNumber);
        isTripleSize(userNumber);
        hasNoDuplicate(userNumber);
        hasNoZero(userNumber);
    }

    private static void hasNoZero(ArrayList<Integer> userNumber) {
        for (int number : userNumber) {
            if (number == ZERO) {
                throw new IllegalArgumentException(HAS_ZERO);
            }
        }
    }

    private static void hasNoDuplicate(ArrayList<Integer> userNumber) {
        Set<Integer> set = new HashSet<>(userNumber);
        if (set.size() != userNumber.size()) {
            throw new IllegalArgumentException(HAS_DUPLICATE);
        }
    }

    private static void isTripleSize(ArrayList<Integer> userNumber) {
        if (userNumber.size() != VALID_NUMBER_SIZE) {
            throw new IllegalArgumentException(NOT_TRIPLE_SIZE);
        }
    }

    private static void isNumber(String userInput, ArrayList<Integer> userNumber) {
        for (int i = 0; i < userInput.length(); i++) {
            char numberChar = userInput.charAt(i);
            if (!Character.isDigit(numberChar)) {
                throw new IllegalArgumentException(NOT_NUMBER);
            }
            int digit = Character.getNumericValue(numberChar);
            userNumber.add(digit);
        }
    }
}
