package baseball.service;

import baseball.domain.Game;
import baseball.dto.GameResult;

public class GameService {
    private static GameService gameService;

    private Game game;

    private GameService() {}

    public static GameService getInstance() {
        if (gameService == null) {
            gameService = new GameService();
        }
        return gameService;
    }

    public void initGame() {
        game = new Game();
    }

    public GameResult compare(String inputNumber) {
        return null;
    }
}
