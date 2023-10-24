package baseball.util.validation;

import static baseball.util.Constants.*;

public class restartNumberValidation {
    public static void validateRestartNumber(String input) {
        if (!(input.equals(RESTART) || input.equals(END))) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}
