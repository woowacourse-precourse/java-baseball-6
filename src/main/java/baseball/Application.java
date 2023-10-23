package baseball;

import baseball.controller.GameController;
import baseball.service.BallService;
import baseball.view.GameView;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(ballService(), view());
        gameController.startGame();
    }

    private static BallService ballService() {
        return new BallService();
    }
    private static View view() {
        return new GameView();
    }
}
