package baseball.model;

import baseball.enums.GameStatus;

public class Game {
    private GameStatus status;

    public Game() {
        this.status = GameStatus.IN_PROGRESS;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void endGame() {
        this.status = GameStatus.END;
    }
}
