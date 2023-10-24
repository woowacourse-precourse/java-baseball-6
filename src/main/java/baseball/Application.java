package baseball;

import baseball.controller.GameController;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.startGame();
    }
}
