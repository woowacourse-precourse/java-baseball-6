package baseball;

import baseball.io.InputHandler;
import baseball.io.OutputHandler;
import baseball.model.RetryOption;
import baseball.service.BaseballGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputHandler.printGameStart();
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.start();
        } while (askRetry());
    }

    public static boolean askRetry() {
        RetryOption retryOption = InputHandler.getRetryOption();
        return retryOption.getValue().equals("1");
    }
}
