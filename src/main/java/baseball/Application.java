package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        outputView.printStartGame();

        InputView inputView = new InputView();
        inputView.readGameNumber();

    }
}
