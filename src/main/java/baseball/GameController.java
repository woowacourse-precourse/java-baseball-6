package baseball;

import baseball.view.View;

import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private final int SIZE = 3;
    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 9;
    private final int RESTART = 1;
    private final int GAME_OVER = 2;

    Play play = new Play(SIZE);

    public void start() {
        View.start();
        do {
            play.setPlay(SIZE, START_INCLUSIVE, END_INCLUSIVE);
            play.run();
        } while (restart());
        View.end();
    }

    private boolean restart() {
        View.restart();
        int result = Integer.parseInt(Console.readLine());
        if (result != RESTART && result != GAME_OVER) {
            throw new IllegalArgumentException("bad input!!!");
        }
        return result == RESTART;
    }
}
