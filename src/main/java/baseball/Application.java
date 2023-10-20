package baseball;

import baseball.view.console.InputView;
import baseball.view.console.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private InputView inputView() {
        return new InputView();
    }
}
