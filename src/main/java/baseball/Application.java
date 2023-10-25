package baseball;

import static baseball.GameController.printInputMessage;
import static baseball.GameController.printStartMessage;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        boolean retry = true;
        printStartMessage();

        while (retry) {
            printInputMessage();
            gameController.run();
            Result.printSuccessMessage();
            Result.printRetryOrExitMessage();
            retry = gameController.retryOrExit();
        }
    }
}