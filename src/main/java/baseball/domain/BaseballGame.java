package baseball.domain;

public class BaseballGame {
    private final Balls computerBalls;
    private GameState gameState;

    public BaseballGame(Balls computerBalls) {
        this.computerBalls = computerBalls;
        this.gameState = GameState.PLAYING;
    }

    public PlayResult play(Balls userBalls) {
        return computerBalls.play(userBalls);
    }

    public boolean isGameEnd(PlayResult playResult) {
        return playResult.isThreeStrike();
    }
}
