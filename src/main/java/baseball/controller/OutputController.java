package baseball.controller;

import baseball.model.GameResult;
import baseball.view.OutputView;

public class OutputController {
    private final OutputView outputView;

    public OutputController() {
        this.outputView = new OutputView();
    }

    public void displayHint(GameResult result) {
        outputView.showHint(result.getGameResultMessage());
    }

    public void showIntroMessage() {
        outputView.showIntroMessage();
    }

    public void showGameRestartInputMessage() {
        outputView.showGameRestartInputMessage();
    }

    public void showGameInputMessage() {
        outputView.showGameInputMessage();
    }

    public void showGameClearMessage() {
        outputView.showGameClearMessage();
    }
}
