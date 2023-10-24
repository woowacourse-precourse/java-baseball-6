package baseball.util;

import static baseball.constant.MsgConstant.*;
import static baseball.constant.NumConstant.*;

import java.util.List;

public class Validation {

    public static void validateUserInput(String input) {
        validateNumberLength(input);
        List<Integer> UserAnswer = Converter.toIntegerList(input);
        validateNumberDuplicated(UserAnswer);
        validateNumberRange(UserAnswer);
    }

    public static void validateNumberLength(String str) {
        if (str.length() != NUM_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_NUM_LENGTH);
        }
    }

    public static void validateNumberDuplicated(List<Integer> UserInput) {
        if (UserInput.size() != UserInput.stream().distinct().count()) {
            throw new IllegalArgumentException(EXCEPTION_NUM_DUPLICATED);
        }
    }

    public static void validateNumberRange(List<Integer> UserInput) {
        for (int i = 0; i < NUM_LENGTH; i++) {
            if (UserInput.get(i) < MIN_NUMBER || UserInput.get(i) > MAX_NUMBER) {
                throw new IllegalArgumentException(EXCEPTION_NUM_RANGE);
            }
        }
    }

    public static void validateReply(String userInput) {
        if (!userInput.equals(RESTART) && !userInput.equals(END)) {
            throw new IllegalArgumentException(EXCEPTION_REPLY);
        }
    }
}
