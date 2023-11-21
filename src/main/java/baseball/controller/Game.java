package baseball.controller;

import baseball.domain.Baseball;
import baseball.view.InputView;

public class Game {
    Baseball baseball;

    public void run() {
        start();
        play();
    }

    private void start() {
        InputView.printStart();
    }

    private void play() {
        baseball = new Baseball();
    }

}
