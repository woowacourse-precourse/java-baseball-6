package baseball.utils;

public class BaseballGameUserInputUtils {
    public static final int allowInputLength = 3;
    public static final String allowInputValueRegex = "[1-9]+";
    public static final String RESTART_GAME_INPUT_COMMAND = "1";
    public static final String EXIT_GAME_INPUT_COMMAND = "2";

    public static boolean isValidInputLength(String input) {
        return (input.length() == allowInputLength);
    }

    public static boolean isValidInputValue(String input) {
        return input.matches(allowInputValueRegex);
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
