package baseball;

import baseball.controller.GameManager;
import baseball.controller.RestartCommandValidator;
import baseball.service.Judgement;
import baseball.view.ConsoleInput;
import baseball.view.Input;

public class AppConfig {

    public GameManager gameController() {
        return new GameManager(restartCommandValidator(), judgement(), consoleInput());
    }

    private RestartCommandValidator restartCommandValidator() {
        return new RestartCommandValidator();
    }

    private Judgement judgement() {
        return new Judgement();
    }

    private Input consoleInput() {
        return new ConsoleInput();
    }
}
