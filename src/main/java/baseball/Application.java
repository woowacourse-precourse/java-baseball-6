package baseball;

import baseball.controller.GameControllerImpl;
import baseball.controller.RandomNumberCreator;
import baseball.controller.Scoring;
import baseball.ui.GameView;
import baseball.ui.InputComponentImpl;
import baseball.ui.ResultFormatStringCreatorImpl;
import baseball.ui.UserInputValidator;

public class Application {
    public static void main(String[] args) {
        new GameView(new GameControllerImpl(new Scoring(RandomNumberCreator.create(3))),
                new UserInputValidator(),
                new InputComponentImpl(), new ResultFormatStringCreatorImpl()).start();
    }
}
