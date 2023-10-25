package baseball;

import baseball.Controller.BaseballGame;
import baseball.Model.RetryNumber;
import baseball.View.InputView;
import baseball.View.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 숫자 야구 게임 구현
        OutputView.printStartGame();
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.start();
        } while (Retry());
    }

    public static boolean Retry() {
        RetryNumber retryNumber = new RetryNumber(InputView.setRetryNumber());

        if (retryNumber.getRetryNumber().equals("1")) {
            return true;
        }
        return false;
    }

}
