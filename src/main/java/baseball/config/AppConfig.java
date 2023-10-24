package baseball.config;

import baseball.controller.Dispatcher;
import baseball.controller.GameController;
import baseball.domain.Computer;
import baseball.domain.Referee;
import baseball.factory.GameFactory;
import baseball.service.GameService;
import baseball.service.GameServiceImpl;

public class AppConfig {

    public Computer computer() {
        return new Computer();
    }

    public Referee referee() {
        return new Referee();
    }

    public GameService gameService() {
        return GameServiceImpl.getInstance(referee());
    }

    public GameController gameController() {
        return GameController.getInstance(computer(), gameService());
    }

    public Dispatcher dispatcher() {
        return Dispatcher.getInstance(gameController());
    }

    public GameFactory gameFactory() {
        return GameFactory.getInstance(dispatcher());
    }

}
