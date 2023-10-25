package baseball.model;

import baseball.util.NumberConst;
import java.util.ArrayList;
import java.util.List;

public class Balls {
    List<Ball> balls = new ArrayList<>();

    public Balls(String numbers) {
        for (int index = 0; index < NumberConst.BALL_LENGTH; index++) {
            balls.add(new Ball(index, getIndexNumber(numbers, index)));
        }
    }

    private static int getIndexNumber(String numbers, int index) {
        return numbers.charAt(index) - '0';
    }

    public boolean isStrike(Ball ball) {
        int ballIndex = ball.getIndex();
        Ball computerBall = balls.get(ballIndex);
        return computerBall.equals(ball);
    }

    public boolean isBall(Ball ball) {
        return balls.stream().anyMatch(computerBall -> computerBall.isBall(ball));
    }

    public List<Ball> getBalls() {
        return balls;
    }

}
