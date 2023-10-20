package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Game.NUMBER_LENGTH;
import static baseball.GameStatus.GAME_OVER;
import static baseball.GameStatus.START;

class Input {

    private String userNumber;

    private static final String ZERO = "0";

    String askUserNumber() {
        userNumber = Console.readLine();
        validateGuessInput();
        return userNumber;
    }

    GameStatus askGameOver() {
        String input = Console.readLine();
        validateRestartInput(input);
        return getGameStatus(input);
    }

    private void validateGuessInput() {
        if (userNumber.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(InputErrorMessage.GUESS);
        }
        if (!isNumeric()) {
            throw new IllegalArgumentException(InputErrorMessage.GUESS);
        }
        if (userNumber.contains(ZERO)) {
            throw new IllegalArgumentException(InputErrorMessage.GUESS);
        }
        if (isDuplicate()) {
            throw new IllegalArgumentException(InputErrorMessage.GUESS);
        }
    }

    private void validateRestartInput(String input) {
        if (!(isStart(input) || isGameOver(input))) {
            throw new IllegalArgumentException(InputErrorMessage.START);
        }
    }

    private GameStatus getGameStatus(String input) {
        if (isStart(input)) {
            return START;
        }
        return GAME_OVER;
    }

    private boolean isNumeric() {
        for (char c : userNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDuplicate() {
        return userNumber.charAt(0) == userNumber.charAt(1)
                || userNumber.charAt(0) == userNumber.charAt(2)
                || userNumber.charAt(1) == userNumber.charAt(2);
    }

    private boolean isStart(String input) {
        return input.equals(START.value);
    }

    private boolean isGameOver(String input) {
        return input.equals(GAME_OVER.value);
    }
}
