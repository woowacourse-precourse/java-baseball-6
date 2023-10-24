package baseball;

import baseball.controller.BaseballGame;
import baseball.model.RetryNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printGameStart();
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.start();
        } while (askRetry());
    }

    private static boolean askRetry() {
        RetryNumber retryNumber = new RetryNumber(InputView.setRetryNumber());

        if (retryNumber.getRetryNumber().equals("1")) {
            return true;
        }
        return false;
    }
}
