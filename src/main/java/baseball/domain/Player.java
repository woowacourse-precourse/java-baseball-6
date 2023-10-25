package baseball.domain;

public interface Player {

    void showStartGameMessage();

    String getBaseballNumbers();

    boolean checkRestart();

    void printBaseBallHint(BaseBallHint baseBallHint);

    void printEndGameMessage();
}
