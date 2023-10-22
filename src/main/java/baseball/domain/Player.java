package baseball.domain;

public interface Player {

    void showStartGameMessage();

    BaseBallNumbers readBaseballNumbers();

    boolean checkRestart();

    void printBaseBallHint(BaseBallHint baseBallHint);

    void printEndGameMessage();
}
