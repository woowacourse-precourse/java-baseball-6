package baseball.game;

import baseball.Exception.NotEscapeCodeException;
import baseball.Exception.NumberDuplicateException;
import baseball.Exception.QueryMustPossibleIntegerException;
import baseball.Exception.SizeNotMatchException;
import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    static final String DIGIT_PATTERN = "^[1-9]*$";
    static final String ONE_TOW_PATTERN = "^[1-2]*$";

    public static void allPossibleDigit(String qeury) {
        if (!Pattern.matches(DIGIT_PATTERN, qeury)) {
            throw new QueryMustPossibleIntegerException();
        }
    }

    public static void checkRestartString(String inputStatus) {
        checkLength(inputStatus);
        checkValidNumber(inputStatus);
    }

    private static void checkValidNumber(String inputStatus) {
        if (!Pattern.matches(ONE_TOW_PATTERN, inputStatus)) {
            throw new NotEscapeCodeException();
        }
    }

    private static void checkLength(String inputStatus) {
        if (inputStatus.length() != 1) {
            throw new SizeNotMatchException();
        }
    }

    public static void querySizeCheck(String query) {
        if (query.length() != 3) {
            throw new SizeNotMatchException();
        }
    }

    public static void duplicateCheck(List<Integer> generateNumber, int queryElement) {
        if (generateNumber.contains(queryElement)) {
            throw new NumberDuplicateException();
        }
    }
}
