package baseball.utils;

import java.util.Arrays;
import java.util.regex.Pattern;
import org.assertj.core.util.VisibleForTesting;

public class BaseballGameConsoleValidator {

    private static final int VALID_INPUT_LENGTH_FOR_RESTART = 1;
    private static final int VALID_INPUT_LENGTH_FOR_PLAYER = 3;

    public static boolean isValidatedInputForRestart(String input) {
        if (!isRightSize(input.length(), VALID_INPUT_LENGTH_FOR_RESTART)) {
            return false;
        }
        return isAbleToParseToNum(input);
    }

    public static boolean isValidatedInputForPlayer(String input) {
        int inputSizeExceptDuplication =
                (int) Arrays.stream(input.split("")).distinct().count();
        if (!isRightSize(inputSizeExceptDuplication, VALID_INPUT_LENGTH_FOR_PLAYER)) {
            return false;
        }
        return isAbleToParseToNum(input);
    }

    @VisibleForTesting
    protected static boolean isRightSize(int inputSize, int rightInputSize) {
        return inputSize == rightInputSize;
    }

    @VisibleForTesting
    protected static boolean isAbleToParseToNum(String input) {
        return Arrays.stream(input.split(""))
                .allMatch(c -> Pattern.matches("^[1-9]", c));
    }
}
