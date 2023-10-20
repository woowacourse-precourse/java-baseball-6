package baseball.service;

public class GameService {
    private static GameService gameService;

    private GameService() {}

    public static GameService getInstance() {
        if (gameService == null) {
            gameService = new GameService();
        }
        return gameService;
    }
}
