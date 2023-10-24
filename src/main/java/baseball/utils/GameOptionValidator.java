package baseball.utils;

import java.util.regex.Pattern;

public class GameOptionValidator {

    private static final String INVALID_RESTART_GAME_OPTION_ERROR_MESSAGE = "재시작 옵션은 1또는 2를 입력해야 합니다.";

    public static void validateGameRestartOption(String gamOption) {
        if (!Pattern.matches("^[1-2]$", gamOption)){
            throw new IllegalArgumentException(INVALID_RESTART_GAME_OPTION_ERROR_MESSAGE);
        }
    }
}
