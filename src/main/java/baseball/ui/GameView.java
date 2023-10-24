package baseball.ui;

import baseball.controller.GameController;

public class GameView {

    private final GameController gameController;

    public GameView(GameController gameController) {
        this.gameController = gameController;
    }

    public void start() {
        gameController.start();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

}
