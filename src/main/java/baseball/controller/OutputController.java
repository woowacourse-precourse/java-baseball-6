package baseball.controller;

import baseball.model.SwingResult;
import baseball.view.OutputView;

public class OutputController {

    public void displayHint(SwingResult result) {
        OutputView.showHint(result.getResultMessage());
    }

    public void showIntroMessage() {
        OutputView.showIntroMessage();
    }

    public void showGameRestartInputMessage() {
        OutputView.showGameRestartInputMessage();
    }

    public void showGameInputMessage() {
        OutputView.showGameInputMessage();
    }

    public void showGameClearMessage() {
        OutputView.showGameClearMessage();
    }
}
