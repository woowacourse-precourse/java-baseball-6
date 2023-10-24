package baseball;

import baseball.controller.BaseBallGame;
import baseball.model.RetryNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printGameStart();
        do {
            BaseBallGame baseBallGame = new BaseBallGame();
            baseBallGame.start();
        } while (askRetry());
    }

    public static boolean askRetry() {
        RetryNumber retryNumber = new RetryNumber(InputView.getreStartGame());

        if(retryNumber.getRetryNumber().equals("1")) {
            return true;
        }
        return false;
    }
}
