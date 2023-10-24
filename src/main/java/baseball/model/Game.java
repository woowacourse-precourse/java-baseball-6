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

    public void pauseGame() {
        this.status = GameStatus.PAUSE;
    }

    public void restartGame() {
        this.status = GameStatus.IN_PROGRESS;
    }

    public void endGame() {
        this.status = GameStatus.END;
    }
}
