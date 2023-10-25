package baseball.domain;

public class BaseballGame {

    private final Balls answerBall;
    private GameStatus gameStatus;

    private BaseballGame(Balls answerBalls, GameStatus gameStatus) {
        this.answerBall = answerBalls;
        this.gameStatus = gameStatus;
    }

    public static BaseballGame init(Balls answerBalls) {
        return new BaseballGame(answerBalls, GameStatus.PLAYING);
    }

    public GameResult getTryResultList(Balls playerBalls) {
        return answerBall.getTryResultList(playerBalls);
    }

    public void checkGameWin(GameResult gameResult) {
        if (gameResult.isAllStrike()) {
            gameStatus = GameStatus.WIN;
        }
    }

    public void retry(Retry retry) {
        if (retry.isQuit()) {
            gameStatus = GameStatus.END;
        }
    }

    public boolean isEnd() {
        return gameStatus.isEnd();
    }

    public boolean isWin() {
        return gameStatus.isWin();
    }

    public boolean isPlaying() {
        return gameStatus.isPlaying();
    }
}
