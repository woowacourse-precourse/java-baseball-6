package baseball;

import baseball.controller.ComputerController;
import baseball.controller.GameProgressController;
import baseball.controller.RandomUtility;
import baseball.controller.UserInputValidator;
import baseball.model.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameProgressController gameProgressController = new GameProgressController();
        gameProgressController.progressGame();
    }
}
