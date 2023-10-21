package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private static final int PLAYER_INPUT_LENGTH = 3;
    private static final int INITIAL_INVALID_COUNT = 0;
    private static final String RESTART_FLAG = "1";
    private static final String EXIT_FLAG = "2";
    private static final int VALID_SCORE = 0;
    private static final int INVALID_SCORE = 1;
    private static final char MIN_ALLOWABLE_DIGIT = '1';
    private static final char MAX_ALLOWABLE_DIGIT = '9';

    public String inputNumbers() {
        String playerInputNumber = getPlayerInput();
        isInputNull(playerInputNumber);
        checkInputNumberValidation(playerInputNumber);
        return playerInputNumber;
    }

    public boolean conformGameRestart() {
        String flag = getPlayerInput();
        isInputNull(flag);
        checkFlagValidation(flag);
        return isRestartFlag(flag);
    }

    private String getPlayerInput() {
        String playerInput = readLine();
        return playerInput;
    }

    private void isInputNull(String playerInput) {
        if (playerInput == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInputNumberValidation(String playerInputNumber) {
        if (hasInvalidLength(playerInputNumber) ||
                hasInvalidCharacter(playerInputNumber) ||
                hasDuplicateNumber(playerInputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasInvalidLength(String playerInputNumber) {
        if (playerInputNumber.length() == PLAYER_INPUT_LENGTH) {
            return false;
        }
        return true;
    }

    private boolean hasInvalidCharacter(String playerInputNumber) {
        int invalidCount = INITIAL_INVALID_COUNT;
        for (char playerInputNumberAsChar : playerInputNumber.toCharArray()) {
            invalidCount += isInvalid(playerInputNumberAsChar);
        }
        if (invalidCount == INITIAL_INVALID_COUNT) {
            return false;
        }
        return true;
    }

    private boolean hasDuplicateNumber(String playerInputNumber) {
        Set<Character> inputNumberSet = new HashSet<>();
        for (char playerInputNumberAsChar : playerInputNumber.toCharArray()) {
            inputNumberSet.add(playerInputNumberAsChar);
        }
        return playerInputNumber.length() != inputNumberSet.size();
    }

    private int isInvalid(char playerInputAsChar) {
        if (playerInputAsChar < MIN_ALLOWABLE_DIGIT || playerInputAsChar > MAX_ALLOWABLE_DIGIT) {
            return INVALID_SCORE;
        }
        return VALID_SCORE;
    }

    private void checkFlagValidation(String flag) {
        if (!flag.equals(RESTART_FLAG) && !flag.equals(EXIT_FLAG)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isRestartFlag(String flag) {
        if (flag.equals(RESTART_FLAG)) {
            return true;
        }
        return false;
    }
}
