package baseball.domain;

public interface Player {

    void showStartGameMessage();

    AnswerNumbers getBaseballNumbers();

    boolean checkRestart();

    void printBaseBallHint(BaseBallHint baseBallHint);

    void printEndGameMessage();
}
