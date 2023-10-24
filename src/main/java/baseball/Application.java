package baseball;

import baseball.controller.GameController;
import baseball.domain.GameResult;
import baseball.service.GameService;
import baseball.service.PlayerService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new GameService(), new PlayerService(), new InputView(),
                new OutputView(), new GameResult());
        gameController.startGame();
    }
}
