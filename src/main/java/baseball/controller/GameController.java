package baseball.controller;

import baseball.domain.UserNum;
import baseball.service.GameService;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private GameService gameService;
    public GameController() {
        this.gameService = new GameService();
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            gameService.inputUserNumber();
            gameService.showBallCount();

            if (gameService.checkGameOver()) {
                boolean restart = gameService.askRestartGame();

                if (restart) {
                    restartGame();
                } else if (!restart) {
                    break;
                }
            }
        }
    }

    private void restartGame() {
        gameService = new GameService();
    }
}
