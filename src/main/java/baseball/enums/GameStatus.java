package baseball.enums;

import java.util.Arrays;

public enum GameStatus {
    PLAY("1"),
    EXIT("2");

    private static final GameStatus[] gameStatuses = GameStatus.values();
    private final String status;

    GameStatus(String status) {
        this.status = status;
    }

    public static GameStatus of(String status) {
        return Arrays.stream(gameStatuses)
                .filter(gameStatus -> gameStatus.status.equals(status))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("게임 재시작은 %s, 종료는 %s이어야 합니다.", GameStatus.PLAY.status, GameStatus.EXIT.status))
                );
    }
}
