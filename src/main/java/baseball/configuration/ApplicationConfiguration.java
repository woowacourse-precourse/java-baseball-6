package baseball.configuration;

import baseball.controller.GameManager;
import baseball.service.Referee;
import baseball.utils.RestartCommandValidator;
import baseball.view.ConsoleInput;
import baseball.view.Input;

public class ApplicationConfiguration {

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
