package baseball.service;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private static final int PLAYER_NUMBER_DIGIT = 3;

    public List<Integer> proceedValidation(String playerInput) {
        validatePlayerInput(playerInput);
        return changeToPlayerNumbers(playerInput);
    }

    private void validatePlayerInput(String playerInput) {
        if (!isThreeDigits(playerInput) || !isOneToNineNumber(playerInput) || !isDuplicateNumber(playerInput)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isThreeDigits(String playerInput) {
        return playerInput.length() == PLAYER_NUMBER_DIGIT;
    }

    private boolean isOneToNineNumber(String playerInput) {
        for (int i = 0; i < PLAYER_NUMBER_DIGIT; i++) {
            int nowNum = playerInput.charAt(i) - '0';
            if (nowNum <= 0 || nowNum > 9) {
                return false;
            }
        }
        return true;
    }

    private boolean isDuplicateNumber(String playerInput) {
        for (int i = 0; i < PLAYER_NUMBER_DIGIT; i++) {
            for (int j = i + 1; j < PLAYER_NUMBER_DIGIT; j++) {
                if (playerInput.charAt(i) == playerInput.charAt(j))
                    return false;
            }
        }
        return true;
    }

    private List<Integer> changeToPlayerNumbers(String playerInput) {
        List<Integer> playerNumbers = new ArrayList<>();
        for (int i = 0; i < PLAYER_NUMBER_DIGIT; i++) {
            playerNumbers.add(playerInput.charAt(i) - '0');
        }
        return playerNumbers;
    }
}
