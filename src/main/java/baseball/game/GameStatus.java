package baseball.game;

import java.util.Arrays;

public enum GameStatus {
    PLAY("1"),
    FINISH("2"),
    ;

    private final String value;

    GameStatus(String value) {
        this.value = value;
    }

    public boolean isPlay() {
        return this == PLAY;
    }

    public static GameStatus of(String statusValue) {
        return Arrays.stream(values())
                .filter(gameStatus -> gameStatus.value.equals(statusValue))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("1 또는 2로만 입력할 수 있습니다."));
    }
}
