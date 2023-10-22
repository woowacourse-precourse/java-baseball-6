package baseball.domain;

import java.util.Arrays;

public class GameButton {
    private GameStatus gameStatus = GameStatus.PLAY;

    public void changeButton(String code) {
        if (!gameStatus.code.equals(code)) {
            this.gameStatus = GameStatus.of(code);
        }
    }

    public boolean isPlay() {
        return this.gameStatus.equals(GameStatus.PLAY);
    }

    private enum GameStatus {
        PLAY("1"),
        EXIT("2");

        private static final GameStatus[] gameStatuses = GameStatus.values();
        private final String code;

        GameStatus(String code) {
            this.code = code;
        }

        private static GameStatus of(String code) {
            return Arrays.stream(gameStatuses)
                    .filter(gameStatus -> gameStatus.code.equals(code))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(
                            String.format("게임 재시작은 %s, 종료는 %s이어야 합니다.", GameStatus.PLAY.code, GameStatus.EXIT.code))
                    );
        }
    }
}
