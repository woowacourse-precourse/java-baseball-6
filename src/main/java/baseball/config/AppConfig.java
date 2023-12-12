package baseball.config;

import baseball.controller.GameController;
import baseball.domain.entity.Referee;
import baseball.service.GameServiceImpl;
import baseball.view.InputView;
import baseball.view.OutputView;

public class AppConfig {

    public static AppConfig getInstance() {
        return new AppConfig();
    }

    public GameController gameController() {
        return new GameController(gameService(), outputView(), inputView());
    }

    public GameServiceImpl gameService() {
        return new GameServiceImpl(referee());
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public Referee referee() {
        return new Referee();
    }
}
