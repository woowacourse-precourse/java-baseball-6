package baseball.model;

import static baseball.ErrorMessage.INVALID_INPUT;

public class GameContinueNumber {

    private static final String CONTINUE_NUMBER = "1";
    private static final String END_NUMBER = "2";

    private String gameNumber;

    private GameContinueNumber(final String gameNumber) {
        this.gameNumber = gameNumber;
    }

    public static GameContinueNumber createDefault() {
        return new GameContinueNumber(CONTINUE_NUMBER);
    }

    public boolean canContinueGame() {
        return gameNumber.equals(CONTINUE_NUMBER);
    }

    public void changeNumber(final String number) {
        validateNumber(number);
        gameNumber = number;
    }

    private void validateNumber(final String number) {
        if (isValidNumberInput(number)) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    private static boolean isValidNumberInput(final String number) {
        return !number.equals(CONTINUE_NUMBER) && !number.equals(END_NUMBER);
    }
}
