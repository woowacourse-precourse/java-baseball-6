package baseball;

import baseball.controller.GameController;
import baseball.domain.Computer;
import baseball.domain.Grade;
import baseball.domain.Player;
import baseball.utils.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        InputValidator inputValidator = new InputValidator();
        Player player = new Player();
        Grade grade = new Grade();
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        GameController game = new GameController(computer, player, grade, outputView, inputView, inputValidator);

        game.start();
    }
}
