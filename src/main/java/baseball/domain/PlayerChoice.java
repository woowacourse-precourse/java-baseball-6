package baseball.domain;

import java.util.Arrays;
import java.util.Objects;

public enum PlayerChoice {
    RETRY("1"),
    EXIT("2");

    private final String value;
    private static final String NOT_FOUND_ERROR = "1과 2의 숫자만 입력 가능합니다.";

    PlayerChoice(String value) {
        this.value = value;
    }

    public static PlayerChoice from(String value) {
        return Arrays.stream(PlayerChoice.values())
                .filter(it -> Objects.equals(value, it.value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ERROR));
    }
}
