package baseball.service;

import baseball.domain.GameStatus;

public class GameService {

    private GameStatus gameStatus;

    private GameService() {
        this.gameStatus = new GameStatus();
    }

    public static GameService startNewGame() {
        return new GameService();
    }
}
