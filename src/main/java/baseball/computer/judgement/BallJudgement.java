package baseball.computer.judgement;

import java.util.ArrayList;
import java.util.List;

public class BallJudgement {
    private final List<Ball> computerBalls = new ArrayList<>();

    public BallJudgement(List<Integer> computerNumbers) {
        for (int i = 0; i < computerNumbers.size(); i++) {
            computerBalls.add(new Ball(computerNumbers.get(i), i+1));
        }
    }


    public BallStatus judgeBall(Ball ball) {
        if (computerBalls.contains(ball)) {
            return BallStatus.STRIKE;
        }
        if(isAnyMatchBallNumber(ball)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean isAnyMatchBallNumber(Ball ball) {
        return computerBalls.stream().anyMatch(computerBall -> computerBall.getNumber() == ball.getNumber());
    }
}
