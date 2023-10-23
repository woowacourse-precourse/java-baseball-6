package baseball;

import baseball.controller.BaseballGame;
import baseball.model.Retry;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.printGameStart();
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.start();
        } while (askRetry());
    }

    public static boolean askRetry() {
        Retry retry = new Retry(InputView.setRetryNumber());

        if (retry.getRetryNumber().equals("1")) {
            return true;
        }

        return false;
    }
}
