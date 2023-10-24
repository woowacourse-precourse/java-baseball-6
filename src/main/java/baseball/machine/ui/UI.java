package baseball.machine.ui;

import baseball.machine.count.BallCount;

public interface UI {
    void startGame();

    String getThreeDigitString();

    void gameResult(BallCount ballCount);

    void winGame();

    String getPostGameAction();




}
