package baseball.domain;

import baseball.enums.GameStatus;

public class GameButton {
    private GameStatus gameStatus = GameStatus.PLAY;

    public void turnButton(String code) {
        this.gameStatus = GameStatus.of(code);
    }

    public boolean isPlay() {
        return this.gameStatus.equals(GameStatus.PLAY);
    }
}
