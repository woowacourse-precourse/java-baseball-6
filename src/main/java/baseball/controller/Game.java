package baseball.controller;

import baseball.domain.Baseball;

public class Game {
    Baseball baseball;

    public void run() {
        play();
    }

    private void play() {
        baseball = new Baseball();
    }
}
