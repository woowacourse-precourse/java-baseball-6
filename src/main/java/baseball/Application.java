package baseball;

import baseball.util.MessageUtil;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        outputView.printGameStartMessage();
        inputView.readBaseballNumber();
        inputView.readRetryCommand();
    }
}
