package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class BallNumbers {
    private final List<Ball> ballList;

    public BallNumbers(List<Ball> ballList) {
        this.ballList = new ArrayList<>(ballList);
    }

    public Result compare(BallNumbers userBallNumbers) {
        int strike = 0;
        int ball = 0;

        List<Ball> userBallList = userBallNumbers.ballList;
        for (int i = 0; i < ballList.size(); i++) {
            Ball computerBall = ballList.get(i);
            Ball userBall = userBallList.get(i);

            if (computerBall.equals(userBall)) {
                strike++;
            } else if (ballList.contains(userBall)) {
                ball++;
            }
        }

        return new Result(strike, ball);
    }
}
