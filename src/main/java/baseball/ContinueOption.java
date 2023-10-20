package baseball;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum ContinueOption {
    RESTART("1"),
    END("2");
    private final String value;

    ContinueOption(String i) {
        this.value = i;
    }

    public String getValue() {
        return value;
    }

    public static void validate(String input) {
        if(!contains(input)) throw new IllegalArgumentException("1 또는 2를 입력해주세요");
    }

    private static boolean contains(String input) {
        return Arrays.stream(ContinueOption.values())
                .map(ContinueOption::getValue)
                .toList()
                .contains(input);
    }

}
