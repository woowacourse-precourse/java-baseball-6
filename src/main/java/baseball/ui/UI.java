package baseball.ui;

import baseball.BallCount;

public interface UI {
    void startGame();

    String insertNumber();

    void gameResult(BallCount ballCount);

    void winGame();

    String selectGameProgress();




}
