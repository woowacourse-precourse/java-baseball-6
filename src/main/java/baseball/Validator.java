package baseball;

import java.util.regex.Pattern;

public class Validator {
    private static final int NUMBER_LENGTH = 3;

    private static final String DUPLICATE_ERROR = "중복된 숫자가 존재합니다.";
    private static final String LENGTH_ERROR = "입력 숫자의 길이가 3이 아닙니다.";
    private static final String OUT_RANGE_ERROR = "1과 9사이의 숫자가 아닙니다.";

    private static final Pattern INPUT_REGEX = Pattern.compile("[1-9]{3}");
    private static final Pattern INPUT_REPEAT = Pattern.compile("^(?!.*(\\d).*\\1)[1-9]{3}$");

    public void validateInputLength(String input) {
        if (input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR);
        }
    }

    public void validateInputRegex(String input) {
        if (!INPUT_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(OUT_RANGE_ERROR);
        }
    }

    public void validateInputRepeat(String input) {
        if (!INPUT_REPEAT.matcher(input).matches()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    public void validateInput(String input) {
        validateInputLength(input);
        validateInputRegex(input);
        validateInputRepeat(input);
    }
}
