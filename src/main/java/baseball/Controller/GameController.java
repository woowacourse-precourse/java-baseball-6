package baseball.Controller;

import baseball.Service.GameService;

public class GameController {
    private GameService gameService = new GameService();

    public void run() {
        do {
            setGame();
            playGame();
        } while (requestGameRetry());
    }

    private void setGame() {
        gameService.setGame();
    }

    private void playGame() {
        gameService.play();
    }

    private boolean requestGameRetry() {
        return gameService.getUserRetryRequest();
    }


}
