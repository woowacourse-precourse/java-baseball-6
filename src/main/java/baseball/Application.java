package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean valid = false;
        InputView inputView = new InputView();
        while (!valid) {
            OutputView outputView = new OutputView(inputView);
            valid = outputView.start();
        }
        inputView.close();
    }
}
