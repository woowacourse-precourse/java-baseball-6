package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static baseball.constant.MessageConstant.*;
import static baseball.constant.NumberConstant.*;

public class Baseball {

    public void checkInputForNonBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MSG);
        }
    }

    public void checkInputOfDigit(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(NON_DIGIT_EXCEPTION_MSG);
            }
        }
    }

    public void checkListLengthThree(List<Integer> input) {
        if (input.size() != INPUT_LENGTH) {
            throw new IllegalArgumentException(INPUT_LENGTH_EXCEPTION_MSG);
        }
    }

    public void checkDigitInRange(List<Integer> inputList) {
        for (int number : inputList) {
            if (number < MAXIMUM_RANGE_NUMBER || number > MINIMUM_RANGE_NUMBER) {
                throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MSG);
            }
        }
    }
}
