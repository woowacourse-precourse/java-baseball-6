package baseball.view;

import baseball.domain.BaseBallNumbers;

public interface Player {

    void startBaseballGameMessage();

    BaseBallNumbers readConsole();

    boolean checkRestart();
}
