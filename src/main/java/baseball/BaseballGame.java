package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {

    private static final Computer baseballComputer = new Computer();

    public static void startGame() {
        OutputView.printGameStart();
        do {
            baseballComputer.generateNumber();
            baseballComputer.addUserNumber(InputView.inputUserNumber());
        } while (true);
    }
}
