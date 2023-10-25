package baseball.model;

import static baseball.model.Constant.BASEBALL_NUM_LENGTH;
import static baseball.model.Constant.EXISTS_SAME_NUM;
import static baseball.model.Constant.INPUT_NOT_NUM;
import static baseball.model.Constant.MAX_NUM_RANGE;
import static baseball.model.Constant.MIN_NUM_RANGE;
import static baseball.model.Constant.NUM_INVALID_LENGTH;
import static baseball.model.Constant.NUM_OUT_OF_RANGE;

import java.util.HashSet;
import java.util.Set;

public class BaseballNumber {

    public BaseballNumber(String userInput) {
        validateLength(userInput);
        validateNumRange(userInput);
        validateIsDigit(userInput);
        validateNotExistsSameNum(userInput);
    }

    private void validateLength(String userInput) {
        if (userInput.length() != BASEBALL_NUM_LENGTH) {
            throw new IllegalArgumentException(NUM_INVALID_LENGTH);
        }
    }

    private void validateNumRange(String userInput) {
        for (char Num : userInput.toCharArray()) {
            int userInputNum = Character.getNumericValue(Num);
            if (userInputNum < MIN_NUM_RANGE || userInputNum > MAX_NUM_RANGE) {
                throw new IllegalArgumentException(NUM_OUT_OF_RANGE);
            }
        }
    }

    private void validateIsDigit(String userInput) {
        for (char userInputChar : userInput.toCharArray()) {
            if (!Character.isDigit(userInputChar)) {
                throw new IllegalArgumentException(INPUT_NOT_NUM);
            }
        }
    }

    private void validateNotExistsSameNum(String userInput) {
        Set<Character> uniqueDigits = new HashSet<>();
        for (char userInputChar : userInput.toCharArray()) {
            if (uniqueDigits.contains(userInputChar)) {
                throw new IllegalArgumentException(EXISTS_SAME_NUM);
            }
            uniqueDigits.add(userInputChar);
        }
    }


}
