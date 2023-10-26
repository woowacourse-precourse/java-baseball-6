package baseball.util;

import java.util.List;
import java.util.stream.Stream;

public class TypeConverter {

    private static final String BLANK = "";
    private static final String WRONG_INPUT_MSG = "[ERROR] 숫자만 입력해주세요.";

    public static List<Integer> toList(String input) {
        try {
            return Stream.of(input.split(BLANK))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_INPUT_MSG);
        }
    }
}