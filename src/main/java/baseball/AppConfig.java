package baseball;

import baseball.controller.GameManager;
import baseball.controller.RestartCommandValidator;
import baseball.service.Referee;
import baseball.view.ConsoleInput;
import baseball.view.Input;

public class AppConfig {

    public GameManager gameController() {
        return new GameManager(restartCommandValidator(), referee(), consoleInput());
    }

    private RestartCommandValidator restartCommandValidator() {
        return new RestartCommandValidator();
    }

    private Referee referee() {
        return new Referee();
    }

    private Input consoleInput() {
        return new ConsoleInput();
    }
}
