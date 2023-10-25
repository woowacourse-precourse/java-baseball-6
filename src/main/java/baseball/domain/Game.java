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

    public Board process(List<BallNumber> ballNumbers) {
        board.reset();
        for (int i = 0; i < BALL_SIZE; i++) {
            BallStatus result = computer.compare(ballNumbers.get(i), i);
            board.scoring(result);
        }

        return board;
    }

    public boolean isEnd(int option) {
        return option == EndOption.END.getValue();
    }

    public boolean isMatch() {
        return board.isMatch(BALL_SIZE);
    }
}
