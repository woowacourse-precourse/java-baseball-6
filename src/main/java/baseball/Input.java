package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private String userNumber;

    public static final int NUMBER_LENGTH = 3;
    private static final String ZERO = "0";

    private static final String RESTART = "1";
    public static final String EXIT = "2";

    public String askUserNumber() {
        userNumber = Console.readLine();
        validateGuessInput();
        return userNumber;
    }

    public boolean askRestart() {
        String input = Console.readLine();
        validateRestartInput(input);
        return input.equals(RESTART);
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
        if (!(input.equals(RESTART) || input.equals(EXIT))) {
            throw new IllegalArgumentException(InputErrorMessage.RESTART);
        }
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
}
