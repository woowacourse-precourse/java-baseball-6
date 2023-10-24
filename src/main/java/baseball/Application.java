package baseball;

import baseball.controller.BaseballGame;
import baseball.model.AskRetry;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 숫자야구게임 구현

        OutputView.printStartGame();

        do{
            BaseballGame baseballgame = new BaseballGame();
            baseballgame.start();
        } while (askRetry());
    }

    public static boolean askRetry() {
        AskRetry retryNumber = new AskRetry(InputView.setRetryNum());

        if (retryNumber.getRetryNum().equals("1")) {
            return true;
        }

        return false;
    }
}
