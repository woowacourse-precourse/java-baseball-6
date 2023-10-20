package baseball.config;

import baseball.Dispatcher;
import baseball.controller.GameController;
import baseball.domain.Computer;
import baseball.service.GameServiceImpl;
import baseball.service.GameService;

public class AppConfig {

    public Computer computer() {
        return new Computer();
    }

    public GameController gameController() {
        return GameController.getInstance(computer(), gameService());
    }

    public GameService gameService() {
        return GameServiceImpl.getInstance();
    }

    public Dispatcher dispatcher() {
        return Dispatcher.getInstance(gameController());
    }

}
