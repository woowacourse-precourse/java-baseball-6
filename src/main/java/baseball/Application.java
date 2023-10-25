package baseball;

import baseball.controller.GameController;
;
import baseball.vailidation.NumberValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        OutputView.printGameStart();
        do {
            GameController baseballGame = new GameController();
            baseballGame.start();
        } while(askRetry());

    }
    public static boolean askRetry() {
        String retryInput = InputView.restart();
        return NumberValidator.checkRestartFormat(retryInput);
    }

}