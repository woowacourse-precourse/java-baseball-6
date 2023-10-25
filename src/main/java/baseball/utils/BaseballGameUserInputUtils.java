package baseball.utils;

public class BaseballGameUserInputUtils {
    public static final int allowInputLength = 3;
    public static final String allowInputValueRegex = "[1-9]+";

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
}
