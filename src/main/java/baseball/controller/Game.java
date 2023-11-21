package baseball.controller;

import baseball.domain.Baseball;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
    Baseball baseball;

    public void run() {
        start();
        play();
    }

    private void start() {
        OutputView.printStart();
    }

    private int requestNumber() {
        OutputView.printRequestNumber();
        return InputView.readUserNum();
    }

    private void play() {
        baseball = new Baseball();
        int userNumber = requestNumber();
    }


}
