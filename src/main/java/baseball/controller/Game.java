package baseball.controller;

import baseball.domain.Baseball;
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

    private void play() {
        baseball = new Baseball();
    }

}
