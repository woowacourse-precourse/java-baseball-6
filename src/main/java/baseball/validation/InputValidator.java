package baseball.validation;

import baseball.message.GameMessage;
import java.util.regex.Pattern;

public class InputValidator {

    private final String PATTERN_3_DIGIT_NUM = "^[1-9]{3}$";

    public void validateInputNumber(String input) {
        boolean result = Pattern.matches(PATTERN_3_DIGIT_NUM, input);
        if (!result) {
            throw new IllegalArgumentException(GameMessage.INVALID_NUMBER_FORMAT_ERROR.getMessage());
        }

        Character lastCh = ' ';
        for (int i = 0; i < 3; i++) { // 중복된 숫자가 있는지 검증
            Character ch = input.charAt(i);
            if (ch == lastCh) {
                throw new IllegalArgumentException(GameMessage.DUPLICATE_NUMBER_ERROR.getMessage());
            }
            lastCh = ch;
        }
    }

    public void validateRestartChoice(String input) {
        if (!"1".equals(input) && !"2".equals(input)) {
            throw new IllegalArgumentException(GameMessage.INVALID_RESTART_CHOICE_ERROR.getMessage());
        }
    }
}
