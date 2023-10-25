package baseball.utils;

public class BaseballGameUserInputUtils {
    private static final int ALLOW_INPUT_LENGTH = 3;
    private static final String ALLOW_INPUT_VALUE_REGEX = "[1-9]+";
    public static final String RESTART_GAME_INPUT_COMMAND = "1";
    public static final String EXIT_GAME_INPUT_COMMAND = "2";

    public static boolean isValidInputLength(String input) {
        return (input.length() == ALLOW_INPUT_LENGTH);
    }

    public static boolean isValidInputValue(String input) {
        return input.matches(ALLOW_INPUT_VALUE_REGEX);
    }

    public static boolean isInputContainsUniqueValue(String input) {
        String tmp = "";

        for (char c : input.toCharArray()) {
            if (!tmp.contains(String.valueOf(c))) {
                tmp += String.valueOf(c);
            }
        }

        return (tmp.length() == input.length());
    }

    public static boolean isValidExitOrRestartCommand(String input) {
        return (input != null && (input.equals(RESTART_GAME_INPUT_COMMAND) || input.equals(EXIT_GAME_INPUT_COMMAND)));
    }
}
