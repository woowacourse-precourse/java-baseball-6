package baseball.exception;

import java.util.*;

public class InputException {
    public static final int RANDOM_MIX_NUMBER = 1;
    public static final int RANDOM_MAX_NUMBER = 9;
    private static final String LENGTH_ERROR_MESSAGE = "3글자가 아닙니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "중복된 숫자가 있습니다.";
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "1~9의 범위를 벗어난 숫자가 있습니다.";
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "숫자만 입력 가능합니다.";
    private static final String GAME_DECISION_ERROR_MESSAGE = "1과 2 둘 중 하나만 선택 가능합니다.";

    public static void lenException(String input) {
        if (input.length() != 3)
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
    }

    public static void duplicateException(List<Integer> input) {
        Set<Integer> inputSet = new HashSet<>(input);
        if (inputSet.size() != input.size())
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
    }

    public static void outOfRangeException(List<Integer> input) {
        for (int number : input) {
            if (number < RANDOM_MIX_NUMBER || number > RANDOM_MAX_NUMBER)
                throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    public static void notNumericException(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR_MESSAGE);
        }
    }

    public static void gameDecisionException(String input) {
        int number = Integer.parseInt(input);
        if (number !=1 && number != 2)
            throw new IllegalArgumentException(GAME_DECISION_ERROR_MESSAGE);

    }
}
