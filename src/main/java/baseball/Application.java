package baseball;

import baseball.game.controller.BaseballGameController;
import baseball.game.model.GameModel;
import baseball.game.view.input.InputView;
import baseball.game.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView userInput = new InputView();
        OutputView userOutput = new OutputView();
        GameModel gameModel = new GameModel();

        try {
            BaseballGameController controller = new BaseballGameController(userInput, userOutput, gameModel);
            controller.baseballGame();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
