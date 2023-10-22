package baseball.domain;

import java.util.List;

public class Game {

    private Balls balls;

    GameStatus gameStatus;

    public Game() {
        init();
    }

    private void init() {
        this.balls = createBalls();
        gameStatus = GameStatus.RUN;
    }

    private Balls createBalls() {
        List<Integer> randomNumbers = RandomNumberGenerator.createRandomNumbers(3, 1, 9);
        return new Balls(randomNumbers);
    }

    public boolean isRun() {
        return GameStatus.isRun(gameStatus);
    }
}
