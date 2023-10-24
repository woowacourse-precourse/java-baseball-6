package baseball.baseballV2.system.validator;

import java.util.regex.Pattern;

public class InputNumberValidator {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]+$");
    public static final String NOTHING_INPUT_ERROR = "아무것도 입력되지 않았습니다";
    public static final String WRONG_INPUT_ERROR = "잚못된 문자가 입력되었습니다";
    private final String inputNumber;

    public InputNumberValidator(String input) {
        this.inputNumber = input;
        isNullOrEmpty();
        hasWrongCharacters();
    }

    private void isNullOrEmpty() {
        if (inputNumber == null || inputNumber.isEmpty()) {
            throw new IllegalArgumentException(NOTHING_INPUT_ERROR);
        }
    }

    private void hasWrongCharacters() {
        if (!NUMBER_PATTERN.matcher(inputNumber).matches()) {
            throw new IllegalArgumentException(WRONG_INPUT_ERROR);
        }
    }
}
