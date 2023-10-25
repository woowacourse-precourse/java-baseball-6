package baseball.model;

import baseball.enums.GameStatus;

public class Game {
    private GameStatus status;

    private Game(GameStatus status) {
        this.status = status;
    }

    public static Game start() {
        return new Game(GameStatus.IN_PROGRESS);
    }

    public void end() {
        this.status = GameStatus.END;
    }

    public boolean isEnd() {
        return this.status == GameStatus.END;
    }
}
