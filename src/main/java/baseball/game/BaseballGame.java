package baseball.game;

import baseball.view.OutputView;

public class BaseballGame {

    private OutputView outputView;

    public BaseballGame(OutputView outputView) {
        this.outputView = outputView;
    }

    public void start() {
        outputView.showStartMessage();
    }

    public void process() {
        outputView.showInputNumberMessage();
    }

    public void checkRestart() {
        outputView.showOptionMenu();
    }
}
