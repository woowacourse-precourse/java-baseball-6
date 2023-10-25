package baseball.Exception;

import java.util.ArrayList;
import java.util.List;

public class InputException {
    private static final int RANDOM_MIX_NUMBER = 1;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final String LENGTH_ERROR_MESSAGE = "3자리 이상 입력은 불가합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "동일한 숫자는 입력이 불가합니다.";
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "1~9를 제외한 숫자는 입력이 불가합니다";
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "오직 숫자만 입력이 가능합니다.";
    private static final String GAME_DECISION_ERROR_MESSAGE = "1, 2 중 하나만 선택이 가능합니다.";

    public static void lengthException(String input) {
        if (input.length() != 3)
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
    }

    public static void duplicateException(String input) {
        List<Integer> inputSet = new ArrayList<>();
        for (char c : input.toCharArray())
            inputSet.add(Character.getNumericValue(c));
        if (inputSet.size() != input.length())
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
    }
    public static void outOfRangeException(String input) {
        for (String numberStr : input.split("")) {
            int number = Integer.parseInt(numberStr);
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
        notNumericException(input);
        int number = Integer.parseInt(input);
        if (number != 1 && number != 2)
            throw new IllegalArgumentException(GAME_DECISION_ERROR_MESSAGE);
    }
}