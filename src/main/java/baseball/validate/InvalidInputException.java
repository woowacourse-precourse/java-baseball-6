package baseball.validate;

import java.util.ArrayList;
import java.util.List;

public class InvalidInputException {
    private static final int GAME_NUMBER_SIZE = 3;
    private static final int RESTART_OR_EXIT_NUMBER_SIZE = 1;
    private static final List<String> RESTART_OR_EXIT_NUMBER_LIST = List.of("1", "2");

    public void checkInputForGame(String playerInputNum, int size) {
        isEmpty(playerInputNum);
        isNull(playerInputNum);
        isNumber(playerInputNum);
        isSingleOrThreeDigitNumber(playerInputNum, size);
        if (size == GAME_NUMBER_SIZE) hasDistinctDigits(playerInputNum);
        if (size == RESTART_OR_EXIT_NUMBER_SIZE) isOneOrTwo(playerInputNum);
    }

    private void isSingleOrThreeDigitNumber(String playerInputNum, int size) {
        if (playerInputNum.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    private void isEmpty(String nums) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void isNull(String nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
    }

    private void isNumber(String nums) {
        try {
            Integer.parseInt(nums);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }

    private void hasDistinctDigits(String nums) {
        List<String> num = new ArrayList<>();
        for (String s : nums.split("")) {
            if (!num.contains(s)) {
                num.add(s);
            }
        }
        if (num.size() != GAME_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void isOneOrTwo(String num) {
        if (!RESTART_OR_EXIT_NUMBER_LIST.contains(num)) {
            throw new IllegalArgumentException();
        }
    }
}
