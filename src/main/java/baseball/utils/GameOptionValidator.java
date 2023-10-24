package baseball.utils;

import java.util.regex.Pattern;

public class GameOptionValidator {

    public static final String RESTART_GAME_OPTION = "1";
    private static final String RESTART_GAME_OPTION_REGEX = "^[1-2]$";
    private static final String INVALID_RESTART_GAME_OPTION_ERROR_MESSAGE = "재시작 옵션은 1또는 2를 입력해야 합니다.";

    private GameOptionValidator() {
    }

    public static void validateGameRestartOption(String gamOption) {
        isValidRestartOption(gamOption);
    }

    private static void isValidRestartOption(String gamOption) {
        if (!Pattern.matches(RESTART_GAME_OPTION_REGEX, gamOption)) {
            throw new IllegalArgumentException(INVALID_RESTART_GAME_OPTION_ERROR_MESSAGE);
        }
    }
}
