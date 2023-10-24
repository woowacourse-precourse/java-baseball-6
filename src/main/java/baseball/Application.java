package baseball;

import baseball.controller.GameController;
import baseball.controller.InputController;
import baseball.domain.Game;
import baseball.domain.GameScore;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(inputController(), outputView(), inputView(), gameService());
        gameController.intro();
        gameController.run();
    }

    private static InputController inputController() {
        return new InputController();
    }

    private static OutputView outputView() {
        return new OutputView();
    }

    private static InputView inputView() {
        return new InputView();
    }

    private static GameService gameService() {
        return new GameService(game(), gameScore());
    }

    private static Game game() {
        return new Game();
    }

    private static GameScore gameScore() {
        return new GameScore();
    }
}
