package baseball.Controller;

import baseball.Service.GameService;

public class GameController {
    private GameService gameService = new GameService();

    public void run() {
        setGame();
        playGame();
    }

    private void setGame() {
        gameService.setGame();
    }

    private void playGame() {
        gameService.play();
    }

    private void requestGameRetry() {
        gameService.getUserRetryRequest();
    }


}
