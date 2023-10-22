package baseball.view;

import baseball.domain.BaseBallHint;
import baseball.domain.BaseBallNumbers;

public interface Player {

    void showStartGameMessage();

    BaseBallNumbers readBaseballNumbers();

    boolean checkRestart();

    void printBaseBallHint(BaseBallHint baseBallHint);

    void printEndGameMessage();
}
