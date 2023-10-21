package baseball.config;

import baseball.controller.Dispatcher;
import baseball.controller.GameController;
import baseball.domain.Computer;
import baseball.factory.GameFactory;
import baseball.service.GameService;
import baseball.service.GameServiceImpl;

public class AppConfig {
    
    private Computer computer() {
        return new Computer();
    }

    private GameService gameService() {
        return GameServiceImpl.getInstance();
    }

    private GameController gameController() {
        return GameController.getInstance(computer(), gameService());
    }

    private Dispatcher dispatcher() {
        return Dispatcher.getInstance(gameController());
    }

    public GameFactory gameFactory() {
        return GameFactory.getInstance(dispatcher());
    }

}
