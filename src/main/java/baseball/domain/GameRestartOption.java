package baseball.domain;

import java.util.Arrays;
import java.util.stream.Stream;

public enum GameRestartOption {
    RESTART("1"),
    END("2");

    private static final String OPTION_EXCEPTION_MESSAGE =
            String.format("Error : 게임 재시작 여부는 %s 중 하나여야 합니다.", Arrays.toString(GameRestartOption.values()));

    private final String option;

    GameRestartOption(String option) {
        this.option = option;
    }

    public static GameRestartOption from(String option) {
        return Stream.of(GameRestartOption.values())
                .filter(gameRestartOption -> gameRestartOption.option.equals(option))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(OPTION_EXCEPTION_MESSAGE));
    }

    @Override
    public String toString() {
        return option;
    }
}
