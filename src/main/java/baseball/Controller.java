package baseball;

import baseball.config.GameConfiguration;
import baseball.service.GameService;

public class Controller {
    final int NUMBER_OF_DIGIT = 3;
    final int MINIMUM_NUMBER = 1;
    final int MAXIMUM_NUMBER = 9;
    final int RESTART_GAME = 1;
    final int END_GAME = 2;

    GameService gameService = new GameService();

    public void run() throws IllegalArgumentException {
        setGame();
        startGame();
        endGame();
        Retry();
    }

    private void setGame() {
        new GameConfiguration(MINIMUM_NUMBER, MAXIMUM_NUMBER, NUMBER_OF_DIGIT);
    }

    private void startGame() throws IllegalArgumentException {
        gameService.playGame();
    }

    private void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


    private void Retry() {
    }


}
