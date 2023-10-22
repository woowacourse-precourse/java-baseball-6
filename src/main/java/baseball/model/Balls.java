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
        for (Ball computerBall : balls) {
            if (computerBall.equals(ball)) {
                return true;
            }
        }
        return false;
    }

    public boolean isBall(Ball ball) {
        for (Ball computerBall : balls) {
            if (computerBall.isBall(ball)) {
                return true;
            }
        }
        return false;
    }

    public List<Ball> getBalls() {
        return balls;
    }

}
