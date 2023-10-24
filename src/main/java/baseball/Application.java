package baseball;

import baseball.controller.GameController;
import baseball.service.GameServiceImpl;
import baseball.view.HintView;
import baseball.view.InputView;
import baseball.view.StartView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new StartView(),
                new InputView(),
                new HintView(),
                new GameServiceImpl());
        gameController.play();
    }
}