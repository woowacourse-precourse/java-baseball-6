package baseball;

import baseball.controller.GameController;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.printStart();
        boolean continueRunning = true;

        while (continueRunning) {
            continueRunning = GameController.run();
        }
    }
}
