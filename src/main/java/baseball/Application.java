package baseball;

import baseball.controller.BaseballGame;
import baseball.model.RetryNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import static constant.MessageList.RESTART;

public class Application {
    public static void main(String[] args) {
        // TODO: 숫자 야구 게임 구현
        OutputView.printGameStartMessage();
        do{
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.start();
        } while(askRestartOrEndGame());

    }
    public static boolean askRestartOrEndGame() {
        RetryNumber retryNumber = new RetryNumber(InputView.restartGameOrNot());
        if (retryNumber.getRetryNumber().equals(RESTART)){
            return true;
        }
        return false;
    }
}
