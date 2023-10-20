package baseball.service;

import baseball.dto.GameResult;

public class GameService {
    private static GameService gameService;

    private GameService() {}

    public static GameService getInstance() {
        if (gameService == null) {
            gameService = new GameService();
        }
        return gameService;
    }

    public void initGame() {}

    public GameResult compare(String inputNumber) {
        return null;
    }
}
