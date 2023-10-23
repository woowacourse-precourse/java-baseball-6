package baseball.Controller;

import java.util.Set;

public class NumberValidator {
    private static final String WARNING_INPUT_LENGTH = "세 자리의 자연수를 입력하세요.";
    private static final String WARNING_INPUT_DUPLICATE = "서로 다른 세 자리의 자연수만 입력 가능합니다.";
    private static final String WARNING_INPUT_TYPE = "자연수만 입력 가능합니다.";
    private static final String WARNING_INPUT_RANGE = "1~9 사이의 자연수만 입력 가능합니다.";
    private static final int PLAYER_NUMBER_LENGTH = 3;

    public void duplicateCheck(Set<Integer> playerNumbers) {
        if (playerNumbers.size() < PLAYER_NUMBER_LENGTH) {
            throw new IllegalArgumentException(WARNING_INPUT_DUPLICATE);
        }
    }

    public void playerInputCheck(String playerInput) {
        if (playerInput.length() != PLAYER_NUMBER_LENGTH) {
            throw new IllegalArgumentException(WARNING_INPUT_LENGTH);
        }
    }

    public void numberTypeCheck(String playerInput) {
        if (!isInteger(playerInput)) {
            throw new IllegalArgumentException(WARNING_INPUT_TYPE);
        }
    }

    public void numberRangeCheck(String playerInput) {
        if (playerInput.contains("0")) {
            throw new IllegalArgumentException(WARNING_INPUT_RANGE);
        }
    }

    public boolean isInteger(String playerNumbers) {
        try {
            Integer.parseInt(playerNumbers);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }


}
