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

    public Board run(List<Integer> numbers) {
        Balls balls = new Balls(numbers);
        board.reset();
        play(balls);
        return board;
    }

    private void play(Balls balls) {
        for (int i = 0; i < BALL_SIZE; i++) {
            BallNumber ballNumber = balls.get(i);
            BallStatus result = computer.compare(ballNumber, i);
            board.addScore(result);
        }
    }

    public boolean isMatch() {
        return board.isMatch(BALL_SIZE);
    }
}
