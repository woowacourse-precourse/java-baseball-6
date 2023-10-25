package baseball.error;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckInputNumbers {
    public static final int INPUT_NUMBER_MAX_LENGTH = 3;
    public static final int CHAR_TO_INT_CONVERT_NUMBER = 48;
    public static final char RANDOM_NUMBER_RANGE_START = '1';
    public static final char RANDOM_NUMBER_RANGE_END = '9';
    public static final String LENGTH_EXCEPTION_MESSAGE = "잘못된 길이의 값이 입력되었습니다.";
    public static final String NON_NUMERIC_EXCEPTION_MESSAGE = "잘못된 값이 입력되었습니다.";
    public static final String DUPLICATE_EXCEPTION_MESSAGE = "중복된 값이 입력되었습니다.";


    public static void checkLength(String input) {
        if (input.length() != INPUT_NUMBER_MAX_LENGTH) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public static List<Integer> checkNumber(String input) {
        List<Integer> userInput = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            if (!(RANDOM_NUMBER_RANGE_START <= inputChar && inputChar <= RANDOM_NUMBER_RANGE_END)) {
                throw new IllegalArgumentException(NON_NUMERIC_EXCEPTION_MESSAGE);
            }
            userInput.add((int) inputChar - CHAR_TO_INT_CONVERT_NUMBER);
        }
        return userInput;
    }

    public static void checkDuplicate(List<Integer> input) {
        Set<Integer> numSet = new HashSet<>(input);

        if (numSet.size() != input.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }
}
