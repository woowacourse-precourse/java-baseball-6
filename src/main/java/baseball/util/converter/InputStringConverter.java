package baseball.util.converter;

import baseball.application.converter.StringConverter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputStringConverter implements StringConverter {

    private static final String ERROR_MESSAGE_NOT_INT = "입력값이 정수가 아닙니다.";

    public int toInt(String value) {
        validateIsInt(value);
        return Integer.parseInt(value);
    }

    public List<Integer> toIntList(String value) {
        String[] parsedStringArray = value.split("");
        return Arrays.stream(parsedStringArray).map((parsedString) -> {
            validateIsInt(parsedString);
            return Integer.valueOf(parsedString);
        }).collect(Collectors.toList());
    }

    private void validateIsInt(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_INT);
        }
    }
}
