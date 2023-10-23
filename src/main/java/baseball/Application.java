package baseball;

import baseball.controller.GameProcessController;
import baseball.model.RetryGame;
import baseball.view.MessageOutputView;
import baseball.view.UserInputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MessageOutputView.gameStartMessage();
        do {
            GameProcessController gameProcess = new GameProcessController();
            gameProcess.startGame();
        } while (retryGame());
    }

    public static boolean retryGame() {
        RetryGame retryNumber = new RetryGame(UserInputView.setInputRetry());

        if (retryNumber.getRetryNumber().equals("1")) {
            return true;
        }

        return false;
    }
}
