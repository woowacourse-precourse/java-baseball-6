package baseball.domain;

public class BaseballGame {
    private final Balls computerBalls;

    public BaseballGame(Balls computerBalls) {
        this.computerBalls = computerBalls;
    }

    public PlayResult play(Balls userBalls) {
        return computerBalls.play(userBalls);
    }
}
