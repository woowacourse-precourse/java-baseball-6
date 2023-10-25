package baseball.domain;

import static baseball.domain.Balls.createRandomBalls;

import java.util.List;

public class Game {

    private static final int BALL_SIZE = 3;

    private Balls computer;
    private Board board;

    public void init() {
        computer = createRandomBalls();
        board = new Board();
    }

    public boolean isEnd(int option) {
        return EndOption.isEnd(option);
    }

    public Board play(List<Integer> numbers) {
        Balls balls = new Balls(numbers);
        board.reset();
        for (int i = 0; i < BALL_SIZE; i++) {
            BallStatus result = computer.compare(balls.get(i), i);
            board.scoring(result);
        }
        return board;
    }

    public boolean isMatch() {
        return board.isMatch(BALL_SIZE);
    }
}
