package baseball;

import baseball.service.GameService;

public class Application {
    private static final GameService gameService = new GameService();

    public static void main(String[] args) {
        gameService.startGame();
    }
}
