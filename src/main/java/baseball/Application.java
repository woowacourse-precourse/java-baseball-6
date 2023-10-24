package baseball;

import baseball.controller.BaseBallGameController;
import baseball.model.TryAgain;
import baseball.model.BaseBallGame;
import baseball.valid.InputValidator;
import baseball.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame baseBallGame = new BaseBallGame();
        InputValidator inputValidator = new InputValidator();
        ConsoleView consoleView = new ConsoleView();
        TryAgain tryAgain = new TryAgain();
        BaseBallGameController baseBallGameController = new BaseBallGameController(consoleView, baseBallGame, inputValidator, tryAgain);
        baseBallGameController.startGame();
    }
}
