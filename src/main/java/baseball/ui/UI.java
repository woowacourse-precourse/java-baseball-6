package baseball.ui;

import baseball.BallCount;

public interface UI {
    void startGame();

    String getThreeDigitString();

    void gameResult(BallCount ballCount);

    void winGame();

    String getPostGameAction();




}
