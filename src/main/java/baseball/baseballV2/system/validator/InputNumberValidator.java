package baseball.baseballV2.system.validator;

import java.util.regex.Pattern;

public class InputNumberValidator {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]+$");
    private final String inputNumber;

    public InputNumberValidator(String input) {
        this.inputNumber = input;
        isNullOrEmpty();
        hasWrongCharacters();
    }

    private void isNullOrEmpty() {
        if (inputNumber == null || inputNumber.isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력되지 않았습니다");
        }
    }

    private void hasWrongCharacters() {
        if (!NUMBER_PATTERN.matcher(inputNumber).matches()) {
            throw new IllegalArgumentException("잚못된 문자가 입력되었습니다");
        }
    }

    // ^[0-9]+$ regex 로 구성되어 있는지 확인
    // null, empty 한 상황인지도 확인하기
}
