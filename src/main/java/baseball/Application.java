package baseball;

import baseball.controller.GameController;
import baseball.property.GameCondition;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView.outputForGameStart();
        GameController.playingBaseballGame(GameCondition.CONTINUE);
    }
}
