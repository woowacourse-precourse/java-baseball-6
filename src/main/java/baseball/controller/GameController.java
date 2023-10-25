package baseball.controller;

import baseball.view.GameView;

public class GameController {

    private final GameView gameView;

    public GameController(GameView gameView) {
        this.gameView = gameView;
    }

    // run: 전체 게임을 시작한다.
    public void run() throws IllegalArgumentException {
        Boolean isContinue = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (isContinue) {
            gameView.setNewGame();
            gameView.doGame();
            isContinue = gameView.askContinue();
        }
    }
}
