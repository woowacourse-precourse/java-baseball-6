package baseball;

import baseball.view.OutputView;

public class BaseballGame {

    private final OutputView outputView;

    public BaseballGame(OutputView outputView) {
        this.outputView = outputView;
    }

    public void start() {
        outputView.printStartMessage();

        do {
            play();
        } while (isContinue());
    }

    private void play() {
    }

    private boolean isContinue() {
        return false;
    }
}
