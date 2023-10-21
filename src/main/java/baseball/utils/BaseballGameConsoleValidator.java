package baseball.utils;

import java.util.Arrays;
import java.util.regex.Pattern;
import org.assertj.core.util.VisibleForTesting;

public class BaseballGameConsoleValidator {
    public static boolean isValidatedInput(String input, int rightInputSize) {
        if (input.length() != rightInputSize) {
            return false;
        }
        return isAbleToParseToNum(input);
    }

    @VisibleForTesting
    protected static boolean isAbleToParseToNum(String input) {
        return Arrays.stream(input.split(""))
                .allMatch(c -> Pattern.matches("^[1-9]", c));
    }
}
