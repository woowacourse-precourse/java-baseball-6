package baseball;

import baseball.controller.GameController;
import baseball.domain.BaseballGame;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BaseballGame baseballGame = new BaseballGame();
        GameService gameService = new GameService(baseballGame);
        GameController gameController = new GameController(gameService, inputView, outputView);
        gameController.run();
    }
}
