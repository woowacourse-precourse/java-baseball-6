package baseball.domain;

public interface Game {

    BaseballGame init(Balls answerBalls);

    GameResult getTryResultList(Balls playerBalls);

    void checkGameWin(GameResult gameResult);

    void retryOrEnd(Retry retry);

    boolean isEnd();

    boolean isWin();

    boolean isPlaying();
}
