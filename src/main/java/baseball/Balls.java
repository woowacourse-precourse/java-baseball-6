package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    public static final int MAX_LENGTH = 3;

    private List<Ball> balls = new ArrayList<>();

    public boolean isFull() {
        return balls.size() == MAX_LENGTH;
    }

    public void add(Ball ball) {
        if (!balls.contains(ball)) {
            balls.add(ball);
        }
    }

    public boolean contains(Ball newBall) {
        return balls.contains(newBall);
    }

    public void createBalls(String input) {
        initBalls();

        for (int i = 0; i < input.length(); i++) {
            Ball ball = new Ball(input.substring(i, i + 1));
            validateNewBall(ball);
            balls.add(ball);
        }
    }

    private void initBalls() {
        balls = new ArrayList<>();
    }

    private void validateNewBall(Ball ball) {
        if (balls.contains(ball)) {
            throw new IllegalArgumentException();
        }
    }

    public CompareResult compare(Balls playerBalls) {
        CompareResult compareResult = new CompareResult();

        for (int i = 0; i < balls.size(); i++) {
            if (balls.get(i).equals(playerBalls.get(i))) {
                compareResult.increaseStrike();
                continue;
            }

            if (balls.contains(playerBalls.get(i))) {
                compareResult.increaseBall();
            }
        }

        return compareResult;
    }

    private Ball get(int i) {
        return balls.get(i);
    }
}
