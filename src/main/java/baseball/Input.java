package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String guess;

    public static final int GUESS_INPUT_LENGTH = 3;
    private static final String ZERO = "0";

    private static final String RESTART = "1";
    public static final String EXIT = "2";

    public static void askGuess() {
        guess = Console.readLine();
        validateGuessInput();
    }

    public static boolean askRestart() {
        String input = Console.readLine();
        validateRestartInput(input);
        return input.equals(RESTART);
    }

    private static void validateGuessInput() {
        if (guess.length() != GUESS_INPUT_LENGTH) {
            throw new IllegalArgumentException(InputErrorMessage.GUESS);
        }
        if (!isNumeric()) {
            throw new IllegalArgumentException(InputErrorMessage.GUESS);
        }
        if (guess.contains(ZERO)) {
            throw new IllegalArgumentException(InputErrorMessage.GUESS);
        }
        if (isDuplicate()) {
            throw new IllegalArgumentException(InputErrorMessage.GUESS);
        }
    }

    private static void validateRestartInput(String input) {
        if (!(input.equals(RESTART) || input.equals(EXIT))) {
            throw new IllegalArgumentException(InputErrorMessage.RESTART);
        }
    }

    private static boolean isNumeric() {
        for (char c : guess.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDuplicate() {
        return guess.charAt(0) == guess.charAt(1)
                || guess.charAt(0) == guess.charAt(2)
                || guess.charAt(1) == guess.charAt(2);
    }
}
