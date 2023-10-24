package baseball.game.enums;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

public enum BaseballGameRestarts {

    GAME_RESTART(1),
    GAME_FINISH(2),
    ;

    private static final String MUST_INPUT_RESTARTS_MESSAGE = "1 또는 2를 입력해야 합니다.";

    private final int inputRestart;

    BaseballGameRestarts(int inputRestart) {
        this.inputRestart = inputRestart;
    }

    public static BaseballGameRestarts find(Integer restartNumber) {
        return Arrays.stream(BaseballGameRestarts.values())
                .filter(matchedConstantBy(restartNumber))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(MUST_INPUT_RESTARTS_MESSAGE));
    }

    private static Predicate<BaseballGameRestarts> matchedConstantBy(
            Integer restartNumber) {
        return gameRestart -> Objects.equals(gameRestart.inputRestart, restartNumber);
    }

    public boolean wantToFinish() {
        return this == GAME_FINISH;
    }

}
