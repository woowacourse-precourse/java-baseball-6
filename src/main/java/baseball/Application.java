package baseball;

import baseball.util.MessageUtil;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.readBaseballNumber();
        inputView.readRetryCommand();
    }
}
