package baseball.domain.entity.game;

import baseball.utils.messages.ExceptionMessages;
import java.util.Arrays;

public enum GameStatus {
    CONTINUE("0"),
    RESTART("1"),
    OVER("2");

    public static final String WRONG_INPUT_OPTION_EX_MESSAGE = "재시작은 1 또는 2를 입력해야 합니다. \n";

    private final String option;

    GameStatus(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public static GameStatus from(String command) {
        return Arrays.stream(GameStatus.values())
            .filter(value -> value.option.equals(command))
            .findAny()
            .orElseThrow(
	() -> new IllegalArgumentException(ExceptionMessages.INVALID_OPTION.getMessage()));
    }

    public boolean isOver() {
        return this== OVER;
    }
}