package baseball.controller;

import baseball.model.Hint;
import baseball.view.OutputView;

public class OutputController {

    public void displayHint(Hint hint) {
        OutputView.showHint(hint.getHintMessage());
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
