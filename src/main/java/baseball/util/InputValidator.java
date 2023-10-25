package baseball.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String INVALID_RESTART_OR_END_NUMBER = "1, 2 가 아닌 잘못된 값을 입력하였습니다.";
    private static final String INVALID_PLAYER_NUMBER  = "잘못 입력하였습니다.";
    private static final Pattern playerNumberValidationPattern = Pattern.compile("^(?!.*(.).*\\1)[1-9]{3}$");
    private static final Pattern oneOrTwoPattern = Pattern.compile("^[12]$");

    public static void isValidPlayerNumber(String number) {
        Matcher matcher = playerNumberValidationPattern.matcher(number);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_PLAYER_NUMBER);
        }
    }

    public static void isValidRestartOrEndNumber(String number) {
        Matcher matcher = oneOrTwoPattern.matcher(number);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_RESTART_OR_END_NUMBER);
        }
    }
}
