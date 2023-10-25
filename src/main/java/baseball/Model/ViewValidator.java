package baseball.Model;

import java.util.Arrays;
import java.util.List;

public class ViewValidator {
    private static final String INTEGER_REGEX = "^[0-9]*$";
    private static final String NEW_GAME_COMMAND = "1";
    private static final String END_COMMAND = "2";

    public static void validateInputValue(String[] tokens) {
        if (Arrays.stream(tokens).anyMatch(ViewValidator::isNotInteger)) {
            throw new IllegalArgumentException("정수만 입력하셔야합니다.");
        }
    }

    private static boolean isNotInteger(String value) {
        return !value.matches(INTEGER_REGEX);
    }

    public static void validateRestartValue(String inputValue) {
        List<String> validCommands = Arrays.asList(NEW_GAME_COMMAND, END_COMMAND);

        if (!validCommands.contains(inputValue)) {
            throw new IllegalArgumentException("재시작 / 종료를 위한 숫자 입력이 잘못 되었습니다.");
        }
    }
}
