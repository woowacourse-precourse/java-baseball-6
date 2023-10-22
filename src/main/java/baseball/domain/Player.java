package baseball.domain;

public interface Player {

    void showStartGameMessage();

    BaseBallNumbers getBaseballNumbers();

    boolean checkRestart();

    void printBaseBallHint(BaseBallHint baseBallHint);

    void printEndGameMessage();
}
